import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ControleurValider implements ActionListener {
    private JFrame win1;
    private JLabel labelLigne;
    private JLabel labelColonne;

ControleurValider(JFrame win1, JLabel labelLigne, JLabel labelColonne) {
        this.win1 = win1;
        this.labelLigne = labelLigne;
        this.labelColonne = labelColonne;
    }

    public void actionPerformed(ActionEvent e) {
        win1.setVisible(false);
        Jeu pageJeu = new Jeu(Integer.parseInt(labelLigne.getText()), Integer.parseInt(labelColonne.getText()));
        pageJeu.getFrame().setVisible(true);
    }
}
