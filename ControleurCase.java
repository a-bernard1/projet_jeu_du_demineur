import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

/**
 * Contrôleur associé à une case de la grille du démineur
 * 
 * Gère les interactions utilisateur (clics souris) sur une case
 * et met à jour le modèle (Grille) ainsi que l'affichage
 */
public class ControleurCase implements MouseListener{
    private Grille grille;
    private Case[][] cases;
    private int x, y;
    private JLabel labelMines;
    private Jeu jeu;
    
/**
 * Initialise le controleur
 *
 * @param grille grille sur laquelle on joue
 * @param cases tableau à deux dimensions qui contient les éléments visuels de la grille
 * @param x position de la ligne 
 * @param y position de la colonne
 * @param labelMines JLabel qui permet d'afficher le nombre de mines restantes
 * @param jeu  instance principale du jeu (utilisée pour gérer la fin de partie)
 */

    public ControleurCase(Grille grille, Case[][] cases, int x, int y, JLabel labelMines, Jeu jeu){
        this.grille = grille;
        this.cases = cases;
        this.x = x;
        this.y = y;
        this.labelMines = labelMines;
        this.jeu = jeu;
    }


    /**
     * Gère les clics souris sur la case.
     * 
     * - Clic gauche : révèle la case.
     *   - Si une mine est révélée, la partie est perdue.
     *   - Si toutes les cases sûres sont révélées, la partie est gagnée.
     * 
     * - Clic droit : modifie l'état de marquage de la case.
     *
     * @param e événement souris
     */

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


    /**
     * Met à jour l'affichage de toutes les cases en fonction de leur état
     * 
     * Adapte la couleur et le contenu de chaque case selon qu'elle est :
     * révélée, minée, marquée ou soupçonnée
     * Met également à jour le compteur de mines restantes
     */

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