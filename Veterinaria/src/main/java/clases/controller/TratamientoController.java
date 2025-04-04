package clases.controller;

import clases.entity.Tratamiento;

import java.sql.*;
import java.util.Date;

public class TratamientoController {

    public void mostrarTratamientos(Connection c) {
        String query = "SELECT * FROM tratamientos;";
        try(Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(query)) {
            while(rs.next()) {
                int id_tratamiento = rs.getInt("id_tratamiento");
                int id_paciente = rs.getInt("id_paciente");
                String tipo_tratamiento = rs.getString("tipo_tratamiento");
                Date fecha_tratamiento = rs.getDate("fecha_tratamiento");
                System.out.println(id_tratamiento + " | " + id_paciente
                    + " | "  + tipo_tratamiento + " | " + fecha_tratamiento);
            }
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void insertarTratamiento(Connection c, Tratamiento tratamiento) {
        String query = "INSERT INTO tratamientos (id_paciente, tipo_tratamiento, fecha_tratamiento) " +
                "VALUES (?, ?, ?);";
        try(PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, tratamiento.getId_paciente());
            ps.setString(2, tratamiento.getTipo_tratamiento());
            ps.setString(3, tratamiento.getFecha_tratamiento());
            int filaAfectada = ps.executeUpdate();
            if(filaAfectada == 0) {
                throw new SQLException("No se pudo insertar paciente ocn id " + tratamiento.getId_paciente());
            }
            System.out.println("El paciente con id " + tratamiento.getFecha_tratamiento() + " se inserto correctamente");
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

}
