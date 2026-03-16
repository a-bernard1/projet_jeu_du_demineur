import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Accueil {
    public JPanel panneau;

    public Accueil() {
        JPanel boutons = new JPanel();
        boutons.setLayout(new GridLayout(3, 1));
        boutons.setPreferredSize(new Dimension(200, 150));

        Bouton jouer = new Bouton("Jouer");
        boutons.add(jouer.Bouton);
        Bouton reprendre = new Bouton("Reprendre");
        boutons.add(reprendre.Bouton);
        Bouton quitter = new Bouton("Quitter");
        boutons.add(quitter.Bouton);

        panneau = new JPanel();
        panneau.setLayout(new BorderLayout());
        panneau.add(boutons, BorderLayout.CENTER);
    }
}
