package org.akademija.one;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Po defaultu koristi FlowLayout
 * slaže GUI element
 */
public class ButtonPanel extends JPanel {

    private final JButton leftButton = new JButton("Disable middle button");
    private final JButton middleButton = new JButton("Middle button");
    private final JButton rightButton = new JButton("Enable middle button");


    public ButtonPanel() {
        add(leftButton);
        add(middleButton);
        add(rightButton);
        init();
    }

    private void init() {
        ImageIcon leftIcon = createIcon("right.gif");
        leftButton.setEnabled(true);
        leftButton.setHorizontalTextPosition(SwingConstants.LEADING);
        leftButton.setIcon(leftIcon);
        middleButton.setEnabled(true);
        ImageIcon middleIcon = new ImageIcon("middle.gif");
        middleButton.setIcon(middleIcon);
        middleButton.setHorizontalTextPosition(SwingConstants.CENTER);
        middleButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        rightButton.setEnabled(false);
        ImageIcon rightIcon = new ImageIcon("left.gif");
        rightButton.setIcon(rightIcon);

        //leftButton -> blok koda
        ActionListener leftButtonListener = this::onButtonClick;
        leftButton.setActionCommand("DISABLE");
        leftButton.addActionListener(leftButtonListener);
        leftButton.setMnemonic(KeyEvent.VK_D);
        //rightButton -> blok koda
        rightButton.addActionListener(this::onButtonClick);
        rightButton.setMnemonic(KeyEvent.VK_E);
    }

    private ImageIcon createIcon(String urlPath) {
        return new ImageIcon(urlPath);
        //Class clazz = ButtonPanel.class;
        // URL imageUrl = ButtonPanel.class.getClassLoader().getResource(urlPath);
       /* if (imageUrl == null) {
            System.err.println("Nema jarane na ovom url pathu nista");
            return null;
        } else {
            return new ImageIcon(imageUrl);
        }*/
    }


    private void onButtonClick(ActionEvent event) {
        String actionCommand = event.getActionCommand();
        if (actionCommand.equalsIgnoreCase("DISABLE")) {
            leftButton.setEnabled(false);
            middleButton.setEnabled(false);
            rightButton.setEnabled(true);
        } else {
            rightButton.setEnabled(false);
            middleButton.setEnabled(true);
            leftButton.setEnabled(true);
        }
    }
   /* private void onLeftButtonClick(ActionEvent event){
        leftButton.setEnabled(false);
        middleButton.setEnabled(false);
        rightButton.setEnabled(true);
    }

    private void onRightButtonClick(ActionEvent event){
        rightButton.setEnabled(false);
        middleButton.setEnabled(true);
        leftButton.setEnabled(true);
    }*/
/*
    private class LeftButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            leftButton.setEnabled(false);
            middleButton.setEnabled(false);
            rightButton.setEnabled(true);
        }
    }


    private class RightButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            rightButton.setEnabled(false);
            middleButton.setEnabled(true);
            leftButton.setEnabled(true);
        }
    }
*/
}
