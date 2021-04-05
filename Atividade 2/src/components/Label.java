package components;

import javax.swing.*;

public class Label {
    private String title;
    private int width;
    private int height;
    private int x;
    private int y;
    private JLabel b;

    public Label(String title, int width, int height, int x, int y) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.b = new JLabel(title);
        this.b.setBounds(x, y, width, height);
    }

    public String getTitle() {
        return this.title;
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

    public JLabel render() {
        return this.b;
    }
}
