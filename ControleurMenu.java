import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurMenu implements ActionListener{
    private String choix;
    private Grille g;
    private Sauvegarde save;

    ControleurMenu(Grille g, String quelBouton){
        this.choix = quelBouton;
        this.g = g;
        save = new Sauvegarde(g);
    }

    public void actionPerformed(ActionEvent e){
        if(choix=="SAUVEGARDER"){
            save.sauvegarder();
        }else if(choix=="QUITTER"){
            System.out.println("quitter");
            System.exit(0);
        };
    };
}
