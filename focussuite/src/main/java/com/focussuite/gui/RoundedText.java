package com.focussuite.gui;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JTextField;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class RoundedText extends JTextField{
    private Shape shape;

    public RoundedText(String name, int size){
        super(name, size);
    }

    @Override
    public void paintComponent(Graphics g){
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        super.paintComponent(g);
    }

    @Override
    public void paintBorder(Graphics g){
        g.setColor(this.getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        super.paintBorder(g);
    }

    public boolean contains(Point p){
        if(shape == null || !shape.getBounds().equals(getBounds())){
            shape = new Rectangle2D.Float(getWidth() - 1, getHeight() - 1, 15, 15);
        }
        return shape.contains(p);
    }

}
