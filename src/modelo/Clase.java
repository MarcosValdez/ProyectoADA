package modelo;

public class Clase {
    private Clase siguiente;
    private String codigoClase;
    private String nivel; // Basico, Intermedio, Avanzado
    private String subnivel; // (1-10), (1-10), (1-6)
    private String frecuencia; // Regular (Sabado), Intensivo (Martes y Jueves)
    private String horario; // Ej: 7:00-8:30
    private String salon; // Ej: 101

    
    
    public Clase(String codigoClase, String nivel, String subnivel, String frecuencia, String horario, String salon) {
        this.siguiente = null;
        this.codigoClase = codigoClase;
        this.nivel = nivel;
        this.subnivel = subnivel;
        this.frecuencia = frecuencia;
        this.horario = horario;
        this.salon = salon;
    }
    
    public Clase() {
    }
    
    public String toString() {
        return codigoClase + "_" + nivel + "_" + subnivel + "_" +
                frecuencia + "_" + horario + "_" + salon;
    }
    
    public String getCodigoClase() {
        return codigoClase;
    }

    public void setCodigoClase(String codigoClase) {
        this.codigoClase = codigoClase;
    }
    
    public Clase getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Clase siguiente) {
        this.siguiente = siguiente;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getSubnivel() {
        return subnivel;
    }

    public void setSubnivel(String subnivel) {
        this.subnivel = subnivel;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }
}
