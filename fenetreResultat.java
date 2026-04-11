import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class fenetreResultat {
    private String message;
    private boolean quitter;
    private Jeu jeu;

    public fenetreResultat(String message, boolean quitter, Jeu jeu){
        this.message = message;
        this.quitter = quitter;
        this.jeu = jeu;
    }
    
    public void afficher() {
        JFrame fenetre = new JFrame();
        fenetre.setSize(400, 150);
        fenetre.setLocation(400, 400);
        fenetre.setLayout(new BorderLayout());

        JLabel label = new JLabel(message, JLabel.CENTER);
        fenetre.add(label, BorderLayout.CENTER);

        if(quitter) {
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panelBoutons = new JPanel(new FlowLayout());
            JButton btnRejouer = new JButton("Rejouer");
            JButton btnQuitter = new JButton("Quitter");

            ControleurResultat controleurRes = new ControleurResultat(fenetre, btnRejouer, btnQuitter, jeu);
            btnRejouer.addActionListener(controleurRes);
            btnQuitter.addActionListener(controleurRes);

            panelBoutons.add(btnRejouer);
            panelBoutons.add(btnQuitter);
            fenetre.add(panelBoutons, BorderLayout.SOUTH);
        } else {
            fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    
        fenetre.setVisible(true);
    }
}
