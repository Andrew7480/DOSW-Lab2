package edu.dosw.lab.creacionales.reto3;

public class Avioneta extends Vehiculo {

    public Avioneta(double precio, double velocidad, String descripcion) {
        super(precio, velocidad, descripcion);
    }

    @Override
    public String toString() {
        return "Avioneta{" +
                "precio=" + getPrecio() +
                ", velocidad=" + getVelocidad() +
                ", descripcion='" + getDescripcion() + '\'' +
                '}';
    }

}
