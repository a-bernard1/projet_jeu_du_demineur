import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ControleurPageTaille implements ActionListener {
    private JButton btnMoins;
    private JButton btnPlus;
    private JLabel labelValeur;
    private int valeur;
    private String type;
    

    ControleurPageTaille(JButton btnMoins, JButton btnPlus, JLabel labelValeur, int valeurInitiale, String type) {
        this.btnMoins = btnMoins;
        this.btnPlus = btnPlus;
        this.labelValeur = labelValeur;
        this.valeur = valeurInitiale;
        this.type = type;


        labelValeur.setText(String.valueOf(valeur));
    }

    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPlus) {
            valeur++;
            if(valeur>30)valeur=4;
        } else if (e.getSource() == btnMoins) {
            valeur--;
            if(valeur<4)valeur=30;
        }

        labelValeur.setText(String.valueOf(valeur));
    }
    
    public int getValeur() {
        return valeur;
    }
}