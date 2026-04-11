import java.io.FileWriter;
import java.io.IOException;


public class Sauvegarde{

    private Grille grille;

    public Sauvegarde(Grille grille){
        this.grille = grille;
    }

    public void sauvegarder(){
            System.out.println("test save1");
        try{
            System.out.println("test save2");
            FileWriter fw = new FileWriter("save.dat");

            int lignes = grille.getLignes();
            int colonnes = grille.getColonnes();

            fw.write(lignes + " " + colonnes + "\n");

            for(int i=0;i<lignes;i++){
                for(int j=0;j<colonnes;j++){

                    EtatCase c = grille.getEtatCase()[i][j];

                    fw.write(
                        (c.estMine() ? 1 : 0) + " " +
                        c.nbMines() + " " +
                        (c.estRevelee() ? 1 : 0) + " " +
                        (c.estMarquee() ? 1 : 0) + " " + 
                        (c.estSoupconnee() ? 1 : 0)
                    );

                    if(j < colonnes-1) fw.write(" | ");
                }
                fw.write("\n");
            }

            fw.close();
            System.out.println("Sauvegarde OK");

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}