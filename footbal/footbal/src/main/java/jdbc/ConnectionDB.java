package jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {

    private static String url = "";
    private static String username = "";
    private static String password = "";
    private static String jdbcDriver = "";
    private static ConnectionDB jdbc;
    private static Connection connection = null;

    ConnectionDB() {
        try {
            InputStream inputStream = ConnectionDB.class.getClassLoader().getResourceAsStream("application.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            url = properties.getProperty("db.url");
            password = properties.getProperty("db.password");
            username = properties.getProperty("db.username");
            jdbcDriver = properties.getProperty("db.jdbc-driver");
            Class.forName(jdbcDriver);
           connection = DriverManager.getConnection(url, username, password);
        }catch (ClassNotFoundException | IOException | SQLException e ){
            e.printStackTrace();
        }
    }

    public static ConnectionDB getInstance(){

        if (jdbc==null)
        {
            jdbc=new ConnectionDB();
        }
        return jdbc;
    }


    public static Connection getConnection(){
        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }



}

