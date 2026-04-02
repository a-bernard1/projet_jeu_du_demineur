import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurCase implements ActionListener{
    private Grille grille;
    private Case[][] cases;
    private int x, y;
    
    public ControleurCase(Grille grille, Case[][] cases, int x, int y){
        this.grille = grille;
        this.cases = cases;
        this.x = x;
        this.y = y;
    }

    public void actionPerformed(ActionEvent e){
        grille.montrer(x, y);
        rafraichir();
    };

    private void rafraichir(){
        for(int i=0; i<cases.length; i++){
            for(int j=0; j<cases[0].length; j++){
                etatCase e = grille.getEtatCase()[i][j];
                Case c = cases[i][j];

                if(e.estRevelee()){
                    if(e.estMine()){
                        c.setBackground(Color.RED);
                    } else {
                        c.setText(String.valueOf(e.nbMines()));
                        c.setBackground(Color.WHITE);
                    }
                } else {
                    c.setText("");
                    c.setBackground(Color.GRAY);
                }
            }
        }
    }
}