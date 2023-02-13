package org.akademija.two.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class GeekPanel extends JPanel {

    private JCheckBox chinCheckBox = new JCheckBox("Chin");
    private JCheckBox glassesCheckBox = new JCheckBox("Glasses");
    private JCheckBox hairCheckBox = new JCheckBox("Hair");
    private JCheckBox teethCheckBox = new JCheckBox("Teeth");

    private JLabel pictureLabel = new JLabel();

    public GeekPanel() {
        setLayout(new BorderLayout());

        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new GridLayout(0, 1));
        checkBoxPanel.add(chinCheckBox);
        checkBoxPanel.add(glassesCheckBox);
        checkBoxPanel.add(hairCheckBox);
        checkBoxPanel.add(teethCheckBox);
        chinCheckBox.addActionListener(this::onCheckBoxCheckChange);
        glassesCheckBox.addActionListener(this::onCheckBoxCheckChange);
        hairCheckBox.addActionListener(this::onCheckBoxCheckChange);
        teethCheckBox.addActionListener(this::onCheckBoxCheckChange);

        updatePicture("geek-----.gif");

        JPanel picturePanel = new JPanel();
        picturePanel.add(pictureLabel);
        picturePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(checkBoxPanel, BorderLayout.LINE_START);
        add(picturePanel, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    /**
     * Ko može startati funkciju ispod ?
     * <li>
     *     Uzajamno povezani check box ?
     *     chinCheckBox  ->   c
     *
     * </li>
     * @param e
     */
    private void onCheckBoxCheckChange(ActionEvent e){
        char chinChar = chinCheckBox.isSelected()?'c':'-';
        char glasssesChar = glassesCheckBox.isSelected() ? 'g':'-';
        char hairChar = hairCheckBox.isSelected() ? 'h':'-';
        char teethChar = teethCheckBox.isSelected() ? 't':'-';
        String pictureName = "geek-"+chinChar+glasssesChar+hairChar+teethChar+".gif";
        updatePicture(pictureName);
    }

    private void updatePicture(String pictureName) {
        ImageIcon imageIcon = new ImageIcon(pictureName);
        pictureLabel.setIcon(imageIcon);
    }
}
