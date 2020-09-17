package modelo;

public class Alumno {
    
    public String dniAlumno;
    public String nombreAlumno;
    public String apellidoAlumno;
    public int edadAlumno;

    public Alumno siguiente;

    public Alumno(String dniAlumno,String nombreAlumno, String apellidoAlumno, int edadAlumno) {
        this.nombreAlumno = nombreAlumno;
        this.apellidoAlumno = apellidoAlumno;
        this.dniAlumno = dniAlumno;
        this.edadAlumno = edadAlumno;
        this.siguiente = null;
    }
    
    public Alumno() {
    }

    Alumno(Alumno a) {
        this.nombreAlumno = a.nombreAlumno;
        this.apellidoAlumno = a.apellidoAlumno;
        this.dniAlumno = a.dniAlumno;
        this.edadAlumno = a.edadAlumno;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        return   dniAlumno+" "+ nombreAlumno + " " + apellidoAlumno  + " " + edadAlumno;
    }
}
