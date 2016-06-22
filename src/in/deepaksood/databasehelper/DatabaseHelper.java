package in.deepaksood.databasehelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by deepaksood619 on 20/6/16.
 */
public class DatabaseHelper {

    private String userName;
    private String password;
    private String dbName;

    public DatabaseHelper(String userName, String password) {
        this.userName = userName;
        this.password = password;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean createDatabase(String dbName) {
        this.dbName = dbName;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/",
                    userName, password);
            Statement statement = connection.createStatement();

            statement.execute("drop database if exists " + dbName);
            statement = connection.createStatement();
            statement.execute(" Create database " + dbName);
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return false;
        }
    }

    public void destroyDatabase() {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/", userName, password);
            Statement stmt = con.createStatement();
            stmt.executeUpdate(" DROP database " + dbName);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                    + dbName, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public String getDbname() {
        return dbName;
    }

}
