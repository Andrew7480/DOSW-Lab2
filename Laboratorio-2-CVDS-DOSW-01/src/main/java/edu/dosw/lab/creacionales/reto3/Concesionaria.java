package edu.dosw.lab.creacionales.reto3;

import java.util.*;

public class Concesionaria {
    private Map<String, List<MedioTransporte>> vehiculos;
    private CategoriaFactory categoriaFactory;

    public Concesionaria() {
        this.vehiculos = new HashMap<>();
        categoriaFactory = new EconomicoFactory();
    }

    public void agregarVehiculo(MedioTransporte vehiculo, String categoria) {
        vehiculos.computeIfAbsent(categoria, k -> new ArrayList<>()).add(vehiculo);
    }

    public List<MedioTransporte> obtenerVehiculosPorCategoria(String categoria) {
        return vehiculos.getOrDefault(categoria, Collections.emptyList());
    }
    private String elegirCategoria(String tipo){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la categoria:");
        System.out.println("\u001B[31m1.\u001B[0m Economico");
        System.out.println("\u001B[31m2.\u001B[0m Lujo");
        System.out.println("\u001B[31m3.\u001B[0m Usado");
        String categoria = scanner.nextLine();

        switch (categoria) {
            case "1":
                categoriaFactory = new EconomicoFactory();
                return "Economico";
            case "2":
                categoriaFactory = new LujoFactory();
                return "Lujo"; 
            case "3":
                categoriaFactory = new UsadoFactory();
                return "Usado";
            default:
                System.out.println("Opción inválida. Selección por defecto: Economico.");
                categoriaFactory = new EconomicoFactory();
        }
        return "Economico";
    }
    private String[] elegirTipo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de vehículo:");
        List<String> tipos = categoriaFactory.tipos();
        for (int i = 0; i < tipos.size(); i++) {
            System.out.printf("\u001B[31m%d.\u001B[0m %s%n", i + 1, tipos.get(i));
        }

        System.out.print("Ingrese opción: ");
        int tipo = Integer.parseInt(scanner.nextLine());
        String tipoStr;
        if (tipo == 1) {
            tipoStr = "Tierra";
        } else if (tipo == 3) {
            tipoStr = "Acuatico";
        } else if (tipo == 2) {
            tipoStr = "Aereo";
        } else {
            System.out.println("Opción inválida. Selección por defecto: Tierra.");
            tipoStr = "Tierra";
        }

        String categoria = elegirCategoria(tipoStr);
        return new String[] { tipoStr, categoria };
    }
    private void imprimirCompras() {
        System.out.println("--- RESUMEN DE COMPRA ---");
        for (String categoria : vehiculos.keySet()) {
            System.out.println("Categoría: " + categoria);
            for (MedioTransporte vehiculo : vehiculos.get(categoria)) {
                System.out.println("  - " + vehiculo);
            }
        }
        System.out.println("--- RESUMEN FINAL ---");
        System.out.println("Total de vehículos vendidos: " + obtenerPrecioTotal());
    }
    private double obtenerPrecioTotal() {
        return vehiculos.values().stream()
                .flatMap(List::stream)
                .mapToDouble(MedioTransporte::getPrecio)
                .sum();
    }
    

    public void venderVehiculo() {
        Scanner scanner = new Scanner(System.in);
        boolean agregarOtro = true;

        System.out.println("Bienvenido al Reino de los Vehículos!");

        while (agregarOtro) {
            String[] tipo = elegirTipo();
            List<String> modelos = categoriaFactory.modelos(tipo[0]);
            System.out.println("\nSeleccione el modelo de vehículo:");
            for (int i = 0; i < modelos.size(); i++) {
                System.out.printf("\u001B[31m%d.\u001B[0m %s%n", i + 1, modelos.get(i));
            }
            

            System.out.print("Ingrese opción: ");
            int modelo = Integer.parseInt(scanner.nextLine());

            agregarVehiculo(categoriaFactory.crearPorFactory(tipo[0], modelos.get(modelo - 1)), tipo[1]);

            System.out.print("\n¿Desea agregar otro vehículo? (si/no): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            agregarOtro = respuesta.equals("si");
            System.out.println();
        }
        imprimirCompras();
    }
}
