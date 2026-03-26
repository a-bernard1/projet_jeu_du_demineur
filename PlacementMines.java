import java.awt.Color;
import javax.swing.JFrame;

public class PlacementMines{
    private int nbMines;
    private int nbLignes;
    private int nbColonnes;
    private JFrame win;

    public PlacementMines(int nbMines, int nbLignes, int nbColonnes, JFrame win){
        this.nbMines = nbMines;
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.win = win;
    }

    public void placement(){
        for(int i=0; i<nbLignes; i++){
            for(int j=0; j<nbColonnes; j++){
                int rand = (int)Math.round(Math.random());
                if(rand%4==0 && nbMines>0){
                    Case dcase = new Case();
                    dcase.estMine = true;
                    dcase.setOpaque(true);
                    dcase.setBackground(Color.RED);
                    System.out.print("1");
                    win.add(dcase);
                    nbMines--;      
                }else{
                    Case dcase = new Case();
                    dcase.estMine = false;
                    dcase.setOpaque(true);
                    dcase.setBackground(Color.WHITE);
                    System.out.print("0");
                    win.add(dcase);
                }
            }
            System.out.println("");
        }
    }
}