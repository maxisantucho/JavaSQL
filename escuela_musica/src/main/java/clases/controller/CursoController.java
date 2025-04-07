package clases.controller;

import clases.entity.Curso;

import java.sql.*;

public class CursoController {

    public void mostrarCursos(Connection c) {
        String query = "SELECT * FROM cursos;";
        try(Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(query)) {
            while(rs.next()) {
                int id_curso = rs.getInt("id_curso");
                String nombre = rs.getString("nombre");
                String nivel_habilidad = rs.getString("nivel_habilidad");
                String tipo_instrumento = rs.getString("tipo_instrumento");
                System.out.println(id_curso + " | " + nombre + " | "
                        + nivel_habilidad + " | " + tipo_instrumento);
            }
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void mostrarCursoPorId(Connection c, int id) {
        String query = "SELECT * FROM cursos WHERE id_curso = ?;";
        try(PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    String nombre = rs.getString("nombre");
                    String nivel_habilidad = rs.getString("nivel_habilidad");
                    String tipo_instrumento = rs.getString("tipo_instrumento");
                    System.out.println(id + " | " + nombre + " | "
                            + nivel_habilidad + " | " + tipo_instrumento);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void insertarCurso(Connection c, Curso curso) {
        String query = "INSERT INTO cursos(nombre, nivel_habilidad, tipo_instrumento) "
                + " VALUES(?, ?, ?);";
        try(PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, curso.getNombre());
            ps.setString(2, curso.getNivel_habilidad());
            ps.setString(3, curso.getTipo_instrumento());
            int filaAfectada = ps.executeUpdate();
            if(filaAfectada == 0) {
                throw new SQLException("No se pudo insertar curso " + curso.getNombre());
            }
            System.out.println("El curso " + curso.getNombre() + " fue insertado correctamente");
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void modificarCurso(Connection c, Curso curso, int id) {
        String query = "UPDATE cursos SET nombre = ?, nivel_habilidad = ?, tipo_instrumento = ? "
                + " WHERE id_curso = ?;";
        try(PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, curso.getNombre());
            ps.setString(2, curso.getNivel_habilidad());
            ps.setString(3, curso.getTipo_instrumento());
            ps.setInt(4, id);
            int filaAfectada = ps.executeUpdate();
            if(filaAfectada == 0) {
                throw new SQLException("No se pudo modificar curso " + curso.getNombre());
            }
            System.out.println("El curso " + curso.getNombre() + " ha sido modificado correctamente");
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void eliminarCurso(Connection c, int id) {
        String query = "DELETE FROM cursos WHERE id_curso = ?;";
        try(PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            int filaAfectada = ps.executeUpdate();
            if(filaAfectada == 0) {
                throw new SQLException("No se pudo eliminar curso con id " + id);
            }
            System.out.println("El curso con id " + id + " fue eliminado correctamente");
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }

}
