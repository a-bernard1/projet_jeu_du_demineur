import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.*;

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

        if(type == "Ligne") {
        configTaille.nbLignes = valeur;
    } else if (type == "Colonne") {
        configTaille.nbColonnes = valeur;
    } else {
        configTaille.nbMines = valeur;
    }

    }

    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPlus) {
            if (type == "Mine") {
                int nbCasesMax = configTaille.nbLignes * configTaille.nbColonnes;
                if(valeur < nbCasesMax) {
                    valeur++;
                } else {
                    fenetreResultat.afficher("Le nombre ne peut pas dépasser" + nbCasesMax, false);
                }
            } else {
             if (valeur < 30) {
                valeur++;
                } else {
                    valeur = 4;
                }
            }
        } else if (e.getSource() == btnMoins) {if (e.getSource() == btnMoins)
            if(type == "Mine") {
                if (valeur > 1) {
                    valeur--;
                } else {
                    valeur = 1;
                }
            } else {
                if (valeur > 4) {
                    valeur--;
                } else {
                    valeur = 30;
                }
            }
        }

         if(type == "Ligne") {
            configTaille.nbLignes = valeur;
         } else if (type == "Colonne") {
            configTaille.nbColonnes = valeur;
         } else {
            configTaille.nbMines = valeur;
         }

        labelValeur.setText("" + valeur);
    }
    
    public int getValeur() {
        return valeur;
    }
}