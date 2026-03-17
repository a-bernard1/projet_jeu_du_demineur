import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

public class Accueil {

    public Accueil() {
        JFrame fenetre = new JFrame();
        fenetre.setSize(500, 500);
        fenetre.setLocation(100, 100);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        CardLayout cl = new CardLayout();
        JPanel globalJPanel = new JPanel(cl);


        JPanel panelAccueil = new JPanel();
        panelAccueil.setLayout(new GridLayout(3, 1));
        panelAccueil.setPreferredSize(new Dimension(200, 150));


        JPanel testJPanelPage = new JPanel();
        JLabel testJLabel = new JLabel("TEST");
        testJPanelPage.add(testJLabel);
        

        JButton jouer = new JButton("Jouer");
        ControleurPageJeu controleur = new ControleurPageJeu(globalJPanel, cl);
        jouer.addActionListener(controleur);
        JButton reprendre = new JButton("Reprendre");
        JButton quitter = new JButton("Quitter");


        panelAccueil.add(reprendre);
        panelAccueil.add(jouer);
        panelAccueil.add(quitter);




        globalJPanel.add(panelAccueil, "MENU");
        globalJPanel.add(testJPanelPage, "TEST");

        cl.show(globalJPanel, "MENU");




        fenetre.add(globalJPanel, BorderLayout.CENTER);

        fenetre.setVisible(true);
    }
}
