package org.akademija.four;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

/**
 * FAVOR COMPOSITION over INHERITANCE
 */
public class ComboBoxListener implements ActionListener {

    //LOOSE COUPLED LOGIC  -> SLABO SPREGNUTA LOGIKA
    //DEPEND UPON ABSTRACTION(interface, abstract class) NOT UPON CONCRETE CLASS IMPLEMENTATION
    private final Consumer<String> stringConsumer;

    public ComboBoxListener(Consumer<String> stringConsumer) {
        this.stringConsumer = stringConsumer;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JComboBox<String> comboBox = (JComboBox<String>) event.getSource();
        String selectedStringItem = (String) comboBox.getSelectedItem();
        stringConsumer.accept(selectedStringItem);
    }
}
