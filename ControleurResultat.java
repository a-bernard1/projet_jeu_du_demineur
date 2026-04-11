import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ControleurResultat implements ActionListener {
    private JFrame win1;
    private Jeu jeu;
    private JButton btnRejouer;
    private JButton btnQuitter;

    public ControleurResultat(JFrame win1, JButton btnRejouer, JButton btnQuitter, Jeu jeu) {
        this.win1 = win1;
        this.jeu = jeu;
        this.btnRejouer = btnRejouer;
        this.btnQuitter = btnQuitter;
    }

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
