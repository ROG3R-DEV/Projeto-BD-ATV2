package scripts;

import javax.swing.JOptionPane;

import classes.Client;
import components.TableGroup;

public class Functions {
  public static void fetchClients(TableGroup table, Client[] clients) {
    for (int i = 0; i < clients.length; i++) {
      table.addRow(new Object[] {
        clients[i].getId(), clients[i].getName(), clients[i].getEmail()
      });
    }
  }

  public static void showDialogDelete(Runnable
    function, Runnable functionTwo, String user) {
    int option = JOptionPane.showConfirmDialog(null, "Deja excluir " + user + " ?");
    if (option == 0) {
      function.run();
      JOptionPane.showConfirmDialog(null, "Usuário excluido com sucesso !", "Mensagem", JOptionPane.DEFAULT_OPTION);
      functionTwo.run();
    }
  }

  public static void showDialogInsert(Runnable
    function, Runnable functionTwo, String user) {
    int option = JOptionPane.showConfirmDialog(null, "Deja adicionar " + user + " ao banco ?");
    if (option == 0) {
      function.run();
      JOptionPane.showConfirmDialog(null, "Usuário adicionado com sucesso !", "Mensagem", JOptionPane.DEFAULT_OPTION);
      functionTwo.run();
    }
  }

  public static void showDialogEdit(Runnable
    function, Runnable functionTwo, String user) {
    int option = JOptionPane.showConfirmDialog(null, "Salvar alteraçōes feitas em " + user + " ?");
    if (option == 0) {
      function.run();
      JOptionPane.showConfirmDialog(null, "Alterações Salvas !", "Mensagem", JOptionPane.DEFAULT_OPTION);
      functionTwo.run();
    }
  }
}