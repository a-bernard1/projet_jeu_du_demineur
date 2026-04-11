
/**
* Calcule le nombre de mines adjacentes pour chaque case de la grille
* 
* Cette classe parcourt la grille et, pour chaque mine, incrémente le compteur des cases voisines
*/

public class compteurMines {
    EtatCase grilleEtat[][];
    int lignes;
    int colonnes;

    /**
    * Initialise le calculateur de mines adjacentes
    *
    * @param grilleEtat tableau représentant l'état des cases
    * @param lignes nombre de lignes de la grille
    * @param colonnes nombre de colonnes de la grille
    */

    public compteurMines(EtatCase grilleEtat[][], int lignes, int colonnes){
        this.grilleEtat = grilleEtat;
        this.lignes = lignes;
        this.colonnes = colonnes;
    }


    /**
    * Calcule le nombre de mines autour de chaque case
    * 
    * Pour chaque case contenant une mine, les cases voisines (jusqu'à 8 autour) voient leur compteur incrémenté,
    * à condition qu'elles soient dans la grille et ne soient pas des mines.
    */

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