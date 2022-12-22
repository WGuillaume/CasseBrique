package edu.gweid.cassebrique;

import java.awt.*;

public class Point extends Sprite{

    public Point(int x, int y) {
        super(x, y);
    }

@Override
    public void dessiner(Graphics2D dessin) {
        dessin.setColor(Color.WHITE);
        dessin.fillOval(x, y,5,5);

    }

}
