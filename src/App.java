import javax.swing.JFrame;

import classes.Database;
import components.Button;
import components.Label;
import components.TableGroup;
import components.TextInput;
import static scripts.Functions.*;
import static scripts.FormatResult.*;

public class App {
  static Database db = new Database("127.0.0.1", "atv2", "root", "12345678");

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

    String[] cols = {
      "ID",
      "Nome",
      "E-mail"
    };
    TableGroup table = new TableGroup(cols, 20, 180, 460, 180);

    inputId.setEditable(false);

    inputName.onFocus(() -> inputName.setText(inputName.getText().toUpperCase()));

    inputEmail.onFocus(() -> inputEmail.setText(inputEmail.getText().toLowerCase()));

    btnInsert.onClick(() -> {
      showDialogInsert(() -> {
        db.insert(inputName.getText(), inputEmail.getText());
        table.clear();
      }, () -> fetchClients(table, formatClient(db.select("client"))), inputName.getText());
    });

    btnSelect.onClick(() -> fetchClients(table, formatClient(db.select("client"))));

    btnDelete.onClick(() -> {
      showDialogDelete(() -> {
        db.delete(Integer.parseInt(inputId.getText()));
        table.clear();
      }, () -> fetchClients(table, formatClient(db.select("client"))), inputName.getText());
    });

    btnEdit.onClick(() -> {
      showDialogEdit(() -> {
        db.edit(Integer.parseInt(inputId.getText()), inputName.getText(), inputEmail.getText());
        table.clear();
      }, () -> fetchClients(table, formatClient(db.select("client"))), inputName.getText());
    });

    btnClear.onClick(() -> {
      inputId.setText("");
      inputName.setText("");
      inputEmail.setText("");
    });

    table.onSelectItem(() -> {
      inputId.setText((table.getValueAt(table.getSelectedRow(), 0)));
      inputName.setText((table.getValueAt(table.getSelectedRow(), 1)));
      inputEmail.setText((table.getValueAt(table.getSelectedRow(), 2)));
    });

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
    frame.setSize(500, 400);
    frame.setLayout(null);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}