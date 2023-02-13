package org.akademija.three;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemListener;

public class CheckBoxPanel extends JPanel {
    private final JCheckBox chinCheckBox = new JCheckBox("Chin", true);
    private final JCheckBox glassesCheckBox = new JCheckBox("Glasses", true);
    private final JCheckBox hairCheckBox = new JCheckBox("Hair", true);
    private final JCheckBox teethCheckBox = new JCheckBox("Teeth", true);


    public CheckBoxPanel(ItemListener itemListener) {
        setLayout(new GridLayout(0, 1));
        add(chinCheckBox);
        add(glassesCheckBox);
        add(hairCheckBox);
        add(teethCheckBox);
        chinCheckBox.addItemListener(itemListener);
        glassesCheckBox.addItemListener(itemListener);
        hairCheckBox.addItemListener(itemListener);
        teethCheckBox.addItemListener(itemListener);
    }


    public JCheckBox getChinCheckBox() {
        return chinCheckBox;
    }

    public JCheckBox getGlassesCheckBox() {
        return glassesCheckBox;
    }

    public JCheckBox getHairCheckBox() {
        return hairCheckBox;
    }

    public JCheckBox getTeethCheckBox() {
        return teethCheckBox;
    }
}
