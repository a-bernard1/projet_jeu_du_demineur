import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ControleurPageTaille implements ActionListener {
    private JButton btnMoins;
    private JButton btnPlus;
    private JLabel labelValeur;
    

    ControleurPageTaille(JButton btnMoins, JButton btnPlus, JLabel labelValeur) {
        this.btnMoins = btnMoins;
        this.btnPlus = btnPlus;
        this.labelValeur = labelValeur;
    }

    

    public void actionPerformed(ActionEvent e) {
        int valeur = Integer.parseInt(labelValeur.getText());
        if (e.getSource() == btnPlus) {
            if (valeur < 30) {
                valeur++;
            } else {
                valeur = 4;
            }
         } else if (e.getSource() == btnMoins) {
            if (valeur > 4) {
                valeur--;
            } else {
                valeur = 30;
            }
         }
        labelValeur.setText("" + valeur);
    }
}