package components;

import javax.swing.*;

public class TextInput {
    private int columns;
    private int width;
    private int height;
    private int x;
    private int y;
    private JTextField t;

    public TextInput(int columns, int width, int height, int x, int y) {
        this.columns = columns;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.t = new JTextField(columns);
        this.t.setBounds(x, y, width, height);
    }

    public int getColumns() {
        return this.columns;
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

    public JTextField render() {
        return this.t;
    }
}
