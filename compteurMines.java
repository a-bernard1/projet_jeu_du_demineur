public class compteurMines {
    etatCase grilleEtat[][];
    Case grilleCase[][];
    int lignes;
    int colonnes;

    public compteurMines(etatCase grilleEtat[][], int lignes, int colonnes){
        this.grilleEtat = grilleEtat;
        this.lignes = lignes;
        this.colonnes = colonnes;
    }

    public Case[][] compteurMinesAutour(){
        for(int i=0; i<lignes; i++){
            for(int j=0; j<colonnes; j++){
                if(grilleEtat[i][j].estMine()){
                    for(int a=-1; a<=1; a++){
                        for(int b=-1; b<=1; b++){
                            if(i+a<0 || j+b<0){
                                System.out.println("a");
                            }else{
                                grilleCase[i+a][j+b].nbMinesAutour +=1;
                                grilleCase[i+a][j+b].setText(Integer.toString(grilleCase[i+a][j+b].nbMinesAutour));
                            }
                        }
                    }
                }
            }
            
        }
        return grilleCase;
    }
}