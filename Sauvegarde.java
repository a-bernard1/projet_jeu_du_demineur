import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;


public class Sauvegarde{

    public void sauvegarder(Grille grille){
        try{
            FileWriter fw = new FileWriter("save.dat");

            int lignes = grille.getLignes();
            int colonnes = grille.getColonnes();
            int nbMines = grille.getMines();

            fw.write(lignes + " " + colonnes + " " + nbMines + "\n");

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

    public Grille charger(){
        Grille grille = null;
        try{
            FileReader fr = new FileReader("save.dat");
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            if(line == null){
                FenetreAfficheMessageErreur.afficher("Fichier vide, veuillez jouer une partie");
                return null;
            }

            String[] dimensions = line.split(" ");
            int lignes = Integer.parseInt(dimensions[0]);
            int colonnes = Integer.parseInt(dimensions[1]);
            int nbMines = Integer.parseInt(dimensions[2]);

            grille = new Grille(lignes, colonnes, nbMines);

            
            for(int i=0; i<lignes; i++){
                line = br.readLine();
                if(line == null){
                    FenetreAfficheMessageErreur.afficher("Fichier de sauvegarde corrompu");
                    return null;
                }

                String[] cases = line.split("\\|");

                for(int j=0; j<colonnes; j++){
                    String[] valeurs = cases[j].trim().split(" ");

                    EtatCase c = grille.getEtatCase()[i][j];

                    c.setEstMine(valeurs[0].equals("1"));
                    c.setNbMines(Integer.parseInt(valeurs[1]));
                    c.setEstRevelee(valeurs[2].equals("1"));
                    c.setEstMarquee(valeurs[3].equals("1"));
                    c.setEstSoupconnee(valeurs[4].equals("1"));
                }
            }
            
            br.close();
            return grille;

        } catch(FileNotFoundException e){
            FenetreAfficheMessageErreur.afficher("Attention aucune sauvegarde trouvé, veuillez jouer une partie");
            return null;
        } catch (IOException e){
            FenetreAfficheMessageErreur.afficher("Erreur de lecture");
            return null;
        }
    }
}