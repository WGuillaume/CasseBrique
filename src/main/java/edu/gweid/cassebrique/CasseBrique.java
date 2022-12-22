package edu.gweid.cassebrique;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CasseBrique extends Canvas {

    protected static int largeurEcran = 500;
    protected static int hauteurEcran = 600;

    public CasseBrique() throws InterruptedException {
        JFrame fenetre = new JFrame("Casse brique");
        //On récupère le panneau de la fenetre principale
        JPanel panneau = (JPanel) fenetre.getContentPane();
        //On définie la hauteur / largeur de l'écran
        panneau.setPreferredSize(new Dimension(largeurEcran, hauteurEcran));
        setBounds(0, 0, largeurEcran,hauteurEcran);
        //On ajoute cette classe (qui hérite de Canvas) comme composant du panneau principal
        panneau.add(this);

        fenetre.pack();
        fenetre.setResizable(false);
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenetre.requestFocus();

        //On indique que le raffraichissement de l'ecran doit être fait manuellement.
        createBufferStrategy(2);
        setIgnoreRepaint(true);
        this.setFocusable(false);

        demarrer();
    }

    public void demarrer() throws InterruptedException {

        long indexFrame = 0;
        ArrayList<Balle> listeBalles = new ArrayList<>();


        for (int i=0 ;i<10 ;i++){
            listeBalles.add(new Balle(
                    (int)(Math.random()*largeurEcran),
                    (int)(Math.random()*hauteurEcran),
                    (int)(Math.random()*14)-7,
                    (int)(Math.random()*14)-7,
                    (int)(Math.random()*25)+5,
                    new Color(
                            (float)Math.random(),
                            (float)Math.random(),
                            (float)Math.random()
                    )
            ));

        }


        while(true) {
            indexFrame ++;
            Graphics2D dessin = (Graphics2D) getBufferStrategy().getDrawGraphics();

            //-----------------------------
            //reset dessin
            dessin.setColor(Color.black);
            dessin.fillRect(0,0,largeurEcran,hauteurEcran);



            for (Balle balle :listeBalles) {
                //dessin balle
                balle.deplacer();
                balle.dessiner(dessin);
                balle.mouvementBalle(largeurEcran, hauteurEcran);
                balle.points(dessin);

            }


            //-----------------------------
            dessin.dispose();
            getBufferStrategy().show();
            Thread.sleep(1000 / 60);
        }
    }
    public int getLargeurEcran() {
        return largeurEcran;
    }

    public void setLargeurEcran(int largeurEcran) {
        this.largeurEcran = largeurEcran;
    }

    public int getHauteurEcran() {
        return hauteurEcran;
    }

    public void setHauteurEcran(int hauteurEcran) {
        this.hauteurEcran = hauteurEcran;
    }
    public static void main(String[] args) throws InterruptedException {
        new CasseBrique();
    }
}