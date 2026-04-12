import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * La classe <code>ControleurPageTaille</code> gère les boutons "+" et "-"
 * permettant de régler une valeur numérique dans la page de configuration de la grille.
 * 
 * Elle est utilisée pour contrôler le nombre de lignes, de colonnes ou de mines.
 * La valeur est affichée en temps réel dans un label et cycliquement bornée entre 4 et 30.
 * 
 * @version 1.0
 * @author Antoine
 */
public class ControleurPageTaille implements ActionListener {

    /**
     * Bouton permettant de décrémenter la valeur.
     */
    private JButton btnMoins;

    /**
     * Bouton permettant d'incrémenter la valeur.
     */
    private JButton btnPlus;

    /**
     * Label affichant la valeur courante.
     */
    private JLabel labelValeur;

    /**
     * Valeur numérique courante gérée par ce contrôleur.
     */
    private int valeur;

    /**
     * Type de paramètre contrôlé ("Ligne", "Colonne" ou "Mine").
     */
    private String type;
    
    /**
     * Initialise le contrôleur avec les composants graphiques associés et la valeur de départ.
     * 
     * @param btnMoins      le bouton de décrémentation
     * @param btnPlus       le bouton d'incrémentation
     * @param labelValeur   le label affichant la valeur courante
     * @param valeurInitiale la valeur initiale du paramètre
     * @param type          le type de paramètre contrôlé ("Ligne", "Colonne" ou "Mine")
     */
    ControleurPageTaille(JButton btnMoins, JButton btnPlus, JLabel labelValeur, int valeurInitiale, String type) {
        this.btnMoins = btnMoins;
        this.btnPlus = btnPlus;
        this.labelValeur = labelValeur;
        this.valeur = valeurInitiale;
        this.type = type;


        labelValeur.setText(String.valueOf(valeur));
    }

    /**
     * Gère les clics sur les boutons "+" et "-".
     * 
     * Incrémente ou décrémente la valeur courante et met à jour le label.
     * La valeur est cyclique : elle revient à 4 si elle dépasse 30, et à 30 si elle passe en dessous de 4.
     * 
     * @param e l'événement déclenché par le clic sur l'un des boutons
     */
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
    
    /**
     * Renvoie la valeur numérique courante.
     * 
     * @return la valeur courante du paramètre contrôlé
     */
    public int getValeur() {
        return valeur;
    }
}