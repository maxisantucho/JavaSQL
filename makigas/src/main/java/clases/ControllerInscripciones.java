package clases;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ControllerInscripciones {

    private Scanner sc = new Scanner(System.in);

    public void mostrarListaInscripciones(Connection c) {
        String query = "SELECT * FROM inscripciones;";
        try(Statement st = c.createStatement()) {
            try(ResultSet rs = st.executeQuery(query)) {
                while(rs.next()) {
                    int id = rs.getInt(1);
                    Date fecha_insc = rs.getDate(2);
                    boolean abono_insc = rs.getBoolean(3);
                    int fk_cat = rs.getInt(4);
                    int fk_part = rs.getInt(5);
                    System.out.println(id + " | " + fecha_insc + " | "
                            + abono_insc + " | " + fk_cat + " | " + fk_part);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void insertarInscripcion(Connection c) {
        String query = "INSERT INTO inscripciones (fecha_inscripcion, abono_insc, fk_categoria, fk_participante) "
                + "VALUES(?, ?, ?, ?);";
        try(PreparedStatement ps = c.prepareStatement(query)) {
            System.out.print("Fecha de inscripcion: ");
            String fecha = sc.nextLine();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
            Date fecha_insc = (Date) formato.parse(fecha);
            ps.setDate(1, fecha_insc);
            System.out.print("Abono de inscripcion: ");
            boolean abono = Boolean.parseBoolean(sc.nextLine());
            ps.setBoolean(2, abono);
            System.out.print("ID categoria: ");
            int categoria = Integer.parseInt(sc.nextLine());
            ps.setInt(3, categoria);
            System.out.print("ID participante: ");
            int participante = Integer.parseInt(sc.nextLine());
            ps.setInt(4, participante);
            int filaAfectada = ps.executeUpdate();
            if(filaAfectada == 0) {
                throw new SQLException("No se pudo insertar la inscripcion del dia " + fecha_insc);
            }
            System.out.println("La inscripcion del dia " + fecha_insc + " fue ingresada correctamente");
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void modificarInscripcion(Connection c,int id, boolean abono, int participante, int categoria) {
        String query = "UPDATE inscripciones SET abono_insc = ?, fk_participante = ?, fk_categoria = ? "
                + "WHERE num_inscripcion = ?;";
        try(PreparedStatement ps = c.prepareStatement(query)) {
            ps.setBoolean(1, abono);
            ps.setInt(2, participante);
            ps.setInt(3, categoria);
            ps.setInt(4, id);
            int filaAfectada = ps.executeUpdate();
            if(filaAfectada == 0) {
                throw new SQLException("No se pudo modificar inscripcion con id " + id);
            }
            System.out.println("La inscripcion con id " + id + " fue modificada correctamente");
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void eliminarInscripcion(Connection c, int id) {
        String query = "DELETE FROM inscripciones WHERE num_inscripcion = ?;";
        try(PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            int filaAfectada = ps.executeUpdate();
            if(filaAfectada == 0) {
                throw new SQLException("No se pudo eliminar inscripcion con id " + id);
            }
            System.out.println("La inscripcion con id " + id + " fue eliminada correctamente");
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

}
