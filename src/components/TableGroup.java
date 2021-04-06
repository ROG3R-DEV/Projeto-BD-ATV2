package components;

import javax.swing.*;
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

    public TableGroup(String[] columns, Object[][] data, int width, int height, int x, int y) {
        this.columns = columns;
        this.data = data;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(1, 1));
        this.table = new JTable(data, columns);
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

    public JPanel render() {
        return this.panel;
    }
}
