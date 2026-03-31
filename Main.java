import javax.swing.UIManager;

public class Main{
    public static void main(String[] args){

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {

        }

        boolean play=true;

        Accueil accueil = new Accueil();

        /*while(play==true){
            //accueil -> choix : [ jouer / reprendre / quitter ]
            //le jeu
            //menu de fin -> condition [relancer / quitter / ]
        }*/
        System.out.println("fin du programme");   
    }
}