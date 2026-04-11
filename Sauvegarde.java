import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;


/**
* Gère la sauvegarde et le chargement d'une partie
* 
* Les données de la grille sont stockées dans un fichier texte ("save.dat")
* contenant les dimensions de la grille, le nombre de mines, ainsi que
* l'état de chaque case.
*/

public class Sauvegarde{
    /**
    * Sauvegarde l'état actuel de la grille dans un fichier
    * 
    * Le fichier contient :
    * - les dimensions de la grille
    * - le nombre de mines
    * - les informations de chaque case (mine, nombre de mines autour, état révélé, marqué ou soupçonné)
    *
    * @param grille grille à sauvegarder
    */
    
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


    /**
    * Charge une grille à partir du fichier de sauvegarde
    * 
    * Reconstitue la grille en lisant les informations stockées dans le fichier "save.dat"
    * 
    * En cas d'erreur (fichier absent, vide ou corrompu), un message est affiché et la méthode retourne null.
    *
    * @return la grille chargée, ou null si une erreur survient
    */

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