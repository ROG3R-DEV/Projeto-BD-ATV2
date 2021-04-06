import javax.swing.JFrame;

import classes.Client;
import classes.Database;
import scripts.formatResult;
import components.Button;
import components.Label;
import components.TableGroup;
import components.TextInput;

public class App {
    static Database db = new Database("127.0.0.1", "atv2", "root", "12345678");
    static formatResult result = new formatResult();

    public static void main(String[] args) throws Exception {
        System.out.println("Running!!");
        db.connect();
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
        
        String[] cols = {"ID", "Nome", "E-mail"};
        Client[] clients = result.formatClient(db.select("client"));
        TableGroup table = new TableGroup(cols, 20, 180, 460, 180);

        btnInsert.onClick(() -> System.out.println("BtnInsert"));
        btnSelect.onClick(() -> fetchClients(table, clients));
        btnDelete.onClick(() -> System.out.println("btnDelete"));
        btnEdit.onClick(() -> System.out.println("btnEdit"));
        btnClear.onClick(() -> table.clear());

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

    public static void fetchClients(TableGroup table, Client[] clients) {
        for (int i = 0; i < clients.length; i++) {
          table.addRow(new Object[] {
            clients[i].getId(), clients[i].getName(), clients[i].getEmail()
          });
        }
    }
}
