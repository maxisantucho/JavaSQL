package clases.controller;

import clases.entity.Inscripcion;

import java.sql.*;
import java.util.Date;

public class InscripcionController {

    public void mostrarInscripciones(Connection c) {
        String query = "SELECT * FROM inscripciones;";
        try(Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(query)) {
            while(rs.next()) {
                int id = rs.getInt("id_inscripcion");
                Date fechaInsc = rs.getDate("fecha_insc");
                boolean abonoInsc = rs.getBoolean("abono_insc");
                int idAlumno = rs.getInt("id_alumno");
                int idCurso = rs.getInt("id_curso");
                System.out.println(id + " | " + fechaInsc + " | "
                    + abonoInsc + " | " + idAlumno + " | " + idCurso);
            }
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void mostrarInscripcionPorId(Connection c, int id) {
        String query = "SELECT * FROM inscripciones WHERE id_inscripcion = ?;";
        try(PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    Date fechaInsc = rs.getDate("fecha_insc");
                    boolean abonoInsc = rs.getBoolean("abono_insc");
                    int idAlumno = rs.getInt("id_alumno");
                    int idCurso = rs.getInt("id_curso");
                    System.out.println(id + " | " + fechaInsc + " | "
                            + abonoInsc + " | " + idAlumno + " | " + idCurso);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void insertarInscripcion(Connection c, Inscripcion inscripcion) {
        String query = "INSERT INTO inscripciones(fecha_insc, abono_insc, id_alumno, id_curso) "
                + " VALUES(?, ?, ?, ?);";
        try(PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, inscripcion.getFechaInsc());
            ps.setBoolean(2, inscripcion.isAbonoInsc());
            ps.setInt(3, inscripcion.getIdAlumno());
            ps.setInt(4, inscripcion.getIdCurso());
            int filaAfectada = ps.executeUpdate();
            if(filaAfectada == 0) {
                throw new SQLException("No se pudo realizar la inscripcion del dia " + inscripcion.getFechaInsc());
            }
            System.out.println("La inscripcion del dia " + inscripcion.getFechaInsc() + " ha sido insertada correctamente");
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void modificarInscripcion(Connection c, String fechaInsc, int id) {
        String query = "UPDATE inscripciones SET fecha_insc = ? WHERE id_inscripcion = ?;";
        try(PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, fechaInsc);
            ps.setInt(2, id);
            int filaAfectada = ps.executeUpdate();
            if(filaAfectada == 0) {
                throw new SQLException("No se pudo modificar la inscripcion del dia " + fechaInsc);
            }
            System.out.println("La inscripcion del dia " + fechaInsc + " se modifico con exito");
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void eliminarInscripcion(Connection c, int id) {
        String query = "DELETE FROM inscripciones WHERE id_inscripciones = ?;";
        try(PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            int filaAfectada = ps.executeUpdate();
            if(filaAfectada == 0) {
                throw new SQLException("No se pudo eliminar la inscripcion con id " + id);
            }
            System.out.println("La inscripcion con id " + id + " fue eliminada correctamente");
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

}
