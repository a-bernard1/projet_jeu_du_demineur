public class EtatCase{
    private boolean _estMine;
    private int _nbMinesAutour;
    private boolean estMarquee;
    private boolean estSoupconnee;
    private boolean estRevelee;

    public boolean estMine(){
        return _estMine;
    }

    public void setEstMine(boolean b){
        _estMine = b;
    }

    public int nbMines(){
        return _nbMinesAutour;
    }

    public void incrNbMines(){
        _nbMinesAutour++;
    }

    public void reveler(){
        if(!estMarquee){
            estRevelee=true;
        }
    }

    public boolean estRevelee(){
        return estRevelee;
    }

    public void marquer(){
        if(!estRevelee && !estSoupconnee){
            estMarquee=true;
        }
    }

    public boolean estMarquee(){
        return estMarquee;
    }

    public void soupconner(){
        if(estMarquee){
            estMarquee=false;
            estSoupconnee=true;
        }
    }

    public void vider(){
        if (estSoupconnee){
            estSoupconnee=false;
        }
    }

    public boolean estSoupconnee(){
        return estSoupconnee;
    }


    public void setNbMines(int n){
        _nbMinesAutour = n;
    }

    public void setEstRevelee(boolean b){
        estRevelee = b;
    }

    public void setEstMarquee(boolean b){
        estMarquee = b;
    }

    public void setEstSoupconnee(boolean b){
        estSoupconnee = b;
    }
}