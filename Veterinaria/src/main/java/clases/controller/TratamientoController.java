package clases.controller;

import clases.entity.Tratamiento;

import java.sql.*;
import java.util.Date;

public class TratamientoController {

    public void mostrarTratamientos(Connection c) {
        String query = "SELECT * FROM tratamientos;";
        try (Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                int id_tratamiento = rs.getInt("id_tratamiento");
                int id_paciente = rs.getInt("id_paciente");
                String tipo_tratamiento = rs.getString("tipo_tratamiento");
                Date fecha_tratamiento = rs.getDate("fecha_tratamiento");
                System.out.println(id_tratamiento + " | " + id_paciente
                        + " | " + tipo_tratamiento + " | " + fecha_tratamiento);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void mostrarTratamientosPorId(Connection c, int id) {
        String query = "SELECT * FROM tratamientos WHERE id_tratamiento = ?;";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
             try(ResultSet rs = ps.executeQuery()) {
                 while (rs.next()) {
                     int id_tratamiento = rs.getInt("id_tratamiento");
                     int id_paciente = rs.getInt("id_paciente");
                     String tipo_tratamiento = rs.getString("tipo_tratamiento");
                     Date fecha_tratamiento = rs.getDate("fecha_tratamiento");
                     System.out.println(id_tratamiento + " | " + id_paciente
                             + " | " + tipo_tratamiento + " | " + fecha_tratamiento);
                 }
             }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void insertarTratamiento(Connection c, Tratamiento tratamiento) {
        String query = "INSERT INTO tratamientos (id_paciente, tipo_tratamiento, fecha_tratamiento) " +
                "VALUES (?, ?, ?);";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, tratamiento.getId_paciente());
            ps.setString(2, tratamiento.getTipo_tratamiento());
            ps.setString(3, tratamiento.getFecha_tratamiento());
            int filaAfectada = ps.executeUpdate();
            if (filaAfectada == 0) {
                throw new SQLException("No se pudo insertar paciente ocn id " + tratamiento.getId_paciente());
            }
            System.out.println("El paciente con id " + tratamiento.getFecha_tratamiento() + " se inserto correctamente");
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void modificarTratamiento(Connection c, String fecha_tratamiento, int id) {
        String query = "UPDATE tratamientos SET fecha_tratamiento = ? WHERE id_tratamiento = ?;";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, fecha_tratamiento);
            ps.setInt(2, id);
            int filaAfectada = ps.executeUpdate();
            if (filaAfectada == 0) {
                throw new SQLException("No se pudo modificar tratamiento con id " + id);
            }
            System.out.println("El tratamiento con id " + id + " fue modificado correctamente");
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void eliminarTratamientoPorId(Connection c, int id) {
        String query = "DELETE FROM tratamientos WHERE id_tratamiento = ?;";
        try(PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            int filaAfectada = ps.executeUpdate();
            if(filaAfectada == 0) {
                throw new SQLException("No se pudo eliminar tratamiento con id " + id);
            }
            System.out.println("El tratamiento con id " + id + " fue eliminado correctamente");
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

}
