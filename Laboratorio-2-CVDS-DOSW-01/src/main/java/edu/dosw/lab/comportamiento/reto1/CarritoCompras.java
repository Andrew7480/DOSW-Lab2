package edu.dosw.lab.comportamiento.reto1;

import java.util.*;

public class CarritoCompras {
    private List<Producto> productos;

    public CarritoCompras() {
        productos = new ArrayList<>();
    }

    public void añadirProducto(Producto p) {
        productos.add(p);
    }

    public int getTotal() {
        return productos.stream().mapToInt(Producto::getPrecio).sum();
    }
    public List<Producto> getProductos() {
        return productos;
    }
}
