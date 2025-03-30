package clases;

import java.sql.*;
import java.util.Scanner;

public class ControllerParticipantes {

    private Scanner sc = new Scanner(System.in);

    public void mostrarListaParticipantes(Connection conn) {
        String query = "SELECT * FROM participantes;";
        try(Statement st = conn.createStatement()) {
            try(ResultSet rs = st.executeQuery(query)) {
                while(rs.next()) {
                    int id_participante = rs.getInt(1);
                    String apellido = rs.getString(3);
                    String nombre = rs.getString(4);
                    String direccion = rs.getString(5);
                    int edad = rs.getInt(6);
                    String telefono = rs.getString(7);
                    String sexo = rs.getString(8);
                    System.out.println(id_participante +
                            " | " + apellido + " | " + nombre + " | " + direccion + " | " +
                            edad + " | " + telefono + " | " + sexo);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void insertarParticipante(Connection conn) {
        String query = "INSERT INTO participantes " +
                "(dni_participante, apellido, nombre, direccion, edad, telefono, sexo) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";
        try(PreparedStatement ps = conn.prepareStatement(query)) {
            System.out.print("DNI participante: ");
            String dni = sc.nextLine();
            ps.setString(1, dni);
            System.out.print("Apellido: ");
            String apellido = sc.nextLine();
            ps.setString(2, apellido);
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            ps.setString(3, nombre);
            System.out.print("Direccion: ");
            String direccion = sc.nextLine();
            ps.setString(4, direccion);
            System.out.print("Edad: ");
            int edad = Integer.parseInt(sc.nextLine());
            ps.setInt(5, edad);
            System.out.print("Telefono: ");
            String telefono = sc.nextLine();
            ps.setString(6, telefono);
            System.out.print("Sexo: ");
            String sexo = sc.nextLine();
            ps.setString(7, sexo);
            int filaAfectada = ps.executeUpdate();
            if (filaAfectada == 0) {
                throw new SQLException("No se pudo ingresar el participante: " + nombre + " " + apellido);
            }
            System.out.println(
                    "El participante " + nombre + " " + apellido + " fue insertado correctamente");
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void modificarParticipante(Connection c, String dniParticipante, String nombreParticipante, String apellidoParticipante) {
        String query = "UPDATE participantes SET apellido = ?, nombre = ? WHERE dni_participante = ?;";
        try(PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, apellidoParticipante);
            ps.setString(2, nombreParticipante);
            ps.setString(3, dniParticipante);
            int filaAfectada = ps.executeUpdate();
            if (filaAfectada == 0) {
                throw new SQLException("No se pudo modificar el participante con dni: " + dniParticipante);
            }
            System.out.println(
                    "El participante con dni " + dniParticipante + " fue modificado correctamente");
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void eliminarParticipante(Connection c, int idParticipante) {
        String query = "DELETE FROM participantes WHERE id_participante = ?;";
        try(PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, idParticipante);
            int filaAfectada = ps.executeUpdate();
            if(filaAfectada == 0) {
                throw new SQLException("No se pudo eliminar el participante con id " + idParticipante);
            }
            System.out.println("El participante con id " + idParticipante + " fue eliminado correctamente");
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

}
