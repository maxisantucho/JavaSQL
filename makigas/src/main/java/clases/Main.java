package clases;

import java.sql.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        ControllerJDBC controller = new ControllerJDBC();
        String URL = controller.URL;
        Properties props = controller.props;

        try (Connection c = controller.getConnection(URL, props)) {

            //controller.mostrarLista(c);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

    }

}