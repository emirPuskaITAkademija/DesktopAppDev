package org.akademija.three.table.simple;

import javax.swing.*;

public class SimpleTableDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimpleTableDemo::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Simple TABLE overview");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        TablePanel tablePanel = new TablePanel();
        tablePanel.setOpaque(true);
        frame.setContentPane(tablePanel);

        frame.pack();
        frame.setVisible(true);
    }
}
