package org.akademija.six.gui.ui;

import org.akademija.six.gui.dao.Player;
import org.akademija.six.gui.dao.PlayerDao;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

/**
 * <p> DB
 * sports.players....ConnectionParam, ConnectionPool
 * <li>Player</li>
 * <li>PlayerDao implements Dao<Player></li>
 * UI ili GUI
 * <li>PlayerPanel</li>
 * </p>
 */
public class PlayerPanel extends JPanel {

    /**
     * Želimo vizuelno prikazati podatke iz players.
     * <p>
     * List<Player>  < -----TableModel--- > JTable
     */
    private List<Player> players;
    private final PlayerDao playerDao = new PlayerDao();
    private final JTable playerTable;

    /**
     * Da bi funkcionisalo sortiranje, uklanjanje, filtriranje...
     */
    private final TableRowSorter<PlayerTableModel> tableRowSorter;
    /**
     * searchTextField    < ---- > "an"  name column zadovoljava uslov d
     */
    private final JTextField searchTextField;

    public PlayerPanel() {
        super();
        this.players = playerDao.getAll();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        /**
         * JTable playerTable   <---- TABLE MODEL ----> PlayerDao
         *
         */
        PlayerTableModel playerTableModel = new PlayerTableModel();
        this.tableRowSorter = new TableRowSorter<>(playerTableModel);
        PlayerTableModelListener playerTableModelListener = new PlayerTableModelListener();
        playerTableModel.addTableModelListener(playerTableModelListener);
        this.playerTable = new JTable(playerTableModel);
        this.playerTable.setRowSorter(tableRowSorter);
        playerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //SPORT
        TableColumn sportColumn = playerTable.getColumnModel().getColumn(3);
        JComboBox<String> sportComboBox = new JComboBox<>();
        sportColumn.setCellEditor(new DefaultCellEditor(sportComboBox));


        players.stream()
                .map(Player::getSport)
                .distinct()
                .forEach(sportComboBox::addItem);

        JPanel searchForm = new JPanel(new GridLayout(1, 1));
        searchForm.setSize(200, 30);
        JLabel labela = new JLabel("Filter by: ", SwingConstants.TRAILING);
        searchForm.add(labela);
        this.searchTextField = new JTextField();
        SearchTextFieldDocumentListener searchTextFieldDocumentListener = new SearchTextFieldDocumentListener();
        this.searchTextField.getDocument().addDocumentListener(searchTextFieldDocumentListener);
        labela.setLabelFor(searchTextField);
        searchForm.add(searchTextField);
        add(searchForm);

        JScrollPane playerTableScrollPane = new JScrollPane(playerTable);
        add(playerTableScrollPane);

        ButtonGroup radioButtonGroup = new ButtonGroup();
        RadioButtonActionListener radioButtonActionListener = new RadioButtonActionListener();
        JRadioButton singleSelectOptionRadioButton = new JRadioButton("SINGLE ROW SELECT");
        singleSelectOptionRadioButton.setSelected(true);
        singleSelectOptionRadioButton.addActionListener(radioButtonActionListener);
        radioButtonGroup.add(singleSelectOptionRadioButton);
        add(singleSelectOptionRadioButton);
        JRadioButton multiSelectOptionRadioButton = new JRadioButton("MULTIPLE ROW SELECT");
        multiSelectOptionRadioButton.addActionListener(radioButtonActionListener);
        radioButtonGroup.add(multiSelectOptionRadioButton);
        add(multiSelectOptionRadioButton);
    }


    /**
     * <li>1. search text field -> oživiti na način da se na svaku promjenu dešava poziv funkcije filterByName()</li>
     * <li>2. modifikovati prikaz tabele na način da ona bude spremna za bilo kakvo sortiranje, filtriranje redova...</li>
     * <li>3.  uzmemo unos u search text field "an"  i da preko sortera ostavimo samo one redove koji zadovoljavaju row filter</li>
     */
    private void filterByName() {
        RowFilter<PlayerTableModel, Object> rowFilter = RowFilter.regexFilter(searchTextField.getText(), 1, 2, 3);
        tableRowSorter.setRowFilter(rowFilter);
    }

    private class SearchTextFieldDocumentListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            filterByName();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            filterByName();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            filterByName();
        }
    }

    private class RadioButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String komanda = e.getActionCommand();
            System.out.println(komanda);
            if ("MULTIPLE ROW SELECT".equals(komanda)) {
                playerTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            } else {
                playerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
        }
    }

    private class PlayerTableModelListener implements TableModelListener {

        @Override
        public void tableChanged(TableModelEvent event) {
            int rowIndex = event.getFirstRow();
            int columnIndex = event.getColumn();
            PlayerTableModel model = (PlayerTableModel) event.getSource();
            System.out.println("Desila se promjena : " + model.getValueAt(rowIndex, columnIndex));
        }
    }

    /**
     * players DB   PlayerDao    -->  PlayerTableModel    --> JTable
     */

    private class PlayerTableModel extends AbstractTableModel {

        private List<String> columnNames;

        public PlayerTableModel() {
            this.columnNames = playerDao.getColumnNames();
        }

        @Override
        public int getRowCount() {
            return players.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.size();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Player player = players.get(rowIndex);
            PlayerWrapper playerWrapper = new PlayerWrapper(player);
            Object playerFieldOnIndex = playerWrapper.getColumValue(columnIndex);
            return playerFieldOnIndex;
        }

        /**
         * @param aValue      value to assign to cell
         * @param rowIndex    row of cell
         * @param columnIndex column of cell
         */
        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            //aValue MIRSO
            //rowIndex -> indeks reda u kojem se desila promjena
            Player player = players.get(rowIndex);
            //columnIndex -> indeks kolone u kojoj se desila promjena
            System.out.println("Indeks: " + columnIndex);
            PlayerWrapper playerWrapper = new PlayerWrapper(player);
            playerWrapper.setColumValue(columnIndex, aValue);
            playerDao.update(player);
            fireTableCellUpdated(rowIndex, columnIndex);
        }

        @Override
        public String getColumnName(int column) {
            return columnNames.get(column);
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            Class<?> clazz = getValueAt(0, columnIndex).getClass();
            return clazz;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex > 0;
        }
    }
}
