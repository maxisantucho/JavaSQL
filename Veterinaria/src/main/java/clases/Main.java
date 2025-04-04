package clases;

import clases.controller.ConnectionController;
import clases.controller.PacienteController;
import clases.controller.TratamientoController;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        ConnectionController controller = new ConnectionController();
        TratamientoController tc = new TratamientoController();
        String url = controller.URL;
        Properties props = controller.props;

        try(Connection c = controller.getConnection(url, props)) {

            tc.mostrarTratamientos(c);

        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }

    }
}