import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 * La classe <code>ControleurAccueil</code> gère les actions des boutons
 * de la fenêtre d'accueil du démineur.
 * 
 * Selon le bouton actionné ("JOUER", "REPRENDRE" ou "QUITTER"),
 * elle effectue la transition vers la fenêtre appropriée ou termine l'application.
 * 
 * @version 1.0
 * @author Antoine
 */
public class ControleurAccueil implements ActionListener{

    /**
     * La fenêtre d'accueil à masquer lors d'une action.
     */
    private JFrame win1;

    /**
     * La fenêtre de destination à afficher après l'action (si applicable).
     */
    private JFrame win2;

    /**
     * Identifiant du bouton associé à ce contrôleur ("JOUER", "REPRENDRE" ou "QUITTER").
     */
    private String choix;

    /**
     * Initialise le contrôleur avec les deux fenêtres concernées et l'action à effectuer.
     * 
     * @param window1    la fenêtre d'accueil à masquer
     * @param window2    la fenêtre à afficher (selon l'action choisie)
     * @param quelBouton l'identifiant du bouton ("JOUER", "REPRENDRE" ou "QUITTER")
     */
    ControleurAccueil(JFrame window1, JFrame window2, String quelBouton){
        this.win1 = window1;
        this.win2 = window2;
        this.choix = quelBouton;
    }

    /**
     * Gère l'action déclenchée par le bouton associé.
     * 
     * - "JOUER" : masque l'accueil et affiche la page de choix de taille.
     * - "REPRENDRE" : tente de charger une sauvegarde et relance le jeu.
     * - "QUITTER" : termine l'application.
     * 
     * @param e l'événement déclenché par le clic sur le bouton
     */
    public void actionPerformed(ActionEvent e){
        if(choix.equals("JOUER")){
            System.out.println("lance le jeu");
            win1.setVisible(false);
            win2.setVisible(true);
        } else if(choix.equals("REPRENDRE")){
            Sauvegarde sauvegarde = new Sauvegarde();
            // charger
            Grille g = sauvegarde.charger();
            if(g != null){
                Jeu jeu = new Jeu(0,0,0);
                jeu.chargerJeu(g);

                win1.setVisible(false);
            }else {System.err.println("PAS DE SAUVREGARDE");}
        }else if(choix.equals("QUITTER")){
            System.out.println("quitter");
            System.exit(0);
        };
    };
}
