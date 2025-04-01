package clases;

import java.sql.*;
import java.util.Scanner;

public class ControllerCategorias {

    private Scanner sc = new Scanner(System.in);

    public void mostrarListaCategorias(Connection c) {
        String query = "SELECT * FROM categorias;";
        try(Statement st = c.createStatement()) {
            try(ResultSet rs = st.executeQuery(query)) {
                while(rs.next()) {
                    int id_categoria = rs.getInt(1);
                    String nombre = rs.getString(2);
                    int edad_min = rs.getInt(3);
                    int edad_max = rs.getInt(4);
                    String sexo = rs.getString(5);
                    System.out.println(id_categoria + " | "
                            + nombre + " | " + edad_min + " | "
                            + edad_max + " | " + sexo);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void insertarCategoria(Connection c) {
        String query = "INSERT INTO categorias (nombre, edad_min, edad_max, sexo) "
                + "VALUES (?, ?, ?, ?);";
        try(PreparedStatement ps = c.prepareStatement(query)) {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            ps.setString(1, nombre);
            System.out.print("Edad minima: ");
            int edad_min = Integer.parseInt(sc.nextLine());
            ps.setInt(2, edad_min);
            System.out.print("Edad maxima: ");
            int edad_max = Integer.parseInt(sc.nextLine());
            ps.setInt(3, edad_max);
            System.out.print("Sexo: ");
            String sexo = sc.nextLine();
            ps.setString(4, sexo);
            int filaAfectada = ps.executeUpdate();
            if(filaAfectada == 0) {
                throw new SQLException("No se pudo ingresar la categoria " + nombre);
            }
            System.out.println("La categoria " + nombre + " fue ingresada correctamente");
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void modificarCategoria(Connection c, String nombre, String sexo, int id) {
        String query = "UPDATE categorias SET nombre = ?, sexo = ? WHERE id_categoria = ?";
        try(PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, nombre);
            ps.setString(2, sexo);
            ps.setInt(3, id);
            int filaAfectada = ps.executeUpdate();
            if(filaAfectada == 0) {
                throw new SQLException("La categoria con id " + id + " no pudo ser modificada");
            }
            System.out.println("La categoria con id " + id + " fue modifica correctamente");
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void eliminarCategoria(Connection c, int id) {
        String query = "DELETE FROM categorias WHERE id_categoria = ?;";
        try(PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            int filaAfectada = ps.executeUpdate();
            if(filaAfectada == 0) {
                throw new SQLException("No se pudo eliminar la categoria con id " + id);
            }
            System.out.println("La categoria con id " + id + " fue eliminada correctamente");
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

}
