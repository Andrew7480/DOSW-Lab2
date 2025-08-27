package edu.dosw.lab.creacionales.reto3;

public class Lancha extends Vehiculo {

    public Lancha(double precio, double velocidad, String descripcion) {
        super(precio, velocidad, descripcion);
    }

    @Override
    public String toString() {
        return "Lancha{" +
                "precio=" + getPrecio() +
                ", velocidad=" + getVelocidad() +
                ", descripcion='" + getDescripcion() + '\'' +
                '}';
    }

}
