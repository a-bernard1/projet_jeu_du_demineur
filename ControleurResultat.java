import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ControleurResultat implements ActionListener {
    private JFrame win1;
    private JButton btnRejouer;
    private JButton btnQuitter;

    public ControleurResultat(JFrame window1, JButton btnRejouer, JButton btnQuitter) {
        this.win1 = window1;
        this.btnRejouer = btnRejouer;
        this.btnQuitter = btnQuitter;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnQuitter) {
            System.exit(0);
        } else if (e.getSource() == btnRejouer) {
            this.win1.dispose();

            if(Jeu.fenetre != null) {
                Jeu.fenetre.dispose();
                Jeu.fenetre = null;
            }

            Accueil pageAccueil = new Accueil();
        }
    }
}
