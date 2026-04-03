public class etatCase{
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

    public void soupconner(){
        if(!estMarquee && !estRevelee){
            estSoupconnee=true;
        }
    }
}