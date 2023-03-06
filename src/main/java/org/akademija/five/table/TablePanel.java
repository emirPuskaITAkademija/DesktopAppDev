package org.akademija.five.table;

import org.akademija.six.gui.dao.Player;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.List;
import java.util.Vector;
import java.util.stream.Stream;

/**
 * TablePanel : kontejnerska
 * JTable: GUI kontrola
 * Layout Manageri: BoxLayout -> X i Y osi
 *
 * <p>
 * AbstractTableModel(TableModel) -> JTable
 *
 * MyTableModel  3 metode  -> JTable
 * </p>
 */
public class TablePanel extends JPanel {
    public TablePanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //MyTAbleModel, AbstractTableModel, TableModel
        MyTableModel tableModel = new MyTableModel();
        JTable table = new JTable(tableModel);

        TableColumn sportColumn = table.getColumnModel().getColumn(2);
        JComboBox<String> sportComboBox = new JComboBox<>();
        Sport[] sports = Sport.values();
        Stream.of(sports)
                .map(Sport::getName)
                .forEach(sportComboBox::addItem);
//        for(Sport sport: Sport.values()){
//            String sportName = sport.getName();
//            sportComboBox.addItem(sportName);
//        }
        sportColumn.setCellEditor(new DefaultCellEditor(sportComboBox));

        //String.class, Integer.class, Boolean.class, java.awt.Color.class
        ColorCellRenderer colorCellRenderer = new ColorCellRenderer();
        table.setDefaultRenderer(Color.class, colorCellRenderer);

        ColorCellEditor colorCellEditor = new ColorCellEditor();
        table.setDefaultEditor(Color.class, colorCellEditor);

        table.setBorder(BorderFactory.createLineBorder(Color.CYAN));
        JScrollPane scrollPane = new JScrollPane(table);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(scrollPane);
    }


    private class MyTableModel extends AbstractTableModel {
        private String[] columnNames = {"Name", "Surname", "Sport", " # godina", "Vegetarijanac", "Boja"};
        private Object[][] data = {
                {"Mirsad", "Škandro", Sport.SKIJANJE.getName(), 23, true, Color.CYAN},
                {"Alden", "Efendić", Sport.ŠAH.getName(), 12, false, Color.GREEN},
                {"Dejla", "Šarić", Sport.ODBOJKA.getName(), 5, true, Color.BLUE},
                {"Slađana", "Jokić", Sport.SKIJANJE.getName(), 23, false, new Color(234, 100, 83)},
                {"Anja", "Škandro", Sport.ŠAH.getName(), 12, false, Color.PINK},
                {"Eldar", "Halilović", Sport.ŠAH.getName(), 12, false, Color.GRAY},
                {"Eldar", "Pediša", Sport.ŠAH.getName(), 12, false, Color.YELLOW},
        };

        private List<Player> playerData;



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
        public String getColumnName(int column) {
           return columnNames[column];
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            data[rowIndex][columnIndex] = aValue;
        }

        /**
         * String.class, String.class, String.class, Integer.class, Boolean.class
         * @param columnIndex  the column being queried
         * @return Class
         */
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return getValueAt(0, columnIndex).getClass();
        }
    }

//    public static void main(String[] args) {
//        Object name = "";
//        if(name instanceof Integer){
//
//        }else if(name instanceof String){
//
//        }else if(name instanceof Double){
//
//        }else if(name instanceof Boolean){
//
//        }
//    }
}
