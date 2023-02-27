package org.akademija.five.table;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ColorCellRenderer extends JLabel implements TableCellRenderer {

    public ColorCellRenderer() {
        setOpaque(true);//OVO MORA BITI POZVANO KAKO BIH VIDIO BACKGROUND
    }

    @Override
    public Component getTableCellRendererComponent(JTable table,
                                                   Object objectValue,
                                                   boolean isSelected,
                                                   boolean hasFocus,
                                                   int row,
                                                   int column) {

        if(objectValue instanceof Color){
            Color color = (Color) objectValue;
            setBackground(color);
            Border border;
            if(isSelected){
                setText(String.format("RGB(%s,%s,%s)", color.getRed(), color.getGreen(), color.getBlue()));
//                border = BorderFactory.createMatteBorder(2,5,5,2, table.getSelectionBackground());
//                setBorder(border);
            }else{
                setText("");
//                border = BorderFactory.createMatteBorder(2,5,5,2, table.getBackground());
//                setBorder(border);
            }
            setToolTipText("Boja: " + color.toString());
        }
        return this;
    }


}
