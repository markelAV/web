package app.dao;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    static  final String URL ="jdbc:mysql://127.0.0.1:3306/data_of_heroes?serverTimezone=Europe/Moscow&useSSL=false";
    static final String LOGIN="root";
    static final String PASSWORD="root";
    private static ConnectionDB instance = null;
    private ConnectionDB(){}

    public static ConnectionDB getInstance(){
        if (instance==null)
            instance = new ConnectionDB();
        return instance;
    }

   public Connection getConnection2(){
       Context ctx;
       Connection c = null;
       try {
           ctx = new InitialContext();
           DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/db");
           c = ds.getConnection();
       } catch (NamingException e) {
           e.printStackTrace();
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return c;
   }
    static Connection getConnection(){
        Connection con = null;
        try {
             Class.forName("com.mysql.jdbc.Driver");
             DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
             con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             System.out.println("Got our connection");

        } catch (SQLException e) {
            e.printStackTrace();}
       catch(ClassNotFoundException e){
           e.printStackTrace();
       }

        return con;
    }
}
