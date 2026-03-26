import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

public class Accueil {

    public Accueil() {
        JFrame fenetre = new JFrame();
        fenetre.setSize(configFenetre.LARGEUR, configFenetre.HAUTEUR);
        fenetre.setLocation(100, 100);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel globalJPanel = new JPanel();


        JPanel panelAccueil = new JPanel();
        panelAccueil.setLayout(new GridLayout(3, 1));
        panelAccueil.setPreferredSize(new Dimension(200, 150));


     
        Taille pageTaille = new Taille();
        JButton jouer = new JButton("Jouer");
        ControleurAccueil controleurJeu = new ControleurAccueil(fenetre, pageTaille.getFrame(), "JOUER");
        jouer.addActionListener(controleurJeu);

        JButton reprendre = new JButton("Reprendre");

        JButton quitter = new JButton("Quitter");
        ControleurAccueil controleurQuitter = new ControleurAccueil(fenetre, fenetre, "QUITTER");
        quitter.addActionListener(controleurQuitter);


        panelAccueil.add(reprendre);
        panelAccueil.add(jouer);
        panelAccueil.add(quitter);

        globalJPanel.add(panelAccueil);

        fenetre.add(globalJPanel, BorderLayout.CENTER);

        fenetre.setVisible(true);
    }
}
