package clases;

import clases.controller.AlumnoController;
import clases.controller.ControllerConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        ControllerConnection cc = new ControllerConnection();
        AlumnoController ac = new AlumnoController();

        try(Connection c = cc.getConnection();){

            ac.mostrarAlumnoPorId(c, 5);

        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }

    }

}