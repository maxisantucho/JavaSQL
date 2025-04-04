package clases.entity;

import java.util.Date;

public class Tratamiento {

    private int id_paciente;
    private String tipo_tratamiento;
    private String fecha_tratamiento;

    public Tratamiento(int id_paciente, String tipo_tratamiento, String fecha_tratamiento) {
        this.id_paciente = id_paciente;
        this.tipo_tratamiento = tipo_tratamiento;
        this.fecha_tratamiento = fecha_tratamiento;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public String getTipo_tratamiento() {
        return tipo_tratamiento;
    }

    public String getFecha_tratamiento() {
        return fecha_tratamiento;
    }
}
