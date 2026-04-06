import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class fenetreResultat {
    
    public static void afficher(String message, boolean quitter) {
        JFrame f = new JFrame();
        f.setSize(400, 150);
        f.setLocation(400, 400);
        if(quitter) {
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else {
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        JLabel label = new JLabel(message, JLabel.CENTER);
        f.add(label, BorderLayout.CENTER);
        f.setVisible(true);
    }
}
