package edu.dosw.lab.comportamiento.reto1;

public abstract class Cliente {
    private String nombre;
    private DiscountStrategy discountStrategy;
    public Cliente(String nombre, DiscountStrategy discountStrategy) {
        this.nombre = nombre;
        this.discountStrategy = discountStrategy;
    }

    public double aplicarDescuento(double precio) {
        return discountStrategy.calcularDescuento(precio);
    }
}
