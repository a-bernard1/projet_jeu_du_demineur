import javax.swing.UIManager;

/**
 * La classe <code>Main</code> constitue le point d'entrée de l'application démineur.
 * 
 * Elle initialise l'apparence graphique de l'interface utilisateur
 * et lance la fenêtre d'accueil du jeu.
 * 
 * @version 1.0
 * @author Antoine
 */
public class Main{

    /**
     * Méthode principale de l'application.
     * 
     * Applique le look and feel Nimbus si disponible,
     * puis ouvre la fenêtre d'accueil du démineur.
     * 
     * @param args les arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args){

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {

        }
        Accueil accueil = new Accueil();
    }
}