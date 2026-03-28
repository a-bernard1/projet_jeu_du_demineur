public class Grille{
    private int nbMines;
    private int nbLignes;
    private int nbColonnes;
    private etatCase grille[][];

    public Grille(int nbLignes, int nbColonnes){
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.grille = new etatCase[nbLignes][nbColonnes];
    
        for(int i=0; i<nbLignes; i++){
            for(int j=0; j<nbColonnes; j++){
                grille[i][j] = new etatCase();
            }
        }
    }

    public void placement(int nbMines){
        while(nbMines>0){
            int i = (int)(Math.random() * nbLignes);
            int j = (int)(Math.random() * nbColonnes);

            if(!grille[i][j].estMine()){
                grille[i][j].setEstMine(true);
                nbMines--;
            }
        }
        System.out.println("");
    }

    public etatCase getEtatCase(int i, int j){
        return grille[i][j];
    }
}