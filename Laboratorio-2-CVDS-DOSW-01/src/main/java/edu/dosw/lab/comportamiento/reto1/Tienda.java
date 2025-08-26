package edu.dosw.lab.comportamiento.reto1;
import java.util.*;

public class Tienda {
    private static Tienda instancia;
    private String nombre;
    private List<Producto> catalogo;
    private List<Cliente> clientes;

    private Tienda() {
        catalogo = new ArrayList<>();
        clientes = new ArrayList<>();

        /*
        catalogo.add(new Producto("Camiseta", 20000));
        catalogo.add(new Producto("Pantalón", 50000));
        catalogo.add(new Producto("Galletas", 500));
        catalogo.add(new Producto("Jugo Natural", 3000));
        */
    }

    public static Tienda getInstancia() {
        if (instancia == null) {
            instancia = new Tienda();
        }
        return instancia;
    }

    public void añadirProductos(String nombre, int precio) {
        Producto nuevoProducto = new Producto(nombre, precio);
        catalogo.add(nuevoProducto);
    }
    public void añadirCliente(String cliente) {
        //Cliente nuevoCliente = new Cliente(cliente);
        //clientes.add(nuevoCliente);
    }
}

