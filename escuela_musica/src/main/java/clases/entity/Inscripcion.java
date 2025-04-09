package clases.entity;

public class Inscripcion {

    private String fechaInsc;
    private boolean abonoInsc;
    private int idAlumno;
    private int idCurso;

    public Inscripcion(String fechaInsc, boolean abonoInsc, int idAlumno, int idCurso) {
        this.fechaInsc = fechaInsc;
        this.abonoInsc = abonoInsc;
        this.idAlumno = idAlumno;
        this.idCurso = idCurso;
    }

    public String getFechaInsc() {
        return fechaInsc;
    }

    public boolean isAbonoInsc() {
        return abonoInsc;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public int getIdCurso() {
        return idCurso;
    }
}
