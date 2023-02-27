package org.akademija.four;

import javax.swing.*;
import java.awt.*;

/**
 * <li>1. Containers----> JFrame, JPanel, ..</li>
 * <li>2. Controls  ----> JButton, JCheckBox, JComboBox </li>
 * <li>3. Managers  ----> BorderLayout, FlowLayout, GridLayout, ..</li>
 */
public class ComboBoxDemo {

    public static void main(String[] args) {
        /**
         * -> LAMBDA
         * <p>
         *     Mijenja operator new.
         *     Instancira/Kreira objekat tipa funkcionalnog interfejsa.
         * </p>
         * :: METHOD REFERENCING
         * <p>
         *     Kada lambda ne radi ništa drugo nego samo poziva metodu
         *     onda se jednostavno možemo referencirati na tu metodu upravo
         *     preko method referencing operatora.
         * </p>
         *
         */
        Runnable runnable = ComboBoxDemo::createAndShowGUI;
        SwingUtilities.invokeLater(runnable);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame();
        frame.setTitle("Demo ComboBox");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ComboBoxPanel comboBoxPanel = new ComboBoxPanel();
        ComboBoxPanel2 comboBoxPanel2 = new ComboBoxPanel2();
        ComboBoxPanel3 comboBoxPanel3 = new ComboBoxPanel3();
        JPanel horizontalPanel = new JPanel();
        horizontalPanel.add(comboBoxPanel);
        horizontalPanel.add(comboBoxPanel2);
        horizontalPanel.add(comboBoxPanel3);
        frame.setContentPane(horizontalPanel);

        frame.pack();
        frame.setVisible(true);
    }
}
