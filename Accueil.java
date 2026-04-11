import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Accueil {

    public Accueil() {
        JFrame fenetre = new JFrame();
        fenetre.setSize(configFenetre.LARGEUR, configFenetre.HAUTEUR);
        fenetre.setLocation(100, 100);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel globalJPanel = new JPanel(new GridBagLayout());


        JPanel panelAccueil = new JPanel();
        panelAccueil.setLayout(new GridLayout(3, 1, 0, 15));


        AffichageChoixTaille pageTaille = new AffichageChoixTaille();

        JButton btnjouer = new JButton("Jouer");
        ControleurAccueil controleurJeu = new ControleurAccueil(fenetre, pageTaille.getFrame(), "JOUER");
        btnjouer.addActionListener(controleurJeu);
        btnjouer.setPreferredSize(new Dimension(200, 50));

        JButton btnreprendre = new JButton("Reprendre");
        ControleurAccueil controleurReprendre = new ControleurAccueil(fenetre, pageTaille.getFrame(), "REPRENDRE");
        btnreprendre.addActionListener(controleurReprendre);
        btnreprendre.setPreferredSize(new Dimension(200, 50));

        JButton btnquitter = new JButton("Quitter");
        ControleurAccueil controleurQuitter = new ControleurAccueil(fenetre, fenetre, "QUITTER");
        btnquitter.addActionListener(controleurQuitter);
        btnquitter.setPreferredSize(new Dimension(200, 50));


        panelAccueil.add(btnjouer);
        panelAccueil.add(btnreprendre);
        panelAccueil.add(btnquitter);

        globalJPanel.add(panelAccueil);

        fenetre.add(globalJPanel, BorderLayout.CENTER);

        fenetre.setVisible(true);
    }
}
