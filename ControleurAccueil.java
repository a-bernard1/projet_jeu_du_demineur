import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class ControleurAccueil implements ActionListener{
    private JFrame win1;
    private JFrame win2;
    private String choix;

    ControleurAccueil(JFrame window1, JFrame window2, String quelBouton){
        this.win1 = window1;
        this.win2 = window2;
        this.choix = quelBouton;
    }

    public void actionPerformed(ActionEvent e){
        if(choix=="JOUER"){
            System.out.println("lance le jeu");
            win1.setVisible(false);
            win2.setVisible(true);
        } else if(choix=="REPRENDRE"){
        }else if(choix=="QUITTER"){
            System.out.println("quitter");
            System.exit(0);
        };
    };
}
