package edu.dosw.lab.creacionales.reto2;

import java.util.*;

public class Chef {
    private HamburguesaBuilder builder;

    public Chef(HamburguesaBuilder builder) {
        this.builder = builder;
    }

    public void baseIngredientes(){
        builder.reset();
    }
    public void seleccionarIngredientes() {
        System.out.println("Seleccione ingredientes para su hamburguesa:");
        List<Ingrediente> ingredientes = builder.getIngredientesBase();
        for (int i = 0; i < ingredientes.size(); i++) {
            Ingrediente ing = ingredientes.get(i);
            
            System.out.printf("\u001B[31m%d.\u001B[0m %s ($%,.0f)%n", i + 1, ing.getNombre(), ing.getPrecio());// Números en rojo usando ANSI escape code (\u001B[31m para rojo, \u001B[0m para reset)
        }
        System.out.printf("\u001B[31m%d.\u001B[0m Agregar un nuevo ingrediente%n", ingredientes.size() + 1);

        System.out.print("Ingrese los números separados por coma: ");
        Scanner scanner = new Scanner(System.in);
        String[] seleccion = scanner.nextLine().split(",");

        for (String s : seleccion) {
            int opcion = Integer.parseInt(s.trim());
            if (opcion >= 1 && opcion <= ingredientes.size()) {
                builder.seleccionarIngrediente(ingredientes.get(opcion - 1));
            } else if (opcion == ingredientes.size() + 1) {
                System.out.print("\nIngrese el nombre del nuevo ingrediente: ");
                String nuevo = scanner.nextLine();
                System.out.print("Ingrese el precio del ingrediente: ");
                int precio = Integer.parseInt(scanner.nextLine());
                builder.agregarIngredientePersonalizado(nuevo, precio);
            }
        }
    }

    public void inicializar() {
        builder.reset();
        baseIngredientes();
        seleccionarIngredientes();
        mostrarHamburguesa();
    }

    private void mostrarHamburguesa() {
        Hamburguesa hamburguesa = builder.build();
        System.out.println("--- HAMBURGUESA CREADA ---");
        hamburguesa.mostrar();
        System.out.println("!DISFRUTE DE SU HAMBURGUESA!");
    }
}