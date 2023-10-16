package com.focussuite.gui;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class LoginScreen extends JFrame{
    private RoundedButton loginButton;
    private RoundedButton signUp;
    private RoundedButton adminButton;
    private RoundedText username;
    private RoundedText password;

    private LoginData sessionData;

   
    public LoginScreen(){
        super("FocusSuite -- Login");
        this.setSize(200, 200);
    }

    public void renderBasic(){
        loginButton = new RoundedButton("Login");
        signUp = new RoundedButton("Sign Up Here");
        adminButton = new RoundedButton("Parent, Teacher, or Admin? Click here");
        username = new RoundedText("Username:", 30);
        password = new RoundedText("Password:", 30);

    }

    @Override
    public void paint(Graphics g){
        this.renderBasic();
        loginButton.setDimensions(10, 20, 100, 150);
        signUp.setDimensions(10, 10, 20, 150);
        adminButton.setDimensions(10, 10, 180, 150);
        loginButton.paintComponent(g);
        signUp.paintComponent(g);
        adminButton.paintComponent(g);
        username.paintAll(g);
        password.paintAll(g);
        super.paint(g);
    }


    public void attachListeners(){
        loginButton.addMouseListener(new LoginButtonListener());
        signUp.addMouseListener(new SignupButtonListener());
        adminButton.addMouseListener(new AdminRedirListener());
    }

    private class LoginButtonListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            sessionData = new LoginData();
            sessionData.setPassword(password.getText());
            sessionData.setUsername(username.getText());
            
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
        }

        @Override
        public void mouseExited(MouseEvent arg0) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
        }

        @Override
        public void mousePressed(MouseEvent arg0) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
        }
    };

    public static class SignupButtonListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent arg0) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
        }

        @Override
        public void mouseExited(MouseEvent arg0) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
        }

        @Override
        public void mousePressed(MouseEvent arg0) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
        }
        
    };

    public static class AdminRedirListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent arg0) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
        }

        @Override
        public void mouseExited(MouseEvent arg0) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
        }

        @Override
        public void mousePressed(MouseEvent arg0) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
        }
    };


};