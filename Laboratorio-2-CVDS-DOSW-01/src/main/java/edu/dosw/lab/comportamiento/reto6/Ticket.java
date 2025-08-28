package edu.dosw.lab.comportamiento.reto6;

public class Ticket{
    private int id;
    private Nivel nivel;
    private Prioridad prioridad;
    private String descripcion;
    private boolean resuelto;

    public Ticket(int id, Nivel nivel, Prioridad prioridad, String descripcion) {
        this.id = id;
        this.nivel = nivel;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
        this.resuelto = false;
    }
    
    public int getId() { return id; }
    public Nivel getNivel() { return nivel; }
    public Prioridad getPrioridad() { return prioridad; }
    public String getDescripcion() { return descripcion; }
    public boolean isResuelto() { return resuelto; }
    public void setResuelto(boolean resuelto) { this.resuelto = resuelto; }
}