public class etatCase{
    private boolean _estMine;
    private int _nbMinesAutour;

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
}