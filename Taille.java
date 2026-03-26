import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Taille {
    private JFrame fenetre = new JFrame();

    public Taille() {
        fenetre.setSize(configFenetre.LARGEUR, configFenetre.HAUTEUR);
        fenetre.setLocation(100, 100);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelTaille = new JPanel();
        panelTaille.setLayout(new GridLayout(5, 1));

        JLabel labelLigne = new JLabel("Nombre de ligne (max 30):");
        JSpinner spinnerLigne = new JSpinner(new SpinnerNumberModel(4, 4, 30, 1));

        JLabel labelColone = new JLabel("Nombre de colone (max 30):");
        JSpinner spinnerColone = new JSpinner(new SpinnerNumberModel(4, 4, 30, 1));

        JButton btnValider = new JButton("Valider");
        ControleurPageTaille controleurTaille = new ControleurPageTaille(fenetre, spinnerLigne, spinnerColone);
        btnValider.addActionListener(controleurTaille);
            
        panelTaille.add(labelLigne);
        panelTaille.add(spinnerLigne);
        panelTaille.add(labelColone);
        panelTaille.add(spinnerColone);
        panelTaille.add(btnValider);

        fenetre.add(panelTaille, BorderLayout.CENTER);
        }

        public JFrame getFrame() {
            return fenetre;
        }
}
