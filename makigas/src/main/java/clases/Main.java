package clases;

import java.sql.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        ControllerConnection controller = new ControllerConnection();
        ControllerParticipantes cParticipante = new ControllerParticipantes();
        String URL = controller.URL;
        Properties props = controller.props;

        try (Connection c = controller.getConnection(URL, props)) {

            //cParticipante.mostrarListaParticipantes(c);
            //cParticipante.insertarParticipante(c);
            //cParticipante.modificarParticipante(c, "98102345", "Manuel", "Adorni");
            //cParticipante.eliminarParticipante(c, 16);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

    }

}