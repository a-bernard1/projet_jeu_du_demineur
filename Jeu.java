import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class Jeu{
    private JFrame fenetre = new JFrame();
    private int nbMines;
    private Grille grille;

    public  Jeu(int lignes, int colonnes){
        fenetre.setSize(configFenetre.LARGEUR, configFenetre.HAUTEUR);
        fenetre.setLocation(100, 100);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fenetre.setLayout(new GridLayout(lignes, colonnes));

        //nmMines mis en dur juste pour tester 
        nbMines = (lignes*colonnes)/4;

        grille =  new Grille(lignes, colonnes);
        grille.placement(nbMines);

        Case cases[][] = new Case[lignes][colonnes];

        compteurMines compt = new compteurMines(grille.getEtatCase(), lignes, colonnes);
        compt.calculer();

        for(int i=0; i<lignes; i++){
            for(int j=0; j<colonnes; j++){
                Case c = new Case();
                ControleurCase controleurCase = new ControleurCase(grille, cases, i, j);
                c.addActionListener(controleurCase);
                c.x = i;
                c.y = j;

                c.setBackground(Color.GRAY);
                cases[i][j] = c;
                fenetre.add(c);
            }
        }
    }

    public JFrame getFrame(){
        return fenetre;
    }
}