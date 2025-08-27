package edu.dosw.lab.creacionales.reto3;

public class Helicoptero extends Vehiculo {
    public Helicoptero(double precio, double velocidad, String descripcion) {
        super(precio, velocidad, descripcion);
    }

    @Override
    public String toString() {
        return "Helicoptero{" +
                "precio=" + getPrecio() +
                ", velocidad=" + getVelocidad() +
                ", descripcion='" + getDescripcion() + '\'' +
                '}';
    }
}
