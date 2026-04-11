public class Grille{
    private int nbLignes;
    private int nbColonnes;
    private EtatCase grille[][];
    private int nbMines;
    private int estGagne;
    private boolean partieTerminee = false;

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

    public int getLignes(){
        return nbLignes;
    }

    public int getColonnes(){
        return nbColonnes;
    }

    public int getMines(){
        return nbMines;
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

    public EtatCase[][] getEtatCase(){
        return grille;
    }
    

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
