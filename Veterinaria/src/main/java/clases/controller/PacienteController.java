package clases.controller;

import clases.entity.Paciente;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PacienteController {

    public void mostrarListaPacientes(Connection c) {
        String query = "SELECT * FROM pacientes;";
        try(Statement st = c.createStatement()) {
            try(ResultSet rs = st.executeQuery(query)) {
                while(rs.next()) {
                    int id_paciente = rs.getInt(1);
                    String nombre = rs.getString(2);
                    Date fecha_nacimineto = rs.getDate(3);
                    String especie = rs.getString(4);
                    System.out.println(id_paciente + " | " + nombre + " | "
                            + fecha_nacimineto + " | " + especie);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void insertarPaciente(Connection c, Paciente paciente) {
        String query = "INSERT INTO pacientes (nombre_paciente, fecha_nacimiento, especie) " +
                "VALUES(?, ?, ?);";
        try(PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getFechaNacimiento());
            ps.setString(3, paciente.getEspecie());
            int filaAfectada = ps.executeUpdate();
            if(filaAfectada == 0) {
                throw new SQLException("No se pudo insertar el paciente " + paciente.getNombre());
            }
            System.out.println("El paciente " + paciente.getNombre() + " ha sido insertado correctamente");
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void modificarPaciente(Connection c, int id, String nombre, String especie){
        String query = "UPDATE pacientes SET nombre_paciente = ?, especie = ? WHERE id_paciente = ?;";
        try(PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, nombre);
            ps.setString(2, especie);
            ps.setInt(3, id);
            int filaAfectada = ps.executeUpdate();
            if(filaAfectada == 0) {
                throw new SQLException("No se pudo modificar el paciente con id" + id);
            }
            System.out.println("El paciente con id" + id + " ha sido modificado correctamente");
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void eliminarPaciente(Connection c, int id) {
        String query = "DELETE FROM pacientes WHERE id_paciente = ?;";
        try(PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            int filaAfectada = ps.executeUpdate();
            if(filaAfectada == 0) {
                throw new SQLException("No se pudo eliminar paciente con id " + id);
            }
            System.out.println("El paciente con id " + id + " ha sido eliminado correctamente");
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

}
