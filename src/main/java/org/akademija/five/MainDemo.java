package org.akademija.five;

import org.akademija.five.table.TablePanel;

import javax.swing.*;

public class MainDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainDemo::createAndShowGUI);
    }

    private static void createAndShowGUI(){
        TablePanel tablePanel = new TablePanel();
        JFrame frame = new JFrame("Tabela-analiza");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(tablePanel);
        frame.pack();
        frame.setVisible(true);
    }
}
