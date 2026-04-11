/**
 * Représente l'état d'une case dans la grille 
 * 
 * Une case peut contenir une mine et possède un nombre de mines adjacentes
 * Elle peut également être dans différents états visibles :
 * - révélée
 * - marquée (point d'exclamation)
 * - soupçonnée (point d'interrogation)
 */

public class EtatCase{
    private boolean _estMine;
    private int _nbMinesAutour;
    private boolean estMarquee;
    private boolean estSoupconnee;
    private boolean estRevelee;


    /**
    * @return true si la case contient une mine
    */

    public boolean estMine(){
        return _estMine;
    }

    /**
    * Définit si la case contient une mine.
    *
    * @param b true si la case devient une mine
    */

    public void setEstMine(boolean b){
        _estMine = b;
    }


    /**
    * @return le nombre de mines présentes autour de la case
    */

    public int nbMines(){
        return _nbMinesAutour;
    }


    /**
    * Incrémente le nombre de mines adjacentes à la case
    */

    public void incrNbMines(){
        _nbMinesAutour++;
    }


    /**
    * Révèle la case si elle n'est pas marquée.
    */

    public void reveler(){
        if(!estMarquee){
            estRevelee=true;
        }
    }


    /**
    * @return true si la case est révélée
    */

    public boolean estRevelee(){
        return estRevelee;
    }


    /**
     * Marque la case comme contenant une mine (drapeau)
     * Ne fonctionne que si la case n'est ni révélée ni soupçonnée
     */

    public void marquer(){
        if(!estRevelee && !estSoupconnee){
            estMarquee=true;
        }
    }


    /**
    * @return true si la case est marquée
    */

    public boolean estMarquee(){
        return estMarquee;
    }

    /**
    * Passe la case de l'état "marquée" à "soupçonnée"
    */

    public void soupconner(){
        if(estMarquee){
            estMarquee=false;
            estSoupconnee=true;
        }
    }



    /**
    * Supprime l'état "soupçonnée" de la case
    */

    public void vider(){
        if (estSoupconnee){
            estSoupconnee=false;
        }
    }


    /**
    * @return true si la case est soupçonnée
    */

    public boolean estSoupconnee(){
        return estSoupconnee;
    }

    /**
    * Définit le nombre de mines adjacentes.
    *
    * @param n nombre de mines autour de la case
    */

    public void setNbMines(int n){
        _nbMinesAutour = n;
    }


    /**
    * Définit si la case est révélée.
    *
    * @param b nouvel état de révélation
    */

    public void setEstRevelee(boolean b){
        estRevelee = b;
    }


    /**
    * Définit si la case est marquée.
    *
    * @param b nouvel état de marquage
    */

    public void setEstMarquee(boolean b){
        estMarquee = b;
    }


    /**
    * Définit si la case est soupçonnée.
    *
    * @param b nouvel état de soupçon
    */

    public void setEstSoupconnee(boolean b){
        estSoupconnee = b;
    }
}