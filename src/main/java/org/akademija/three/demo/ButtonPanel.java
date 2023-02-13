package org.akademija.three.demo;

import javax.swing.*;

public class ButtonPanel extends JPanel {
    private final JButton brainButton = new JButton("Observable/Subject BUTTON");

    public ButtonPanel(){
        add(brainButton);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        AngelListener angelListener = new AngelListener();
        brainButton.addActionListener(angelListener);
        DevilListener devilListener = new DevilListener();
        brainButton.addActionListener(devilListener);
    }
}
