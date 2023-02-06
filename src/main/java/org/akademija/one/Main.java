package org.akademija.one;

import javax.swing.*;
import java.awt.*;

/**
 * GUI  SWING.
 * Tri vrste komponenti:
 * <li>1. Kontejneri  JFrame, JPanel </li>
 * <li>2. GUI kontroler JButton, JCheckBox, JRadioButton, JComboBox<E>  ...</li>
 * <li>3. LayoutManager -> BorderLayout(JFrame),FlowLayout(JPanel)... </li>
 */
public class Main {
    public static void main(String[] args) {
        Runnable runnable = Main::showGUI;
//        Thread guiThread = new Thread(runnable);
//        guiThread.start();
        SwingUtilities.invokeLater(runnable);
    }

    static void showGUI(){
        System.out.println(Thread.currentThread().getName());
        JFrame frame = new JFrame();
        BorderLayout borderLayout = new BorderLayout();
        frame.setLayout(borderLayout);
        frame.setTitle("Naslov mog prozora");
        frame.setSize(500, 400);

        ButtonPanel buttonPanel = new ButtonPanel();
        frame.setContentPane(buttonPanel);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}