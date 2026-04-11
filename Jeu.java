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
        fenetre = new JFrame();
        this.lignes = lignes;
        this.colonnes = colonnes;
        this.nbMines = nbMines;
        fenetre.setSize(configFenetre.LARGEUR, configFenetre.HAUTEUR);
        fenetre.setLocation(100, 100);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLayout(new BorderLayout());
    }

    public void lancerJeu(){

        grille =  new Grille(lignes, colonnes, nbMines);
        grille.placement();


        compteurMines compt = new compteurMines(grille.getEtatCase(), lignes, colonnes);
        compt.calculer();


        construireInterface();
        /*        JPanel panelHaut = new JPanel();

JLabel labelMines = new JLabel("Mines restantes :" + nbMines);
        panelHaut.add(labelMines);

        /*JPanel panelGrille = new JPanel();
        panelGrille.setLayout(new GridLayout(lignes, colonnes));

        for(int i=0; i<lignes; i++){
            for(int j=0; j<colonnes; j++){
                Case c = new Case();
                ControleurCase controleurCase = new ControleurCase(grille, cases, i, j, labelMines, this);
                c.addMouseListener(controleurCase);
                c.x = i;
                c.y = j;

                c.setBackground(Color.GRAY);
                cases[i][j] = c;
                panelGrille.add(c);
            }
        }

        fenetre.add(panelHaut, BorderLayout.NORTH);
        fenetre.add(panelGrille, BorderLayout.CENTER);*/
    }

    public void chargerJeu(Grille grilleACharger){
        this.grille = grilleACharger;
        this.lignes = grille.getLignes();
        this.colonnes = grille.getColonnes();

        construireInterface();
    }

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

    public JFrame getFrame(){
        return fenetre;
    }
}