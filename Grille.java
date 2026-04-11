
/**
 * Représente la grille du jeu
 * 
 * La grille contient des cases pouvant être révélées, marquées ou soupçonnées
 * Elle gère aussi le placement des mines, la révélation des cases
 * et la vérification de la victoire
 */


public class Grille{
    private int nbLignes;
    private int nbColonnes;
    private EtatCase grille[][];
    private int nbMines;
    private int estGagne;
    private boolean partieTerminee = false;

/**
 * Initialise une grille de démineur
 *
 * @param nbLignes nombre de lignes de la grille
 * @param nbColonnes nombre de colonnes de la grille
 * @param nbMines nombre de mines à placer
 */

    public Grille(int nbLignes, int nbColonnes, int nbMines){
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.grille = new EtatCase[nbLignes][nbColonnes];
        this.nbMines = nbMines;
    
        for(int i=0; i<nbLignes; i++){
            for(int j=0; j<nbColonnes; j++){
                grille[i][j] = new EtatCase();
            }
        }
    }

    /**
     * @return le nombre de lignes de la grille
     */

    public int getLignes(){
        return nbLignes;
    }



    public int getColonnes(){
        return nbColonnes;
    }

    public int getMines(){
        return nbMines;
    }


    /**
     * Place aléatoirement les mines dans la grille
     * 
     * Garantit qu'une case ne contient pas plusieurs mines
     */

    public void placement(){
        int nbMinesAPlacer = nbMines;   
        while(nbMinesAPlacer>0){
            int i = (int)(Math.random() * nbLignes);
            int j = (int)(Math.random() * nbColonnes);

            if(!grille[i][j].estMine()){
                grille[i][j].setEstMine(true);
                nbMinesAPlacer--;
            }
        }
        System.out.println("");
    }

    public EtatCase[][] getEtatCase(){
        return grille;
    }
    

    /**
     * Révèle une case de la grille
     * 
     * Si la case contient une mine, la partie est perdue
     * Si la case ne contient pas de mine et n'a aucune mine voisine,
     * la révélation se propage récursivement aux cases adjacentes grâce à un DFS
     *
     * @param i indice de ligne
     * @param j indice de colonne
     */

    public void montrer(int i, int j){
        if(i<0 || i>=nbLignes || j<0 || j>=nbColonnes){return;}
        EtatCase c = grille[i][j];

        if(c.estRevelee()||c.estMarquee()){
            return;
        }
        c.reveler();

        if(c.estMine()){
            estGagne = -1;
        }else if(c.nbMines()==0){
            for(int a = -1; a<=1; a++){
                for(int b=-1; b<=1; b++){

                    if(a==0&&b==0){}

                    if(a!=0 || b!=0){
                        montrer(i+a, j+b);
                    }
                }
            }
        }
    }

    public int getEstGagne(){
        return estGagne;
    }


    /**
     * Vérifie si le joueur a gagné.
     * 
     * @return 1 si la partie est gagnée,
     *         0 si elle est en cours,
     *        -1 si elle est perdue
     */

    public int aGagne(){
        for(int i=0; i<nbLignes; i++){
            for(int j=0; j<nbColonnes; j++){
                EtatCase c = grille[i][j];
                if(!c.estMine() && !c.estRevelee()){
                    estGagne = 0;
                    return estGagne;
                }
            }
        }
        estGagne = 1;
        return estGagne;
    }



    /**
     * Change l'état de marquage d'une case.
     * 
     * Cycle entre : cachée → marquée → soupçonnée → vide
     * Ne fait rien si la case est déjà révélée
     *
     * @param x ligne de la case
     * @param y colonne de la case
     */

    public void Marquer(int x, int y){
        EtatCase c = grille[x][y];

        if(c.estRevelee()){
            return;
        }else if(!c.estMarquee() && !c.estSoupconnee()){
            c.marquer();
        } else if(c.estMarquee()){
            c.soupconner();
        } else if(c.estSoupconnee()){
            c.vider();
        }
    }


    /**
     * Calcule le nombre de mines restantes à trouver
     * en fonction des cases marquées.
     *
     * @return nombre de mines restantes estimé
     */

    public int getNbMinesRestantes() {
        int nbMarquees = 0;
        for(int  i = 0; i<nbLignes; i++){
            for(int j = 0; j<nbColonnes; j++){
                if(grille[i][j].estMarquee()) {
                    nbMarquees++;
                }
            }
        }
        return nbMines - nbMarquees;
    }

    public boolean estPartieTerminee(){
        return partieTerminee;
    }

    public void setPartieTerminee(boolean b){
        partieTerminee = b;
    }



    /**
     * Révèle toutes les mines de la grille
     * Utilisée lorsque la partie est terminée
     */

    public void revelerToutesLesMines(){
        for(int i=0; i<nbLignes; i++){
            for(int j=0; j<nbColonnes; j++){
                if(grille[i][j].estMine()){
                    grille[i][j].setEstRevelee(true);
                }
            }
        }
    }
}
