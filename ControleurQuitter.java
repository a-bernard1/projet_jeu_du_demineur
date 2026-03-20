
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class ControleurQuitter implements ActionListener{
    ControleurQuitter(){
    }

    public void actionPerformed(ActionEvent e){
        System.out.println("test quitter");
        System.exit(0);
    };
}
