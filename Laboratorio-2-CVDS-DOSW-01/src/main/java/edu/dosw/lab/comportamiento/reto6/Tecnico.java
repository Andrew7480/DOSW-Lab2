package edu.dosw.lab.comportamiento.reto6;
public abstract class Tecnico {
    protected Tecnico siguiente;

    public void setSiguiente(Tecnico siguiente){
        this.siguiente = siguiente;
    }

    public abstract void resolver(Ticket ticket);

}