package in.deepaksood.databasehelper;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by deepaksood619 on 20/6/16.
 */
public class DatabaseHelper {

    private String userName;
    private String password;
    private String dbName;

    private static DatabaseHelper sharedInstance;
    public static DatabaseHelper shared() {
        if(sharedInstance == null) {
            sharedInstance = new DatabaseHelper("root","root", "connectbook");
        }
        return sharedInstance;
    }

    public DatabaseHelper(String userName, String password, String dbName) {
        this.userName = userName;
        this.password = password;
        this.dbName = dbName;

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

    public boolean executeUpdate(String sqlQuery) {
        System.out.println("sqlUpdate: "+sqlQuery);
        Statement statement;
        try {
            Connection connection = getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sqlQuery);
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<String> executeSelect(String sqlQuery) {
        System.out.println("selectQuery: "+sqlQuery);
        Statement statement;
        ArrayList<String> requesterEmail = new ArrayList<>();
        try {
            Connection connection = getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while(resultSet.next()) {
                requesterEmail.add(resultSet.getString(1));
            }


            connection.close();
            return requesterEmail;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean checkIfExists(String sqlQuery) {
        Statement statement;
        try {
            Connection connection = getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            if(resultSet.next()) {
                return true;
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkPassword(String email, String password) {
        Statement statement;
        try {
            Connection connection = getConnection();
            statement = connection.createStatement();
            String sqlQuery = "SELECT password FROM users WHERE email=\""+email+"\"";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            if(resultSet.next()) {
                String savedPassword = resultSet.getString(1);
                if(savedPassword.equals(password)) {
                    return true;
                }
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public String getName(String sqlQuery) {
        System.out.println("query: "+sqlQuery);

        Statement statement;
        try {
            Connection connection = getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            if(resultSet.next()) {
                String firstName = resultSet.getString(1);
                String lastName = resultSet.getString(2);
                return firstName +" "+lastName;
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String[] getProfileDetails(String profileEmail) {
        String sqlQuery = "SELECT * FROM users WHERE email=\""+profileEmail+"\";";

        Statement statement;
        String[] profileDetails = new String[4];

        try {
            Connection connection = getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            if(resultSet.next()) {
                profileDetails[0] = resultSet.getString(3) +" "+resultSet.getString(4);
                profileDetails[1] = resultSet.getString(1);
                profileDetails[2] = resultSet.getString(5);
                profileDetails[3] = resultSet.getString(6);
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return profileDetails;

    }
}
