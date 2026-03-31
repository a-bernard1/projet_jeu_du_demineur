import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ControleurPageTaille implements ActionListener {
    private JFrame win1;
    private JButton btnMoins;
    private JButton btnPlus;
    private JLabel labelValeur;
    private JLabel labelLigne;
    private JLabel labelColonne;
    private String typeBouton;

    ControleurPageTaille(JButton btnMoins, JButton btnPlus, JLabel labelValeur) {
        this.btnMoins = btnMoins;
        this.btnPlus = btnPlus;
        this.labelValeur = labelValeur;
        this.typeBouton = "PlusEtMoins";
    }

    ControleurPageTaille(JFrame win1, JLabel labelLigne, JLabel labelColonne) {
        this.win1 = win1;
        this.labelLigne = labelLigne;
        this.labelColonne = labelColonne;
        this.typeBouton = "Valider";
    }

    public void actionPerformed(ActionEvent e) {
        if (typeBouton == "PlusEtMoins") {
            int valeur = Integer.parseInt(labelValeur.getText());
            if (e.getSource() == btnPlus && valeur <30) {
                valeur++;
            } else if (e.getSource() == btnMoins && valeur >4) {
                valeur--;
            }
            labelValeur.setText("" + valeur);
        } else if (typeBouton == "Valider") {
            int lignes = Integer.parseInt(labelLigne.getText());
            int colonnes = Integer.parseInt(labelColonne.getText());
            win1.setVisible(false);
            Jeu pageJeu = new Jeu(lignes, colonnes);
            pageJeu.getFrame().setVisible(true);
        }
        
        
    }
}