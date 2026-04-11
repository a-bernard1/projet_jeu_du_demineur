import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
* Classe principale du jeu
* 
* Cette classe est responsable de :
* - l'initialisation du jeu
* - la gestion de la grille (modèle)
* - la construction de l'interface graphique
* 
* Elle joue le rôle de point d'entrée et de coordination entre
* le modèle (Grille) et la vue (Swing)
*/

public class Jeu{
    private JFrame fenetre = new JFrame();
    private Grille grille;
    private int lignes;
    private int colonnes;
    private int nbMines;


    /**
    * Initialise une nouvelle instance du jeu
    *
    * @param lignes nombre de lignes de la grille
    * @param colonnes nombre de colonnes de la grille
    * @param nbMines nombre de mines à placer
    */

    public  Jeu(int lignes, int colonnes, int nbMines){
        fenetre = new JFrame();
        this.lignes = lignes;
        this.colonnes = colonnes;
        this.nbMines = nbMines;
        fenetre.setSize(configFenetre.LARGEUR, configFenetre.HAUTEUR);
        fenetre.setLocation(100, 100);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLayout(new BorderLayout());
    }

    /**
    * Lance une nouvelle partie
    * 
    * Initialise la grille, place les mines et calcule les indices
    * des cases, puis construit l'interface graphique
    */

    public void lancerJeu(){

        grille =  new Grille(lignes, colonnes, nbMines);
        grille.placement();


        compteurMines compt = new compteurMines(grille.getEtatCase(), lignes, colonnes);
        compt.calculer();


        construireInterface();
    }

    /**
    * Charge une partie existante
    * 
    * Met à jour la grille et reconstruit l'interface graphique
    * en fonction de l'état sauvegardé
    *
    * @param grilleACharger grille représentant l'état sauvegardé d'une partie
    */

    public void chargerJeu(Grille grilleACharger){
        this.grille = grilleACharger;
        this.lignes = grille.getLignes();
        this.colonnes = grille.getColonnes();

        construireInterface();
    }


    /**
    * Construit et initialise l'interface graphique du jeu
    * 
    * Crée :
    * - un panneau supérieur avec bouton de sauvegarde et compteur de mines
    * - une grille de cases interactives
    * 
    * Associe chaque case à son contrôleur pour gérer les interactions utilisateur.
    */

    private void construireInterface(){
        fenetre.setLayout(new BorderLayout());
        Case cases[][] = new Case[lignes][colonnes];

        JPanel panelHaut = new JPanel();

        JButton btnSauvegarder = new JButton("Sauvegarder");
        ControleurMenu controleurSauvegarder = new ControleurMenu(grille);
        btnSauvegarder.addActionListener(controleurSauvegarder);
        panelHaut.add(btnSauvegarder);

        fenetre.add(panelHaut, BorderLayout.NORTH);

        JPanel panelGrille = new JPanel(new GridLayout(lignes, colonnes));

        JLabel labelMines = new JLabel("Mines restantes :" + grille.getNbMinesRestantes());
        panelHaut.add(labelMines);

        for(int i=0;i<lignes;i++){
            for(int j=0;j<colonnes;j++){

                EtatCase etat = grille.getEtatCase()[i][j];
                Case c = new Case();

                if(etat.estRevelee()){
                    if(etat.estMine()){
                        c.setBackground(Color.RED);
                    } else {
                        if(etat.nbMines()==0){
                            c.setText("");
                        }else{
                            c.setText(String.valueOf(etat.nbMines()));
                        }
                        c.setBackground(Color.WHITE);
                    }
                } else if(etat.estMarquee()){
                    c.setBackground(Color.ORANGE);
                    c.setText("!");
                } else if(etat.estSoupconnee()){
                    c.setBackground(Color.YELLOW);
                    c.setText("?");
                } else {
                    c.setText("");
                    c.setBackground(Color.GRAY);
                }
                ControleurCase controleurCase = new ControleurCase(grille, cases, i, j, labelMines, this);
                c.addMouseListener(controleurCase);
                
                cases[i][j] = c;
                panelGrille.add(c);
            }
        }

        fenetre.add(panelGrille, BorderLayout.CENTER);
        fenetre.setVisible(true);
    }

    /**
    * @return la fenêtre principale du jeu
    */

    public JFrame getFrame(){
        return fenetre;
    }
}