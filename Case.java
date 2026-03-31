import javax.swing.JButton;

public class Case extends JButton{
    boolean estMarquee;
    boolean estRevelee;
    int x;
    int y;
    public int nbMinesAutour;

    public Case(){
        super();
        this.estMarquee = false;
        this.estRevelee = false;
        nbMinesAutour = 0;
    };
}
