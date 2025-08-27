package edu.dosw.lab.creacionales.reto3;

public class Bicicleta extends Vehiculo {

    public Bicicleta(double precio, double velocidad, String descripcion) {
        super(precio, velocidad, descripcion);
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "precio=" + getPrecio() +
                ", velocidad=" + getVelocidad() +
                ", descripcion='" + getDescripcion() + '\'' +
                '}';
    }

}
