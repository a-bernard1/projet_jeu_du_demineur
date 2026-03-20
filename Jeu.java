import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Jeu{
    private JFrame fenetre = new JFrame();

    public  Jeu(){
        fenetre.setSize(500, 500);
        fenetre.setLocation(100, 100);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel testJLabel = new JLabel("TEST");
        fenetre.add(testJLabel);
        fenetre.setVisible(true);
    }

    public JFrame getFrame(){
        return fenetre;
    }
}