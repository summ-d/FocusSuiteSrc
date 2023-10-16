package com.focussuite.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.border.Border;

public class RoundedButton extends JButton implements Border {
    private int m_w;
    private int m_h;
    private Color back;
    private Color front;
    private int m_x;
    private int m_y;
    
    public RoundedButton(String name){
        super(name);
    }

    public void setDimensions(int w, int h, int x, int y){
        this.m_w = w;
        this.m_h = h;
        this.m_x = x;
        this.m_y = y;
    }

    public RoundedButton(int w,  int h, int x, int y){
        this(w, h, Color.GRAY, Color.WHITE, x, y);
    }

    public int[] getDimensions(){
        int[] arr = {m_w, m_h, m_x, m_y};
        return arr;
    }

    public RoundedButton(int w, int h, Color front, Color back, int x, int y){
        this.m_w = w;
        this.m_h = h;
        this.front = front;
        this.back = back;
        this.m_x = x;
        this.m_y = y;
    }

    @Override
    public Insets getBorderInsets(Component arg0) {
       return new Insets(m_h, m_w, m_h, m_w);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }

    @Override
    public void paintBorder(Component arg0, Graphics arg1, int x, int y, int w, int h) {
        w--;
        h--;

        arg1.setColor(this.front);
        arg1.drawLine(x, y+h-m_h, x, y+m_h);
        arg1.drawArc(x, y, 2*m_w, 2*m_h, 180, -90);
        arg1.drawLine(x+m_w, y, x+w-m_w, y);
        arg1.drawArc(x+w-2*m_w, y, 2*m_w,2*m_h,90,-90);


        arg1.setColor(this.back);
        arg1.drawLine(x+w, y+m_h, x+w, y+h-m_h);
        arg1.drawArc(x+w-2*m_w, y+h-2*m_h, 2*m_w, 2*m_h, 0,-90);
        arg1.drawLine(x+m_w, y+h, x+w-m_w, y+h);
        arg1.drawArc(x, y+h-2*m_h, 2*m_w, 2*m_h, -90,-90);

    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        this.paintBorder(this, g2, m_x, m_y, m_w, m_h);
    }

    public Color getBack(){
        return this.back;
    }
    
}
