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
