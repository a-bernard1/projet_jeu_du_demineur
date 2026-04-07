public class compteurMines {
    EtatCase grilleEtat[][];
    int lignes;
    int colonnes;

    public compteurMines(EtatCase grilleEtat[][], int lignes, int colonnes){
        this.grilleEtat = grilleEtat;
        this.lignes = lignes;
        this.colonnes = colonnes;
    }

    public void calculer(){
        for(int i=0; i<lignes; i++){
            for(int j=0; j<colonnes; j++){

                if(grilleEtat[i][j].estMine()){

                    for(int a=-1; a<=1; a++){
                        for(int b=-1; b<=1; b++){

                            int ni = i+a;
                            int nj = j+b;

                            if(a==0&&b==0){}

                            if(ni>=0 && ni <lignes && nj>=0 && nj < colonnes){
                                if(!grilleEtat[ni][nj].estMine()){
                                    grilleEtat[ni][nj].incrNbMines();
                                }
                            }
                        }
                    }
                }
            }   
        }
    }
}