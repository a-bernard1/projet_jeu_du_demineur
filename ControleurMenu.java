import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurMenu implements ActionListener{
    private Grille g;
    private Sauvegarde save;

    ControleurMenu(Grille g ){
        this.g = g;
        save = new Sauvegarde();
    }

    public void actionPerformed(ActionEvent e){
        save.sauvegarder(g);
        System.exit(0);
    };
}
