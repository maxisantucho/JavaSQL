package clases.entity;

public class Curso {

    String nombre;
    String nivel_habilidad;
    String tipo_instrumento;

    public Curso(String nombre, String nivel_habilidad, String tipo_instrumento) {
        this.nombre = nombre;
        this.nivel_habilidad = nivel_habilidad;
        this.tipo_instrumento = tipo_instrumento;
    }

    public String getNombre() { return nombre; }

    public String getNivel_habilidad() {
        return nivel_habilidad;
    }

    public String getTipo_instrumento() {
        return tipo_instrumento;
    }
}
