package edu.dosw.lab.creacionales.reto1;
import java.util.*;

public class Tienda {
    private String nombre;
    
    private List<Producto> productos;
    private List<Cliente> clientes;

    public void añadirProductos(String nombre, int precio) {
        Producto nuevoProducto = new Producto(nombre, precio);
        productos.add(nuevoProducto);
    }
    public void añadirCliente(String cliente) {
        //Cliente nuevoCliente = new Cliente(cliente);
        //clientes.add(nuevoCliente);
    }
}

