package edu.dosw.lab.comportamiento.reto1;

public class Producto {
    private String nombre;
    private final int precio;

    public Producto(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }
}
