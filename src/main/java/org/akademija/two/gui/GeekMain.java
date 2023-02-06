package org.akademija.two.gui;

import javax.swing.*;
import java.awt.*;

public class GeekMain {
    public static void main(String[] args) {
       // Runnable runnable = GeekMain::createAndShowGUI;
        SwingUtilities.invokeLater(GeekMain::createAndShowGUI);
    }

    static void createAndShowGUI(){
        JFrame frame = new JFrame("Geek for geeks");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setSize(new Dimension(400, 300));
        frame.setMinimumSize(new Dimension(400, 300));
        JPanel geekPanel = new GeekPanel();

        frame.setContentPane(geekPanel);
        frame.setVisible(true);
    }
}
