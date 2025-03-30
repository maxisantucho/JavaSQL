package clases;

import java.sql.*;
import java.util.Properties;

public class ControllerConnection {

    String DATA_BASE = "torneo_tenis";
    String URL = "jdbc:mysql://localhost:3307/" + DATA_BASE;
    Properties props = getPropertiesDataBase();

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
