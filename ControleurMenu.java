import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Contrôleur associé au menu du jeu
 * 
 * Gère les actions utilisateur liées au menu, notamment la sauvegarde
 * de la partie en cours.
 */

public class ControleurMenu implements ActionListener{
    private Grille g;
    private Sauvegarde save;


    /**
     * Initialise le contrôleur avec la grille courante.
     *
     * @param grille grille représentant l'état actuel du jeu
     */

    ControleurMenu(Grille grille ){
        this.g = grille;
        save = new Sauvegarde();
    }

    /**
     * Gère l'action de l'utilisateur sur le menu
     * 
     * Sauvegarde la partie en cours puis ferme l'application
     *
     * @param e événement déclenché par l'utilisateur
     */

    public void actionPerformed(ActionEvent e){
        save.sauvegarder(g);
        System.exit(0);
    };
}
