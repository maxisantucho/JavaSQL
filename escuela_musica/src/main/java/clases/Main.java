package clases;

import clases.controller.AlumnoController;
import clases.controller.ControllerConnection;
import clases.controller.CursoController;
import clases.controller.InscripcionController;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        ControllerConnection cc = new ControllerConnection();
        InscripcionController ic = new InscripcionController();

        try(Connection c = cc.getConnection();){

            ic.mostrarInscripcionPorId(c, 2);

        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }

    }

}