import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

public class Accueil {

    public Accueil() {
        JFrame fenetre = new JFrame();
        fenetre.setSize(500, 500);
        fenetre.setLocation(100, 100);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel globalJPanel = new JPanel();


        JPanel panelAccueil = new JPanel();
        panelAccueil.setLayout(new GridLayout(3, 1));
        panelAccueil.setPreferredSize(new Dimension(200, 150));


     
        Jeu pageJeu = new Jeu();
        JButton jouer = new JButton("Jouer");
        ControleurPageJeu controleur = new ControleurPageJeu(fenetre, pageJeu.getFrame());
        jouer.addActionListener(controleur);
        JButton reprendre = new JButton("Reprendre");
        JButton quitter = new JButton("Quitter");


        panelAccueil.add(reprendre);
        panelAccueil.add(jouer);
        panelAccueil.add(quitter);

        globalJPanel.add(panelAccueil);

        fenetre.add(globalJPanel, BorderLayout.CENTER);

        fenetre.setVisible(true);
    }
}
