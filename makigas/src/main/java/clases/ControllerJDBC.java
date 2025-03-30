package clases;

import java.sql.*;
import java.util.Properties;

public class ControllerJDBC {

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

    public void mostrarLista(Connection conn) {
        String query = "SELECT * FROM participantes;";
        try(Statement st = conn.createStatement()) {
            try(ResultSet rs = st.executeQuery(query)) {
                while(rs.next()) {
                    int id_participante = rs.getInt(1);
                    String apellido = rs.getString(3);
                    String nombre = rs.getString(4);
                    String direccion = rs.getString(5);
                    int edad = rs.getInt(6);
                    String telefono = rs.getString(7);
                    String sexo = rs.getString(8);
                    System.out.println(id_participante +
                            " | " + apellido + " | " + nombre + " | " + direccion + " | " +
                            edad + " | " + telefono + " | " + sexo);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void insert(Connection conn) {
        String query = "";
        try(PreparedStatement ps = conn.prepareStatement(query)) {
            
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

}
