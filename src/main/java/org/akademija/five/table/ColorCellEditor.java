package org.akademija.five.table;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorCellEditor extends AbstractCellEditor implements TableCellEditor {

    private Color currentColor;
    private JButton button;
    private JColorChooser colorChooser;
    private JDialog dialog;

    public ColorCellEditor(){
        this.button = new JButton();
        this.button.setBorderPainted(false);
        this.button.setOpaque(true);
        this.button.addActionListener(this::nekoNaButtonKlikno);

        this.colorChooser = new JColorChooser();
        this.dialog = JColorChooser.createDialog(button,
                "Pick a color",
                true,
                colorChooser,
                this::onColorChangeExecute,
                null);
    }


    public void nekoNaButtonKlikno(ActionEvent event) {
        colorChooser.setColor(currentColor);
        dialog.setVisible(true);
    }

    public void onColorChangeExecute(ActionEvent event){
        currentColor = colorChooser.getColor();
        fireEditingStopped();
    }

    //JButton
    @Override
    public Component getTableCellEditorComponent(JTable table, Object objectValue, boolean isSelected, int row, int column) {
        currentColor = (Color) objectValue;
        button.setText("(" + currentColor.getRed()+","+currentColor.getGreen()+","+currentColor.getBlue()+")");
        button.setBorderPainted(true);
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return currentColor;
    }
}
