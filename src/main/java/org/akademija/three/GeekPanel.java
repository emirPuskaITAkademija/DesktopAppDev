package org.akademija.three;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class GeekPanel extends JPanel implements ItemListener {
    private final CheckBoxPanel checkBoxPanel = new CheckBoxPanel(this);
    private final PicturePanel picturePanel = new PicturePanel("geek-cght.gif");

    public GeekPanel(){
        setLayout(new BorderLayout());
        add(BorderLayout.LINE_START, checkBoxPanel);
        add(BorderLayout.CENTER, picturePanel);
    }

    //geek-____.gif

    /**
     *
     * StringBuffer pictureBuffer = new StringBuffer("geek-cght.gif");
     * pictureBuffer.setCharAt(5, 'c');
     * geek-_g
     * @param event the event to be processed
     */
    @Override
    public void itemStateChanged(ItemEvent event) {
        Object source = event.getSource();
        char slovo = '-';
        int index = -1;
        if(source == checkBoxPanel.getChinCheckBox()){
            slovo = 'c';
            index = 5;
        }else if(source == checkBoxPanel.getGlassesCheckBox()){
            slovo = 'g';
            index = 6;
        }else if(source == checkBoxPanel.getHairCheckBox()){
            slovo = 'h';
            index = 7;
        }else if(source == checkBoxPanel.getTeethCheckBox()){
            slovo = 't';
            index = 8;
        }
        if(event.getStateChange()==ItemEvent.DESELECTED){
            slovo = '-';
        }
        picturePanel.updatePictureName(slovo, index);
    }
}
