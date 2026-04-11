import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FenetreAfficheMessageErreur {
    
    public static void afficher(String message) {
        JFrame fenetre = new JFrame();
        fenetre.setSize(400, 150);
        fenetre.setLocation(400, 400);
        fenetre.setLayout(new BorderLayout());

        JLabel label = new JLabel(message, JLabel.CENTER);
        fenetre.add(label, BorderLayout.CENTER);

        fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        fenetre.setVisible(true);
    }
}
