package clases;

import clases.controller.ConnectionController;
import clases.controller.PacienteController;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        ConnectionController controller = new ConnectionController();
        PacienteController pc = new PacienteController();
        String url = controller.URL;
        Properties props = controller.props;

        try(Connection c = controller.getConnection(url, props)) {

            pc.mostrarListaPacientes(c);

        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }

    }
}