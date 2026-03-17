import javax.swing.JButton;

public class Case extends JButton{
    boolean estMine;
    boolean estSafe;
    boolean estMarquee;
    boolean estRevelee;
    int nbMines;

    public Case(){
        super();
        this.estMine = false;
        this.estSafe = false;
        this.estMarquee = false;
        this.estRevelee = false;
        this.nbMines = 0;
    };
}
