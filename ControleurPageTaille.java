import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ControleurPageTaille implements ActionListener {
    private JFrame win1;
    private JSpinner spinnerLigne;
    private JSpinner spinnerColone;

    ControleurPageTaille(JFrame windows1, JSpinner spinnerLigne, JSpinner spinnerColone) {
        this.win1 = windows1;
        this.spinnerLigne = spinnerLigne;
        this.spinnerColone = spinnerColone;
    }

    public void actionPerformed(ActionEvent e) {
        int lignes = (int) spinnerLigne.getValue();
        int colones = (int) spinnerColone.getValue();
        win1.setVisible(false);
        Jeu pageJeu = new Jeu(lignes, colones);
        pageJeu.getFrame().setVisible(true);
    }
}