package org.akademija;

import javax.swing.*;

/**
 * GUI  SWING.
 * Tri vrste komponenti:
 * <li>1. Kontejneri  JFrame, JPanel </li>
 * <li>2. GUI kontroler JButton, JCheckBox, JRadioButton, JComboBox<E>  ...</li>
 * <li>3. LayoutManager -> BorderLayout(JFrame),FlowLayout(JPanel)... </li>
 */
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Naslov mog prozora");
        frame.setSize(500, 400);

        ButtonPanel buttonPanel = new ButtonPanel();
        frame.setContentPane(buttonPanel);

        frame.setVisible(true);
    }
}