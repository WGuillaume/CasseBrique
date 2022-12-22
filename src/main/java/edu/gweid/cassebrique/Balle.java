package edu.gweid.cassebrique;

import java.awt.*;
import java.util.ArrayList;

public class Balle extends Sprite {

    protected int vitesseHorizontal;
    protected int vitesseVertical;
    protected int diametre;
    protected int diametreReflet;
    protected int decalageReflet;
    protected Color couleur;



    protected Point[] listePoints = new Point[10];
    public Balle(int x, int y, int vitesseHorizontal, int vitesseVertical, int diametre, Color couleur) {
        super(x,y);
        this.vitesseHorizontal = vitesseHorizontal == 0 ? 1 : vitesseHorizontal;
        this.vitesseVertical = vitesseVertical == 0 ? 1 : vitesseVertical;
        this.couleur = couleur;
        this.setDiametre(diametre);
    }

    public void deplacer() {
        x += vitesseHorizontal;
        y += vitesseVertical;
    }
    public void dessiner(Graphics2D dessin) {

        dessin.setColor(couleur);
        dessin.fillOval(x, y,diametre,diametre);
        dessin.setColor(Color.white);
        dessin.fillOval(x + decalageReflet,
                y + decalageReflet,
                diametreReflet,
                diametreReflet);


    }
    public void mouvementBalle (int largeurEcran, int hauteurEcran){

        if(x< 0 || x>largeurEcran- diametre) {
            inverseVitesseHorizontal();
        }

        if(y< 0 || y> hauteurEcran - diametre) {
            inverseVitesseVertical();
        }
    }

    int indexPoint= 0 ;
    int indexFrame= 0 ;
    public void points (Graphics2D dessin) {

        if (indexFrame % 10 ==0) {

            int indexPoint = (int) ((indexFrame / 10) % 10);

            if(indexFrame < 100) {
                Point ballepoint = new Point(x, y);
                listePoints[indexPoint] = ballepoint;
            } else {
                listePoints[indexPoint].setX(x);
                listePoints[indexPoint].setY(y);
            }
        }
        indexFrame ++;

        for (Point point :listePoints){
            if(point != null) {
                point.dessiner(dessin);
            }
        }
    }
    public void inverseVitesseVertical() {
        vitesseVertical *= -1;
    }

    public void inverseVitesseHorizontal() {
        vitesseHorizontal *= -1;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVitesseHorizontal() {
        return vitesseHorizontal;
    }

    public void setVitesseHorizontal(int vitesseHorizontal) {
        this.vitesseHorizontal = vitesseHorizontal;
    }

    public int getVitesseVertical() {
        return vitesseVertical;
    }

    public void setVitesseVertical(int vitesseVertical) {
        this.vitesseVertical = vitesseVertical;
    }

    public int getDiametre() {
        return diametre;
    }

    public void setDiametre(int diametre) {
        this.diametre = diametre;
        this.diametreReflet = (int)(diametre * 0.3f);
        this.decalageReflet = (int)(diametre * 0.2f);
    }

    public int getDiametreReflet() {
        return diametreReflet;
    }

    public int getDecalageReflet() {
        return decalageReflet;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

//    public ArrayList<Balle> getListePoints() {
//        return listePoints;
//    }
//
//    public void setListePoints(ArrayList<Balle> listePoints) {
//        this.listePoints = listePoints;
//    }

}