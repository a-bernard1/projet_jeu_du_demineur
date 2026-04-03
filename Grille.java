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
            if(nbCaseSafe==nbLignes*nbColonnes-nbMines){
                System.out.println("GAGNÉ !!!!!!!!");
                System.exit(0);
            }
            return;
        }
        c.reveler();

        if(c.estMine()){
            System.out.println("PERDU !!!!!!!!");
            System.exit(0);
        }
        
        if(c.nbMines()>0){
            System.out.println(c.nbMines());
            nbCaseSafe++;
            System.out.println("1 -- nbCaseSafe = " + nbCaseSafe + " nbMine = " + nbMines);
            if(nbCaseSafe==nbLignes*nbColonnes-nbMines){
                System.out.println("GAGNÉ !!!!!!!!");
                System.exit(0);
            }else{System.out.println("2 -- nbCaseSafe = " + nbCaseSafe + " nbMine = " + nbMines);}
        }else{
            for(int a = -1; a<=1; a++){
                for(int b=-1; b<=1; b++){

                    if(a==0&&b==0){}

                    if(a!=0 || b!=0){
                        nbCaseSafe++;
                        montrer(i+a, j+b);
                    }
                }
            }
        }
        if(nbCaseSafe==nbLignes*nbColonnes-nbMines){
            System.out.println("GAGNÉ !!!!!!!!");
            System.exit(0);
        }
    }
}
