import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;

public class Main{
    public static void main(String[] args){

        JFrame fenetre = new JFrame();
        fenetre.setSize(500, 500);
        fenetre.setLocation(100, 100);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        boolean play=true;

        Accueil accueil = new Accueil();
        fenetre.add(accueil.panneau, BorderLayout.CENTER);

        fenetre.setVisible(true);

        while(play==true){
            //accueil -> choix : [ jouer / reprendre / quitter ]
            //le jeu
            //menu de fin -> condition [relancer / quitter / ]
        }
        System.out.println("fin du programme");

        
    }
}