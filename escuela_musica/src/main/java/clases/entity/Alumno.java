package clases.entity;

import java.util.Date;

public class Alumno {

    private String apellido;
    private String nombre;
    private String direccion;
    private String email;
    private String fecha_nac;
    private String telefono;

    public Alumno(String apellido, String nombre, String direccion, String email, String fecha_nac, String telefono) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.fecha_nac = fecha_nac;
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public String getTelefono() {
        return telefono;
    }
}
