package org.akademija.four;

import javax.swing.*;
import java.awt.*;

public class ComboBoxPanel3 extends JPanel {

    private final String[] petNameList = { "Dog", "Pig","Rabbit", "Bird", "Cat"};
    private final ImageIcon[] petImageIcons = new ImageIcon[petNameList.length];

    private final JComboBox<Integer> petTextAndPictureComboBox;

    public ComboBoxPanel3() {
        Integer[] petIndexArray = new Integer[petNameList.length];
        for (int i = 0; i < petNameList.length; i++) {
            petIndexArray[i] = i;
            ImageIcon imageIcon = new ImageIcon(petNameList[i] + ".gif");
            petImageIcons[i] = imageIcon;
            petImageIcons[i].setDescription(petNameList[i]);
        }
        this.petTextAndPictureComboBox = new JComboBox<>(petIndexArray);
        ComboBoxItemRenderer comboBoxItemRenderer = new ComboBoxItemRenderer();
        //comboBoxItemRenderer.setPreferredSize(new Dimension(800, 180));
        this.petTextAndPictureComboBox.setRenderer(comboBoxItemRenderer);
        //this.petTextAndPictureComboBox.setMaximumRowCount(3);

        //dodati na panel UI kontrolu zvanu JComboBox
        add(petTextAndPictureComboBox, BorderLayout.PAGE_START);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }



    private class ComboBoxItemRenderer extends JLabel implements ListCellRenderer<Integer>{

        public ComboBoxItemRenderer(){
            setOpaque(true);
            setHorizontalAlignment(CENTER);
            setVerticalAlignment(CENTER);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Integer> list,
                                                      Integer value,
                                                      int index,
                                                      boolean isSelected,
                                                      boolean cellHasFocus) {
            if(isSelected){
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            }else{
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            ImageIcon imageIcon = petImageIcons[value];
            String text = petNameList[value];
            setIcon(imageIcon);
            setText(text);
            return this;
        }
    }
}
