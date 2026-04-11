import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Jeu{
    private JFrame fenetre = new JFrame();
    private Grille grille;
    private int lignes;
    private int colonnes;
    private int nbMines;

    public  Jeu(int lignes, int colonnes, int nbMines){
        if(fenetre != null) {
            fenetre.dispose();
        }
        fenetre = new JFrame();
        this.lignes = lignes;
        this.colonnes = colonnes;
        this.nbMines = nbMines;
    }

    public void lancerJeu(){
        fenetre.setSize(configFenetre.LARGEUR, configFenetre.HAUTEUR);
        fenetre.setLocation(100, 100);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLayout(new BorderLayout());

        grille =  new Grille(lignes, colonnes, nbMines);
        grille.placement();

        Case cases[][] = new Case[lignes][colonnes];

        compteurMines compt = new compteurMines(grille.getEtatCase(), lignes, colonnes);
        compt.calculer();

        JPanel panelHaut = new JPanel();

        JButton btnQuitter = new JButton("Quitter");
        ControleurMenu controleurQuitter = new ControleurMenu(grille, "QUITTER");
        btnQuitter.addActionListener(controleurQuitter);
        panelHaut.add(btnQuitter);

        JButton btnSauvegarder = new JButton("Sauvegarder");
        ControleurMenu controleurSauvegarder = new ControleurMenu(grille, "SAUVEGARDER");
        btnSauvegarder.addActionListener(controleurSauvegarder);
        panelHaut.add(btnSauvegarder);

        JLabel labelMines = new JLabel("Mines restantes :" + nbMines);
        panelHaut.add(labelMines);

        JPanel panelGrille = new JPanel();
        panelGrille.setLayout(new GridLayout(lignes, colonnes));

        for(int i=0; i<lignes; i++){
            for(int j=0; j<colonnes; j++){
                Case c = new Case();
                ControleurCase controleurCase = new ControleurCase(grille, cases, i, j, labelMines, this);
                c.addMouseListener(controleurCase);
                btnQuitter.addActionListener(controleurQuitter);
                panelHaut.add(btnQuitter);
                c.x = i;
                c.y = j;

                c.setBackground(Color.GRAY);
                cases[i][j] = c;
                panelGrille.add(c);
            }
        }

        fenetre.add(panelHaut, BorderLayout.NORTH);
        fenetre.add(panelGrille, BorderLayout.CENTER);
    }

    public JFrame getFrame(){
        return fenetre;
    }
}