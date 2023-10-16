package com.focussuite;

import javax.swing.JFrame;

import com.focussuite.gui.LoginScreen;

/**
 * Hello world!
 */
public final class App {
    private App() {
        
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        LoginScreen ls = new LoginScreen(new JFrame("FocusSuite Login"));
        ls.renderBasic();
    }

}
