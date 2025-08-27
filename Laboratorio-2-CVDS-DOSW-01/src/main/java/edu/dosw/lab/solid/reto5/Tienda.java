package edu.dosw.lab.solid.reto5;
import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {          
    private static ArrayList<Cafe> cafes = new ArrayList<>();
    private double preciototal;
    public void inicializar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Numeros de cafes a personalizar: ");
        int numero = sc.nextInt();
        for(int i = 0; i < numero; i++){
            Scanner scs = new Scanner(System.in);
            System.out.print("Seleccione toppings (numeros separados por coma): \n");
            String input = scs.nextLine();
            String[] toppingNumbers = input.split(",");
            Cafe cafe = new Cafe(toppingNumbers);
            cafes.add(cafe);
        }

        double preciototal = 0;
        for (int j = 0; j < cafes.size(); j++) {
            System.out.println("--- Cafe " + (j+1) + "---");
            System.out.println("Toppings: " + cafes.get(j).getToppingsUsados());
            System.out.println("Precio: " + cafes.get(j).getPrecio() + "\n");
            preciototal += cafes.get(j).getPrecio();
        }
        System.out.println("--------------------------------");
        System.out.println("Total a pagar por todos los cafés: " + preciototal);
        System.out.println("Disfrute su café!");
    }

    
}
