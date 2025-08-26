package edu.dosw.lab.comportamiento.reto1;
import java.io.*;
import java.util.*;

public class Tienda {
    private static Tienda instancia;
    private String nombre;
    private List<Producto> catalogo;
    private List<Cliente> clientes;

    private Tienda() {
        nombre = "Tienda de Don Pepe";
        catalogo = new ArrayList<>();
        clientes = new ArrayList<>();

        catalogo.add(new Producto("Camiseta", 20000));
        catalogo.add(new Producto("Pantalón", 50000));
        catalogo.add(new Producto("Galletas", 500));
        catalogo.add(new Producto("Jugo Natural", 3000));
    }

    public static Tienda getInstancia() {
        if (instancia == null) {
            instancia = new Tienda();
        }
        return instancia;
    }

    private void añadirProductos(String nombre, int precio) {
        Producto nuevoProducto = new Producto(nombre, precio);
        catalogo.add(nuevoProducto);
    }
    private Cliente añadirNuevoCliente() {
        Cliente nuevoCliente = new Cliente(new DescuentoNuevo());
        clientes.add(nuevoCliente);
        return nuevoCliente;
    }
    private Cliente añadirClienteFrecuente(){
        Cliente nuevoCliente = new Cliente(new DescuentoFrecuente());
        clientes.add(nuevoCliente);
        return nuevoCliente;
    }

    private void printCatalogo() {
        System.out.println("Productos disponibles: ");
        for (Producto p : catalogo) {
            System.out.println("- " + p.getNombre() + ": $" + p.getPrecio());
        }
    }

    private void procesarPago(Cliente cliente) {
        int subTotal = cliente.getTotalCarrito();
        int descuento = cliente.getDescuento();
        Recibo recibo = new Recibo("", cliente.getProductos(), subTotal, descuento);
        recibo.imprimirRecibo();
    }

    private Cliente tipoCliente() {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = null;
        while (cliente == null) {
            System.out.println("Seleccione el tipo de cliente:");
            System.out.println("1. Nuevo");
            System.out.println("2. Frecuente");
            System.out.print("Ingrese una opción: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    cliente = añadirNuevoCliente();
                    break;
                case "2":
                    cliente = añadirClienteFrecuente();
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        return cliente;
    }
    
    private Producto buscarProducto(String nombre) {
        return catalogo.stream()
            .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
            .findFirst()
            .orElse(null);
    }

    private void compraCliente(Cliente cliente) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Ingrese su compra:");
            String nombreProducto = scanner.nextLine();
            if (nombreProducto.isEmpty()) {
                break;
            }
            Producto producto = buscarProducto(nombreProducto);
            if (producto != null) {
                int cantidad = 0;
                while (cantidad <= 0) {
                    System.out.print("Cantidad: ");
                    try {
                        cantidad = Integer.parseInt(scanner.nextLine());
                        if (cantidad <= 0) {
                            System.out.println("Por favor, ingrese una cantidad válida (mayor a 0).");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Por favor, ingrese un número válido.");
                    }
                }
                for (int i = 0; i < cantidad; i++) {
                    cliente.comprarArticulo(producto);
                }
                System.out.println("Producto añadido al carrito.");
            } else {
                System.out.println("Producto no encontrado.");
            }
        }
        
    }

    public void inicializar(){
        System.out.println("Bienvenido a la tienda  " + nombre);
        Cliente cliente = tipoCliente();
        printCatalogo();
        compraCliente(cliente);
        procesarPago(cliente);
    }
}

