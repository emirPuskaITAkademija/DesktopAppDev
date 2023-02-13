package org.akademija.three.demo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AngelListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Nemoj. Zažalit ćeš !!!");
    }
}
