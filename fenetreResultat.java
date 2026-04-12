import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * La classe <code>fenetreResultat</code> représente la fenêtre affichée en fin de partie.
 * 
 * Elle affiche un message indiquant le résultat de la partie (victoire ou défaite),
 * et propose éventuellement des boutons pour rejouer ou quitter l'application.
 * 
 * @version 1.0
 * @author Antoine
 */
public class fenetreResultat {

    /**
     * Le message à afficher dans la fenêtre (par exemple "Gagné" ou "Perdu").
     */
    private String message;

    /**
     * Indique si les boutons "Rejouer" et "Quitter" doivent être affichés.
     */
    private boolean quitter;

    /**
     * L'instance du jeu en cours, utilisée pour fermer la fenêtre de jeu si besoin.
     */
    private Jeu jeu;

    /**
     * Initialise la fenêtre de résultat avec le message, le mode d'affichage et l'instance du jeu.
     * 
     * @param message le texte à afficher dans la fenêtre
     * @param quitter true si les boutons "Rejouer" et "Quitter" doivent être affichés
     * @param jeu     l'instance du jeu en cours
     */
    public fenetreResultat(String message, boolean quitter, Jeu jeu){
        this.message = message;
        this.quitter = quitter;
        this.jeu = jeu;
    }
    
    /**
     * Construit et affiche la fenêtre de résultat.
     * 
     * Si le paramètre <code>quitter</code> est vrai, les boutons "Rejouer" et "Quitter"
     * sont ajoutés et associés à un contrôleur de résultat.
     * Sinon, la fenêtre se ferme simplement à la demande de l'utilisateur.
     */
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
