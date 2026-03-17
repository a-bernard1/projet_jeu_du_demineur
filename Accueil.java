import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

public class Accueil {
    public JPanel panneau;

    public Accueil() {
        JFrame fenetre = new JFrame();
        fenetre.setSize(500, 500);
        fenetre.setLocation(100, 100);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel boutons = new JPanel();
        boutons.setLayout(new GridLayout(3, 1));
        boutons.setPreferredSize(new Dimension(200, 150));

        JPanel testJPanel = new JPanel();
        JLabel testJLabel = new JLabel("TEST");
        testJPanel.add(testJLabel);
        
        
        JButton jouer = new JButton("Jouer");
        ControleurPageJeu controleur = new ControleurPageJeu(fenetre, testJPanel);
        jouer.addActionListener(controleur);
        boutons.add(jouer);


        JButton reprendre = new JButton("Reprendre");
        boutons.add(reprendre);
        JButton quitter = new JButton("Quitter");
        boutons.add(quitter);

        panneau = new JPanel();
        panneau.setLayout(new BorderLayout());
        panneau.add(boutons, BorderLayout.CENTER);
        fenetre.add(panneau, BorderLayout.CENTER);

        fenetre.setVisible(true);
    }
}
