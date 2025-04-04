package clases.entity;

import java.util.Date;

public class Paciente {

    private String nombre;
    private String fechaNacimiento;
    private String especie;

    public Paciente(String nombre, String fechaNacimiento, String especie) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEspecie() {
        return especie;
    }
}
