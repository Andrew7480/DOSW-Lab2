package edu.dosw.lab.creacionales.reto3;

public abstract class Vehiculo implements MedioTransporte {
    private double precio;
    private double velocidad;
    private String descripcion;

    public Vehiculo(double precio, double velocidad, String descripcion) {
        this.precio = precio;
        this.velocidad = velocidad;
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

}