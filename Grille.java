public class Grille{
    private int nbLignes;
    private int nbColonnes;
    private etatCase grille[][];
    private int nbCaseSafe;
    private int nbMines;

    public Grille(int nbLignes, int nbColonnes, int nbMines){
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.grille = new etatCase[nbLignes][nbColonnes];
        this.nbCaseSafe = 0;
        this.nbMines = nbMines;
    
        for(int i=0; i<nbLignes; i++){
            for(int j=0; j<nbColonnes; j++){
                grille[i][j] = new etatCase();
            }
        }
    }

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

    public etatCase[][] getEtatCase(){
        return grille;
    }
    

    public void montrer(int i, int j){
        if(i<0 || i>=nbLignes || j<0 || j>=nbColonnes){return;}
        etatCase c = grille[i][j];

        if(c.estRevelee()){
            return;
        }
        c.reveler();

        if(c.estMine()){
            fenetreResultat.afficher("Perdu", true);
        }else 
        
        if(c.nbMines()>0){
        }else{
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

    public boolean aGagne(){
        for(int i=0; i<nbLignes; i++){
            for(int j=0; j<nbColonnes; j++){
                etatCase c = grille[i][j];
                if(!c.estMine() && !c.estRevelee()){
                    return false;
                }
            }
        }
        return true;
    }
}
