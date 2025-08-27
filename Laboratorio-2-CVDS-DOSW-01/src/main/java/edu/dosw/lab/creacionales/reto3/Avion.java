package edu.dosw.lab.creacionales.reto3;

public class Avion extends Vehiculo {

    public Avion(double precio, double velocidad, String descripcion) {
        super(precio, velocidad, descripcion);
    }

    @Override
    public String toString() {
        return "Avion{" +
                "precio=" + getPrecio() +
                ", velocidad=" + getVelocidad() +
                ", descripcion='" + getDescripcion() + '\'' +
                '}';
    }

}
