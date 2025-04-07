package clases.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ControllerConnection {

    String DATA_BASE = "escuela_musica";
    String URL = "jdbc:mysql://localhost:3307/" + DATA_BASE;
    Properties props = getPropertiesDataBase();

    public Properties getPropertiesDataBase() {
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "");
        return props;
    }

    public Connection getConnection() {
        Connection c = null;
        Properties p = getPropertiesDataBase();
        try {
            c = DriverManager.getConnection(URL, p);
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
        return c;
    }
}
