package org.akademija.four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

/**
 * FlowLayout -> BorderLayout
 */
public class ComboBoxPanel extends JPanel  {
//    implements ActionListener RJEŠENJE ¸1

    private String[] petList = {"Rabbit", "Bird", "Cat", "Dog", "Pig"};
    private final JComboBox<String> petComboBox;
    private final JLabel pictureLabel;

    public ComboBoxPanel() {
        super(new BorderLayout());
        //setLayout(new BorderLayout());
        this.petComboBox = new JComboBox<>(petList);
        ComboBoxListener comboBoxListener = new ComboBoxListener(this::updatePictureLabel);
        this.petComboBox.addActionListener(comboBoxListener);
        this.pictureLabel = new JLabel();
        this.pictureLabel.setPreferredSize(new Dimension(400, 300));
        this.updatePictureLabel(petList[0]);

        add(petComboBox, BorderLayout.PAGE_START);
        add(pictureLabel, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    void updatePictureLabel(String pictureName){
        ImageIcon imageIcon = new ImageIcon(pictureName+".gif");
        pictureLabel.setIcon(imageIcon);
        pictureLabel.setToolTipText("Omiljena životinja je : " + pictureName);
    }

    //RJEŠENJE 1
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        String petName = (String) petComboBox.getSelectedItem();
//        updatePictureLabel(petName);
//    }

    //RJEŠENJE 2
//    private class ComboBoxListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent event) {
//            JComboBox<String> comboBox = (JComboBox<String>) event.getSource();
//            String petName = (String) comboBox.getSelectedItem();
//            updatePictureLabel(petName);
//        }
//    }
}
