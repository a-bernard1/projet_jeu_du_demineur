
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class ControleurPageJeu implements ActionListener{
    private JFrame win1;
    private JFrame win2;

    ControleurPageJeu(JFrame window1, JFrame window2){
        this.win1 = window1;
        this.win2 = window2;
    }

    public void actionPerformed(ActionEvent e){
        System.out.println("test bouton");
        win1.setVisible(false);
        win2.setVisible(true);
    };
}
