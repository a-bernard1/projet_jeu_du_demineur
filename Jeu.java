import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class Jeu{
    private JFrame fenetre = new JFrame();

    public  Jeu(int lignes, int colones){
        fenetre.setSize(500, 500);
        fenetre.setLocation(100, 100);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fenetre.setLayout(new GridLayout(lignes, colones));

        for(int i=0; i<lignes; i++){
            for(int j=0; j<colones; j++){
                Case dcase = new Case();
                dcase.setOpaque(true);
                dcase.setBackground(Color.WHITE);
                System.out.print("0");
                fenetre.add(dcase);
            }
            System.out.println("");
        }
    }

    public JFrame getFrame(){
        return fenetre;
    }
}