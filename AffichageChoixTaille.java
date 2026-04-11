import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AffichageChoixTaille {
    private JFrame fenetre = new JFrame();

    public AffichageChoixTaille() {
        fenetre.setSize(configFenetre.LARGEUR, configFenetre.HAUTEUR);
        fenetre.setLocation(100, 100);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel globalPanel = new JPanel(new GridBagLayout());

        JPanel panelTaille = new JPanel();
        panelTaille.setLayout(new GridLayout(7, 1, 0, 10));
        panelTaille.setPreferredSize(new Dimension(400, 400));

        JLabel labelNbLigne = new JLabel("", JLabel.CENTER);  
        JLabel labelNbColonne = new JLabel("", JLabel.CENTER);
        JLabel labelNbMines = new JLabel("", JLabel.CENTER);
        labelNbLigne.setPreferredSize(new Dimension(40, 30));
        labelNbColonne.setPreferredSize(new Dimension(40, 30));
        labelNbMines.setPreferredSize(new Dimension(40, 30));


        JLabel labelLigne = new JLabel("Nombre de ligne (min 4, max 30):", JLabel.CENTER);
        JPanel panelLigne = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JButton moinsLigne = new JButton("-");
        JButton plusLigne = new JButton("+");
        moinsLigne.setPreferredSize(new Dimension(50, 30));
        plusLigne.setPreferredSize(new Dimension(50, 30));
        ControleurPageTaille controleurLigne = new ControleurPageTaille(moinsLigne, plusLigne, labelNbLigne, 4, "Ligne");
        moinsLigne.addActionListener(controleurLigne);
        plusLigne.addActionListener(controleurLigne);
        panelLigne.add(moinsLigne);
        panelLigne.add(labelNbLigne);
        panelLigne.add(plusLigne);


        JLabel labelColonne = new JLabel("Nombre de colone (min 4, max 30):", JLabel.CENTER);
        JPanel panelColonne= new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JButton moinsColonne = new JButton("-");
        JButton plusColonne = new JButton("+");
        moinsColonne.setPreferredSize(new Dimension(50, 30));
        plusColonne.setPreferredSize(new Dimension(50, 30));
        ControleurPageTaille controleurColonne = new ControleurPageTaille(moinsColonne, plusColonne, labelNbColonne, 4, "Colonne");
        moinsColonne.addActionListener(controleurColonne);
        plusColonne.addActionListener(controleurColonne);
        panelColonne.add(moinsColonne);
        panelColonne.add(labelNbColonne);
        panelColonne.add(plusColonne);


        JLabel labelMines = new JLabel("Nombre de mines :", JLabel.CENTER);
        JPanel panelMines = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JButton moinsMines = new JButton("-");
        JButton plusMines = new JButton("+");
        moinsMines.setPreferredSize(new Dimension(50, 30));
        plusMines.setPreferredSize(new Dimension(50, 30));
        ControleurPageTaille controleurMines = new ControleurPageTaille(moinsMines, plusMines, labelNbMines, 1, "Mine");
        moinsMines.addActionListener(controleurMines);
        plusMines.addActionListener(controleurMines);
        panelMines.add(moinsMines);
        panelMines.add(labelNbMines);
        panelMines.add(plusMines);


        JPanel panelValider = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnValider = new JButton("Valider");
        btnValider.setPreferredSize(new Dimension(150, 40));
        ControleurValider controleurValider = new ControleurValider(fenetre, controleurLigne, controleurColonne, controleurMines);
        btnValider.addActionListener(controleurValider);
        panelValider.add(btnValider);
            
        panelTaille.add(labelLigne);
        panelTaille.add(panelLigne);
        panelTaille.add(labelColonne);
        panelTaille.add(panelColonne);
        panelTaille.add(labelMines);
        panelTaille.add(panelMines);
        panelTaille.add(btnValider);

        globalPanel.add(panelTaille);

        fenetre.add(globalPanel, BorderLayout.CENTER);
        }

        public JFrame getFrame() {
            return fenetre;
        }
}
