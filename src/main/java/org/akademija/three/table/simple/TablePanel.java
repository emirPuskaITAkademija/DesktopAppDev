package org.akademija.three.table.simple;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Kolone i redove: konstrukcija JTable
 * String[]
 * Object[][] data
 */
public class TablePanel extends JPanel {

    //Java SE JTable
    private String[] columnNames = {"Name", "Surname", "Sport", " # godina", "Vegetarijanac"};
    private Object[][] data = {
            {"Mirsad", "Škandro", "Skijanje", 23, true},
            {"Alden", "Efendić", "Šah", 12, false},
            {"Dejla", "Šarić", "Odbojka", 5, true},
            {"Slađana", "Jokić", "Košarka", 23, false},
            {"Anja", "Škandro", "Šah", 12, false},
            {"Alden", "Škandro", "Šah", 12, false},
            {"Alden", "Škandro", "Šah", 12, false},
    };

    private final JTable table = new JTable(data, columnNames);

    public TablePanel(){
        setLayout(new GridLayout(1, 0));
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.addMouseListener(new CustomTableMouseListener());
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    private class CustomTableMouseListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent event) {
            int numberOfRows = table.getRowCount();
            int numberOfColmns = table.getColumnCount();
            TableModel tableModel = table.getModel();
            for(int i = 0; i< numberOfRows; i++){
                for(int j = 0; j<numberOfColmns; j++){
                    //0 0  ->  0 1 -> 0 2
                    System.out.print(tableModel.getValueAt(i, j)+"  -   ");
                }
                System.out.println();
            }
        }
    }
}
