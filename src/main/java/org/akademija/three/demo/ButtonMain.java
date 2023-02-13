package org.akademija.three.demo;

import javax.swing.*;
import java.awt.*;

public class ButtonMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ButtonMain::createGUI);
    }

    static void createGUI(){
        JFrame prozor = new JFrame("DEMO");
        prozor.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        prozor.setMinimumSize(new Dimension(500, 400));
        prozor.setContentPane(new ButtonPanel());
        prozor.setVisible(true);
    }
}
