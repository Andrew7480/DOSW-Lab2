package edu.dosw.lab.comportamiento.reto1;

import java.util.*;

public class Cliente {
    private DiscountStrategy discountStrategy;
    private CarritoCompras carrito;

    public Cliente(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
        carrito = new CarritoCompras();
    }

    private double aplicarDescuento(int precio) {
        return discountStrategy.calcularDescuento(precio);
    }
    public void comprarArticulo(Producto producto){
        carrito.añadirProducto(producto);
    }

    public int getTotalCarrito() {
        return carrito.getTotal();
    }
    public int getTotalConDescuento() {
        int total = getTotalCarrito();
        return total - (int)aplicarDescuento(total);
    }
    public int getDescuento(){
        return (int)aplicarDescuento(getTotalCarrito());
    }
    public List<Producto> getProductos() {
        return carrito.getProductos();
    }
}
