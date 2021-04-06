package classes;

import java.sql.*;

public class Database {
    private Connection con;
    private PreparedStatement statement; 
    private ResultSet result;
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
            System.out.println("Disconnected!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
        return con;
    }

    public ResultSet select(String table) {
        try {
            this.statement = this.con.prepareStatement("SELECT * FROM " + table);
            this.result = this.statement.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return this.result;
    }

    public void insert(String name, String email) {
        try {
            PreparedStatement stmt = this.con.prepareStatement("INSERT INTO client (name,email) values (?,?)");
            stmt.setString(1, name);
            stmt.setString(2, email);    
            stmt.execute();
            stmt.close();
            System.out.println("Inserted!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }

    public void closeStatement() {
        try {
            this.statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
