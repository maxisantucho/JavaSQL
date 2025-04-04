package clases.controller;

import java.sql.*;
import java.util.Properties;

public class ConnectionController {

    String DATA_BASE = "veterinaria";
    public String URL = "jdbc:mysql://localhost:3307/" + DATA_BASE;
    public Properties props = getPropertiesDataBase();

    public Properties getPropertiesDataBase() {
        Properties p = new Properties();
        p.setProperty("user", "root");
        p.setProperty("password", "");
        return p;
    }

    public Connection getConnection(String url, Properties props) {
        Connection c = null;
        try {
            c = DriverManager.getConnection(url, props);
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
        return c;
    }

}
