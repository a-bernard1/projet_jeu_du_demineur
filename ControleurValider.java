import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * La classe <code>ControleurValider</code> gère l'action du bouton "Valider"
 * dans la page de configuration de la grille.
 * 
 * Elle vérifie la cohérence des paramètres saisis (lignes, colonnes, mines),
 * affiche un message d'erreur si nécessaire, ou lance le jeu si les paramètres sont valides.
 * 
 * @version 1.0
 * @author Antoine
 */
public class ControleurValider implements ActionListener {

    /**
     * La fenêtre de configuration à masquer lors du lancement du jeu.
     */
    private JFrame win1;

    /**
     * Le contrôleur gérant le nombre de lignes.
     */
    private ControleurPageTaille ctrlLigne;

    /**
     * Le contrôleur gérant le nombre de colonnes.
     */
    private ControleurPageTaille ctrlColonne;

    /**
     * Le contrôleur gérant le nombre de mines.
     */
    private ControleurPageTaille ctrlMines;

    /**
     * Initialise le contrôleur avec la fenêtre de configuration et les contrôleurs de paramètres.
     * 
     * @param win1        la fenêtre de configuration à masquer
     * @param ctrlLigne   le contrôleur du nombre de lignes
     * @param ctrlColonne le contrôleur du nombre de colonnes
     * @param ctrlMines   le contrôleur du nombre de mines
     */
    public ControleurValider(JFrame win1, ControleurPageTaille ctrlLigne, ControleurPageTaille ctrlColonne,ControleurPageTaille ctrlMines) {
        this.win1 = win1;
        this.ctrlLigne = ctrlLigne;
        this.ctrlColonne = ctrlColonne;
        this.ctrlMines = ctrlMines;
    }

    /**
     * Gère le clic sur le bouton "Valider".
     * 
     * Vérifie que le nombre de mines ne dépasse pas le nombre de cases disponibles.
     * En cas d'erreur, une fenêtre de message est affichée.
     * Sinon, la fenêtre de configuration est masquée et le jeu est lancé.
     * 
     * @param e l'événement déclenché par le clic sur le bouton "Valider"
     */
    public void actionPerformed(ActionEvent e) {
        int nbLignes = ctrlLigne.getValeur();
        int nbColonnes = ctrlColonne.getValeur();
        int nbMines = ctrlMines.getValeur();

        int nbCases = nbLignes * nbColonnes-1;

        if(nbMines > nbCases) {
            FenetreAfficheMessageErreur.afficher("Le nombre de mine(" + nbMines + ") dépasse le nombre de cases (" + nbCases + ")");
        } else {
            win1.setVisible(false);
            Jeu pageJeu = new Jeu(nbLignes, nbColonnes, nbMines);
            pageJeu.lancerJeu();
            pageJeu.getFrame().setVisible(true);
        }
    }
}
