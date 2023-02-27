package org.akademija.three.table.simpler;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

/**
 * Kolone i redovi:
 * TableModel   -> JTable
 */
public class ComplexTablePanel extends JPanel {

    private final JTable complexTable;

    public ComplexTablePanel(){
        TableModel tableModel = new CustomTableModel();
        tableModel.addTableModelListener(new CustomTableListener());
        this.complexTable = new JTable(tableModel);
        this.complexTable.setFillsViewportHeight(true);
        this.complexTable.setPreferredScrollableViewportSize(new Dimension(500, 80));

        JScrollPane scrollPane = new JScrollPane(complexTable);
        add(scrollPane);
    }


    class CustomTableListener implements TableModelListener{

        @Override
        public void tableChanged(TableModelEvent event) {
            int row = event.getFirstRow();
            int column = event.getColumn();
            TableModel tableModel =(TableModel) event.getSource();
            String columnName = tableModel.getColumnName(column);
            Object data = tableModel.getValueAt(row, column);
            System.out.println(data);
        }
    }

    class CustomTableModel extends AbstractTableModel{
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
        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            data[rowIndex][columnIndex] = aValue;// -> update podatka  bazi
            fireTableCellUpdated(rowIndex, columnIndex);// -> update podatka vizuelno
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

        /**
         * JTable koristi model i ovu funkciju unutar modela da odredi
         * način na koji će se RENDEEROVATI/UČITATI neka ćelija u koloni.
         * <p>
         *     Obratiti pažnju na kolonu koja prikazuje TRUE/FALSE
         * </p>
         *
         * @param columnIndex  the column being queried
         * @return columnNames
         */
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return getValueAt(0, columnIndex).getClass();
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            if(columnIndex<2){
                return true;
            }else{
                return false;
            }
        }
    }
}
