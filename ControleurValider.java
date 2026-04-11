import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ControleurValider implements ActionListener {
    private JFrame win1;
    private ControleurPageTaille ctrlLigne;
    private ControleurPageTaille ctrlColonne;
    private ControleurPageTaille ctrlMines;


    public ControleurValider(JFrame win1, ControleurPageTaille ctrlLigne, ControleurPageTaille ctrlColonne,ControleurPageTaille ctrlMines) {
        this.win1 = win1;
        this.ctrlLigne = ctrlLigne;
        this.ctrlColonne = ctrlColonne;
        this.ctrlMines = ctrlMines;
    }

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
