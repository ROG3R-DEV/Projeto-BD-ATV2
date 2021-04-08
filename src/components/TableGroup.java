package components;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;

public class TableGroup {
    private int width;
    private int height;
    private int x;
    private int y;
    private JPanel panel;
    private JTable table;
    private JScrollPane scrollBar;
    private String[] columns;
    private Object[][] data;
    private DefaultTableModel model;

    public TableGroup(String[] columns, int width, int height, int x, int y) {
        this.columns = columns;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(1, 1));
        this.model = new DefaultTableModel(this.columns, 0);
        this.table = new JTable(this.model);
        this.scrollBar = new JScrollPane(this.table);
        this.panel.add(this.scrollBar);        
        this.panel.setBounds(width, height, x, y);
    }

    public String[] getColumns() {
        return this.columns;
    }

    public void setColumns(String[] cols) {
        this.columns = cols;
    }

    public Object[][] getData() {
        return this.data;
    }

    public void setData(Object[][] data) {
        this.data = data;
    }

    public int getWidth() {
        return this.width;
    }
    
    public int getHeight() {
        return this.height;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    
    public void addRow(Object[] rowData) {
        this.model.addRow(rowData);
    }
    
    public void setEnabled(boolean enabled) {
        this.table.setEnabled(enabled);
    }

    public void clear() {
        this.model.setRowCount(0); 
    }

    public int getSelectedRow() {
        return this.table.getSelectedRow();
    }

    public String getValueAt(int row, int column) {
        return this.table.getValueAt(row, column).toString();
    }

    public void onSelectItem(Runnable function) {
        this.table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (getSelectedRow() != -1) { 
                    function.run();
                }
            }
        });
    }
    
    public JPanel render() {
        return this.panel;
    }
}
