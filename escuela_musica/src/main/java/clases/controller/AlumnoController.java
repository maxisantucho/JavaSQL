package clases.controller;

import clases.entity.Alumno;

import java.sql.*;
import java.util.Date;

public class AlumnoController {

    public void mostrarAlumnos(Connection c) {
        String query = "SELECT * FROM alumnos;";
        try(Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(query)) {
            while(rs.next()) {
                int id = rs.getInt("id_alumno");
                String apellido = rs.getString("apellido");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String email = rs.getString("email");
                Date fecha_nac = rs.getDate("fecha_nac");
                String telefono = rs.getString("telefono");
                System.out.println(id + " | " + apellido + " | " + nombre + " | "
                    + direccion + " | " + email + " | " + fecha_nac + " | " + telefono);
            }
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void mostrarAlumnoPorId(Connection c, int id) {
        String query = "SELECT * FROM alumnos WHERE id_alumno = ?";
        try(PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    String apellido = rs.getString("apellido");
                    String nombre = rs.getString("nombre");
                    String direccion = rs.getString("direccion");
                    String email = rs.getString("email");
                    Date fecha_nac = rs.getDate("fecha_nac");
                    String telefono = rs.getString("telefono");
                    System.out.println(id + " | " + apellido + " | " + nombre + " | "
                            + direccion + " | " + email + " | " + fecha_nac + " | " + telefono);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void insertarAlumno(Connection c, Alumno a) {
        String query = "INSERT INTO alumnos (apellido, nombre, direccion, email, fecha_nac, telefono) " +
                " VALUES(?, ?, ?, ?, ?, ?);";
        try(PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, a.getApellido());
            ps.setString(2, a.getNombre());
            ps.setString(3, a.getDireccion());
            ps.setString(4, a.getEmail());
            ps.setString(5, a.getFecha_nac());
            ps.setString(6, a.getTelefono());
            int filaAfectada = ps.executeUpdate();
            if(filaAfectada == 0) {
                throw new SQLException("No se pudo insertar alumno " + a.getApellido() + " " + a.getNombre());
            }
            System.out.println("El alumno " + a.getApellido() + " " + a.getNombre() + " a sido insertado correctamente");
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void modificarAlumno(Connection c, Alumno a, int id) {
        String query = "UPDATE alumnos SET apellido = ?, nombre = ?, direccion = ?, "
                + "email = ?, fecha_nac = ?, telefono = ? "
                + "WHERE id_alumno = ?;";
        try(PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, a.getApellido());
            ps.setString(2, a.getNombre());
            ps.setString(3, a.getDireccion());
            ps.setString(4, a.getEmail());
            ps.setString(5, a.getFecha_nac());
            ps.setString(6, a.getTelefono());
            ps.setInt(7, id);
            int filaAfectada = ps.executeUpdate();
            if(filaAfectada == 0) {
                throw new SQLException("No se pudo modificar alumno " + a.getApellido() + " " + a.getNombre());
            }
            System.out.println("El alumno " + a.getApellido() + " " + a.getNombre() + " fue modificado correctamente");
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void eliminarAlumno(Connection c, int id) {
        String query = "DELETE FROM alumnos WHERE id_alumno = ?;";
        try(PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            int filaAfectada = ps.executeUpdate();
            if(filaAfectada == 0) {
                throw new SQLException("No se pudo eliminar alumno con id " + id);
            }
            System.out.println("El alumno con id " + id + " a sido eliminado correctamente");
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

}
