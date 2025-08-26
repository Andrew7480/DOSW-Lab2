public class Ticket {
    private String descripcion;
    private int nivel;      // nivel de dificultad
    private int prioridad;  // prioridad del ticket

    public Ticket(String descripcion, int nivel, int prioridad) {
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPrioridad() {
        return prioridad;
    }
}