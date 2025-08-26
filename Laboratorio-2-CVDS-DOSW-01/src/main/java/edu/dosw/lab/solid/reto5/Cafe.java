s
package edu.dosw.lab.solid.reto5;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Cafe {
    private double precio;
    private TreeMap<Integer, String> nombresToppings;
    private TreeMap<Integer, Double> preciosToppings;
    private ArrayList toppingsUsados;

    public Cafe(String[] toppings) {
        precio = 2000.0; // Precio base del cafe
        toppingsUsados = new ArrayList();
        
        // TreeMap para nombres de toppings
        nombresToppings = new TreeMap<>();
        nombresToppings.put(1, "Leche");
        nombresToppings.put(2, "Chocolate");
        nombresToppings.put(3, "Caramelo");
        nombresToppings.put(4, "Crema Batida");
        nombresToppings.put(5, "Menta");

        // TreeMap para precios de toppings
        preciosToppings = new TreeMap<>();
        preciosToppings.put(1, 1000.0);
        preciosToppings.put(2, 1500.0);
        preciosToppings.put(3, 1200.0);
        preciosToppings.put(4, 2000.0);
        preciosToppings.put(5, 1300.0);

        agregarToppings(toppings);
        
    }
    private void agregarToppings(String[] toppings) {
        
        for (String topping : toppings) {
            int toppingNumber = Integer.parseInt(topping.trim());
            if (toppingNumber == 6){
                Scanner scs = new Scanner(System.in);
                System.out.print("Ingrese el nombre del nuevo topping: ");
                String nombre = scs.nextLine();
                toppingsUsados.add(nombre);

                System.out.print("Ingrese el precio del nuevo topping: ");
                double precioTopping = scs.nextDouble();
                this.precio += precioTopping;

            }else{
                this.precio += preciosToppings.get(toppingNumber);
                toppingsUsados.add(nombresToppings.get(toppingNumber));
            }
            

        }
    }


    public double getPrecio() {
        return precio;
    }
    public TreeMap<Integer, String> getNombresToppings() {
        return nombresToppings;
    }
    public TreeMap<Integer, Double> getPreciosToppings() {
        return preciosToppings;
    }
    public ArrayList getToppingsUsados() {
        return toppingsUsados;
    }
}