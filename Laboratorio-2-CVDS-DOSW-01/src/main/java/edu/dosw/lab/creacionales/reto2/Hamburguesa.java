package edu.dosw.lab.creacionales.reto2;
import java.util.*;

public class Hamburguesa {
    private List<Ingrediente> ingredientes;
    private double precioTotal;

    public Hamburguesa(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
        this.precioTotal = ingredientes.stream()
                .mapToDouble(Ingrediente::getPrecio)
                .sum();
    }

    public void mostrar() {
        System.out.println("Hamburguesa con: ");
        ingredientes.forEach(i -> System.out.println(" - " + i));
        System.out.println("Precio total: $" + precioTotal);
    }
}