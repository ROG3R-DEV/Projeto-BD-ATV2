package scripts;

import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Client;

public class formatResult {
    public Client[] formatClient(ResultSet result) {
        Client[] client = new Client[30];
        Client[] output;
        int size = 0;
        try {
            while (result.next()) {
              int id = result.getInt("id");
              String name = result.getString("name");
              String email = result.getString("email"); 
              client[result.getRow() - 1] = new Client(id, name, email);
              if (result != null) 
                  size = result.getRow();   
            }

            output = new Client[size];
            for(int i = 0; i < size; i++) {
                output[i] = new Client(client[i].getId(), client[i].getName(), client[i].getEmail());
            }
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
