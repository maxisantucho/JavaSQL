package clases;

import clases.controller.AlumnoController;
import clases.controller.ControllerConnection;
import clases.controller.CursoController;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        ControllerConnection cc = new ControllerConnection();
        CursoController cursoC = new CursoController();

        try(Connection c = cc.getConnection();){

            cursoC.mostrarCursoPorId(c, 3);

        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }

    }

}