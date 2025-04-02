package clases;

import java.sql.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        ControllerConnection controller = new ControllerConnection();
        ControllerInscripciones controllerInscripciones = new ControllerInscripciones();
        String URL = controller.URL;
        Properties props = controller.props;

        try (Connection c = controller.getConnection(URL, props)) {

            controllerInscripciones.mostrarListaInscripciones(c);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

    }

}