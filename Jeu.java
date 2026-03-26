import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class Jeu{
    private JFrame fenetre = new JFrame();
    private int nbMines;

    public  Jeu(int lignes, int colonnes){
        fenetre.setSize(configFenetre.LARGEUR, configFenetre.HAUTEUR);
        fenetre.setLocation(100, 100);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //nmMines mis en dur juste pour tester 
        nbMines = (lignes*colonnes)/4;

        fenetre.setLayout(new GridLayout(lignes, colonnes));

        PlacementMines placementMines = new PlacementMines(nbMines, lignes, colonnes, fenetre);
        placementMines.placement();
    }

    public JFrame getFrame(){
        return fenetre;
    }
}