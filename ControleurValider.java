import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ControleurValider implements ActionListener {
    private JFrame win1;


    ControleurValider(JFrame win1, ControleurPageTaille controleurLigne, ControleurPageTaille controleurColonne, ControleurPageTaille controleurMines) {
        this.win1 = win1;
    }

    public void actionPerformed(ActionEvent e) {
        int nbCases = configTaille.nbLignes * configTaille.nbColonnes;
        if(configTaille.nbMines > nbCases) {
            fenetreResultat.afficher("Le nombre de mine(" + configTaille.nbMines + ") dépasse le nombre de cases (" + nbCases + ")", false);
        } else {
            win1.setVisible(false);
            Jeu pageJeu = new Jeu(configTaille.nbLignes, configTaille.nbColonnes, configTaille.nbMines);
            pageJeu.getFrame().setVisible(true);
        }
    }
}
