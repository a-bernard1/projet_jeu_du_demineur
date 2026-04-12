import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * La classe <code>ControleurResultat</code> gère les actions des boutons
 * de la fenêtre de résultat affichée en fin de partie.
 * 
 * Elle permet au joueur de rejouer une nouvelle partie depuis l'accueil
 * ou de quitter l'application.
 * 
 * @version 1.0
 * @author Antoine
 */
public class ControleurResultat implements ActionListener {

    /**
     * La fenêtre de résultat à fermer lors d'une action.
     */
    private JFrame win1;

    /**
     * L'instance du jeu en cours, utilisée pour fermer la fenêtre de jeu.
     */
    private Jeu jeu;

    /**
     * Le bouton permettant de rejouer une partie.
     */
    private JButton btnRejouer;

    /**
     * Le bouton permettant de quitter l'application.
     */
    private JButton btnQuitter;

    /**
     * Initialise le contrôleur avec la fenêtre de résultat, les boutons d'action et l'instance du jeu.
     * 
     * @param win1       la fenêtre de résultat
     * @param btnRejouer le bouton "Rejouer"
     * @param btnQuitter le bouton "Quitter"
     * @param jeu        l'instance du jeu en cours
     */
    public ControleurResultat(JFrame win1, JButton btnRejouer, JButton btnQuitter, Jeu jeu) {
        this.win1 = win1;
        this.jeu = jeu;
        this.btnRejouer = btnRejouer;
        this.btnQuitter = btnQuitter;
    }

    /**
     * Gère les clics sur les boutons de la fenêtre de résultat.
     * 
     * - "Quitter" : ferme l'application.
     * - "Rejouer" : ferme les fenêtres de résultat et de jeu, puis affiche l'accueil.
     * 
     * @param e l'événement déclenché par le clic sur l'un des boutons
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnQuitter) {
            System.exit(0);
        } else if (e.getSource() == btnRejouer) {
            win1.dispose();
            jeu.getFrame().dispose();
            new Accueil();
        }
    }
}
