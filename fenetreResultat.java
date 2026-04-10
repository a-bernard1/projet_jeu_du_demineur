import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class fenetreResultat {
    
    public static void afficher(String message, boolean quitter) {
        JFrame f = new JFrame();
        f.setSize(400, 150);
        f.setLocation(400, 400);
        f.setLayout(new BorderLayout());

        JLabel label = new JLabel(message, JLabel.CENTER);
        f.add(label, BorderLayout.CENTER);

        if(quitter) {
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panelBoutons = new JPanel(new FlowLayout());
            JButton btnRejouer = new JButton("Rejouer");
            JButton btnQuitter = new JButton("Quitter");

            ControleurResultat controleurRes = new ControleurResultat(f, btnRejouer, btnQuitter);
            btnRejouer.addActionListener(controleurRes);
            btnQuitter.addActionListener(controleurRes);

            panelBoutons.add(btnRejouer);
            panelBoutons.add(btnQuitter);
            f.add(panelBoutons, BorderLayout.SOUTH);
        } else {
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    
        f.setVisible(true);
    }
}
