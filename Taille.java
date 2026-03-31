import java.awt.*;

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

        JLabel labelNbLigne = new JLabel("4", JLabel.CENTER);  
        JLabel labelNbColonne = new JLabel("4", JLabel.CENTER);


        JPanel panelTaille = new JPanel();
        panelTaille.setLayout(new GridLayout(5, 1));

        JLabel labelLigne = new JLabel("Nombre de ligne (min 4, max 30):", JLabel.CENTER);
        JPanel panelLigne = new JPanel();
        JButton moinsLigne = new JButton("-");
        JButton plusLigne = new JButton("+");
        ControleurPageTaille controleurLigne = new ControleurPageTaille(moinsLigne, plusLigne, labelNbLigne);
        moinsLigne.addActionListener(controleurLigne);
        plusLigne.addActionListener(controleurLigne);
        panelLigne.add(moinsLigne);
        panelLigne.add(labelNbLigne);
        panelLigne.add(plusLigne);

        JLabel labelColonne = new JLabel("Nombre de colone (min 4, max 30):", JLabel.CENTER);
        JPanel panelColonne= new JPanel();
        JButton moinsColonne = new JButton("-");
        JButton plusColonne = new JButton("+");
        ControleurPageTaille controleurColonne = new ControleurPageTaille(moinsColonne, plusColonne, labelNbColonne);
        moinsColonne.addActionListener(controleurColonne);
        plusColonne.addActionListener(controleurColonne);
        panelColonne.add(moinsColonne);
        panelColonne.add(labelNbColonne);
        panelColonne.add(plusColonne);

        JButton btnValider = new JButton("Valider");
        ControleurValider controleurValider = new ControleurValider(fenetre, labelNbLigne, labelNbColonne);
        btnValider.addActionListener(controleurValider);
            
        panelTaille.add(labelLigne);
        panelTaille.add(panelLigne);
        panelTaille.add(labelColonne);
        panelTaille.add(panelColonne);
        panelTaille.add(btnValider);

        fenetre.add(panelTaille, BorderLayout.CENTER);
        }

        public JFrame getFrame() {
            return fenetre;
        }
}
