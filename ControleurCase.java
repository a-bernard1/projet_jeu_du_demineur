import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class ControleurCase implements MouseListener{
    private Grille grille;
    private Case[][] cases;
    private int x, y;
    private JLabel labelMines;
    private Jeu jeu;
    
    public ControleurCase(Grille grille, Case[][] cases, int x, int y, JLabel labelMines, Jeu jeu){
        this.grille = grille;
        this.cases = cases;
        this.x = x;
        this.y = y;
        this.labelMines = labelMines;
        this.jeu = jeu;
    }

    @Override
    public void mousePressed(MouseEvent e){
        if(e.getButton()==MouseEvent.BUTTON1){
            if(grille.estPartieTerminee()){
                return;
            }
            grille.montrer(x, y);

            if(grille.getEtatCase()[x][y].estMine()){
                grille.setPartieTerminee(true);
                grille.revelerToutesLesMines();
            }

            if(grille.getEstGagne()==-1){
                fenetreResultat fn1 = new fenetreResultat("Perdu", true, jeu);
                fn1.afficher();
            }
            if(grille.aGagne()==1){
                fenetreResultat fn2 = new fenetreResultat("Gagné", true, jeu);
                fn2.afficher();
            }
        } else if(e.getButton()==MouseEvent.BUTTON3){
            grille.Marquer(x, y);
        }
        rafraichir();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

    private void rafraichir(){
        for(int i=0; i<cases.length; i++){
            for(int j=0; j<cases[0].length; j++){
                EtatCase e = grille.getEtatCase()[i][j];
                Case c = cases[i][j];

                if(e.estRevelee()){
                    if(e.estMine()){
                        c.setBackground(Color.RED);
                    } else {
                        if(e.nbMines()==0){
                            c.setText("");
                        }else{
                            c.setText(String.valueOf(e.nbMines()));
                        }
                        c.setBackground(Color.WHITE);
                    }
                } else if(e.estMarquee()){
                    c.setBackground(Color.ORANGE);
                    c.setText("!");
                } else if(e.estSoupconnee()){
                    c.setBackground(Color.YELLOW);
                    c.setText("?");
                } else {
                    c.setText("");
                    c.setBackground(Color.GRAY);
                }
            }
        }
        labelMines.setText("Mines restantes :" + grille.getNbMinesRestantes());
    }
}