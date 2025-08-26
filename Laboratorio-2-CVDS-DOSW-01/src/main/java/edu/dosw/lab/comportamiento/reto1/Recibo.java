package edu.dosw.lab.comportamiento.reto1;

import java.util.*;

public class Recibo {
    private String tipoCliente;
    private List<Producto> productos;
    private int subTotal;
    private int descuento;
    private int total;

    public Recibo(String tipoCliente, List<Producto> productos, int subTotal, int descuento) {
        this.tipoCliente = tipoCliente;
        this.productos = productos;
        this.subTotal = subTotal;
        this.descuento = descuento;
        this.total = subTotal - descuento;
    }

    public void imprimirRecibo() {
        System.out.println("----- RECIBO DE COMPRA -----");
        System.out.println("Cliente: " + tipoCliente);
        System.out.println("Productos comprados:");
        for (Producto p : productos) {
            System.out.println("- " + p.getNombre() + ": $" + p.getPrecio());
        }
        System.out.println("Subtotal: $" + subTotal);
        System.out.println("Descuento aplicado: $" + descuento);
        System.out.println("Total a pagar: $" + total);
        System.out.println("------------------");
        System.out.println("¡Gracias por su compra!");
    }
}
