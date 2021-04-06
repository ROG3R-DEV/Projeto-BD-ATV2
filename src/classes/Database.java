package classes;

import java.sql.*;

public class Database {
    private Connection con;
    private String host;
    private String database;
    private String user;
    private String password;

    public Database(String host, String database, String user, String password) {
        this.host = host;
        this.database = database;
        this.user = user;
        this.password = password;
    }

    public Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = String.format("jdbc:mysql://%s:3306/%s", host, database);
            this.con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch(ClassNotFoundException ex){
            System.out.println(ex);
        }
        return con;
    }

    public Connection disconnect() {
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
        return con;
    }
}
