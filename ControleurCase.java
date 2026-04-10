import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControleurCase implements MouseListener{
    private Grille grille;
    private Case[][] cases;
    private int x, y;
    
    public ControleurCase(Grille grille, Case[][] cases, int x, int y){
        this.grille = grille;
        this.cases = cases;
        this.x = x;
        this.y = y;
    }

    @Override
    public void mousePressed(MouseEvent e){
        if(e.getButton()==MouseEvent.BUTTON1){
            grille.montrer(x, y);
            if(grille.getEstGagne()==-1){
                fenetreResultat.afficher("Perdu", true);
            }
            if(grille.aGagne()==1){
                fenetreResultat.afficher("Gagne", true);
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
    }
}