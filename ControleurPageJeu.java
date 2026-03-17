
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class ControleurPageJeu implements ActionListener{
    private JPanel pnl;
    private CardLayout cl;

    ControleurPageJeu(JPanel panel, CardLayout cardLayout){
        this.pnl = panel;
        this.cl = cardLayout;
    }

    public void actionPerformed(ActionEvent e){
        System.out.println("test bouton");
        cl.show(pnl, "TEST");
    };
}
