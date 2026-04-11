import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
* Fenêtre utilitaire permettant d'afficher un message d'erreur
* 
* Cette classe fournit une méthode statique pour afficher rapidement
* une fenêtre contenant un message centré.
*/

public class FenetreAfficheMessageErreur {
    

    /**
    * Affiche une fenêtre contenant un message d'erreur
    *
    * @param message texte à afficher dans la fenêtre
    */

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
