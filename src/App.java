import javax.swing.*;

import components.Button;
import components.Label;
import components.TableGroup;
import components.TextInput;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Running!!");
        createWindow();
    }

    public static void createWindow() {
        JFrame frame = new JFrame("App Conexão com BD"); 
    
        Label labelId = new Label("ID:", 40, 20, 140, 30);
        Label labelName = new Label("Nome:", 60, 20, 140, 60);
        Label labelEmail = new Label("E-Mail:", 60, 20, 140, 90);
        TextInput inputId = new TextInput(20, 40, 20, 160, 30);
        TextInput inputName = new TextInput(20, 200, 20, 185, 60);
        TextInput inputEmail = new TextInput(20, 200, 20, 185, 90);

        Button btnInsert = new Button("Inserir", 80, 40, 15, 130);
        Button btnSelect = new Button("Selecionar", 100, 40, 100, 130);
        Button btnDelete = new Button("Excluir", 80, 40, 205, 130);
        Button btnEdit = new Button("Alterar", 90, 40, 290, 130);
        Button btnClear = new Button("Limpar", 95, 40, 385, 130);

        Object [][] data = {
            {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
            {"João da Silva", "48 8890-3345", "joaosilva@hotmail.com"},
            {"Joãxo da Silva", "48 8890-3345", "joaosilva@hotmail.com"},
            {"Joãso da Silva", "48 8890-3345", "joaosilva@hotmail.com"},
            {"Jo3ão da Silva", "48 8890-3345", "joaosilva@hotmail.com"},
            {"Jwoão da Silva", "48 8890-3345", "joaosilva@hotmail.com"},
            {"Joãdo da Silva", "48 8890-3345", "joaosilva@hotmail.com"},
            {"Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com"}
        };
    
        String [] cols = {"ID", "Nome", "E-mail"};
        
        TableGroup table = new TableGroup(cols, data, 20, 180, 460, 180);

        btnInsert.onClick(() -> System.out.println("BtnInsert"));
        btnSelect.onClick(() -> System.out.println("btnSelect"));
        btnDelete.onClick(() -> System.out.println("btnDelete"));
        btnEdit.onClick(() -> System.out.println("btnEdit"));
        btnClear.onClick(() -> System.out.println("btnClear"));

        frame.add(table.render());
        frame.add(labelId.render());
        frame.add(inputId.render());
        frame.add(labelName.render());
        frame.add(inputName.render());
        frame.add(labelEmail.render());
        frame.add(inputEmail.render());
        frame.add(btnInsert.render());
        frame.add(btnSelect.render());
        frame.add(btnDelete.render());
        frame.add(btnEdit.render());
        frame.add(btnClear.render());

        frame.setDefaultCloseOperation(3);
        frame.setResizable(false);
        frame.setSize(500,400);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
