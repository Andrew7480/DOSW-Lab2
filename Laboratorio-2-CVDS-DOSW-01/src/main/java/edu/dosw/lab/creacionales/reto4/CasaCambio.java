package edu.dosw.lab.creacionales.reto4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal de la Casa de Cambio
 * Maneja la entrada y salida del usuario
 */
public class CasaCambio {
    private static CambioStrategy estrategia = new CambioStrategy();
    private static MoneyFactory factory = MoneyFactory.obtenerInstancia();
    private static Scanner scanner = new Scanner(System.in);
    private static List<String> historialTransacciones = new ArrayList<>();
    
    public void inicializar() {
        realizarMultiplesConversiones();
    }
    
    private static void realizarMultiplesConversiones() {
        System.out.print("Ingrese número de transacciones: ");
        
        try {
            int numTransacciones = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            if (numTransacciones <= 0) {
                System.out.println("❌ Debe realizar al menos 1 transacción");
                return;
            }
            
            for (int i = 1; i <= numTransacciones; i++) {
                System.out.println("\n--- Transacción " + i + " ---");
                
                System.out.print("Ingrese monto: ");
                double cantidad = scanner.nextDouble();
                scanner.nextLine(); // Limpiar buffer
                
                if (cantidad <= 0) {
                    System.out.println("❌ La cantidad debe ser mayor a 0");
                    continue;
                }
                
                System.out.print("Ingrese moneda de origen (USD, EUR, JPY, COP): ");
                String monedaOrigen = scanner.nextLine().trim().toUpperCase();
                
                System.out.print("Ingrese monedas destino (separadas por coma, ej: USD,JPY): ");
                String monedasDestinoStr = scanner.nextLine().trim().toUpperCase();
                String[] monedasDestino = monedasDestinoStr.split(",");
                
                // Realizar conversiones para cada moneda destino
                for (String monedaDestino : monedasDestino) {
                    monedaDestino = monedaDestino.trim();
                    double resultado = estrategia.convertir(cantidad, monedaOrigen, monedaDestino);
                    
                    // Guardar en historial
                    String transaccion = String.format("%.0f %s → %.2f %s", cantidad, monedaOrigen, resultado, monedaDestino);
                    historialTransacciones.add(transaccion);
                }
            }
            
            // Mostrar todas las transacciones agrupadas
            System.out.println();
            mostrarTransaccionesAgrupadas();
            
            // Mostrar totales por moneda usando streams
            mostrarTotalesPorMoneda();
            
        } catch (Exception e) {
            System.out.println("❌ Error: Ingrese un número válido");
            scanner.nextLine(); // Limpiar buffer
        }
    }
    
    private static void mostrarTotalesPorMoneda() {
        System.out.println("\n---- Totales por moneda ----");
        
        // Usar streams para agrupar y sumar por moneda destino
        historialTransacciones.stream()
            .collect(java.util.stream.Collectors.groupingBy(
                transaccion -> {
                    String[] partes = transaccion.split(" → ");
                    String destino = partes[1];
                    return destino.split(" ")[1]; // Obtener solo el código de moneda
                },
                java.util.stream.Collectors.summingDouble(transaccion -> {
                    String[] partes = transaccion.split(" → ");
                    String destino = partes[1];
                    return Double.parseDouble(destino.split(" ")[0]);
                })
            ))
            .forEach((moneda, total) -> {
                if (moneda.equals("JPY")) {
                    System.out.printf("%s: %.0f %s%n", moneda, total, moneda);
                } else {
                    System.out.printf("%s: %.2f %s%n", moneda, total, moneda);
                }
            });
    }
    
    private static void mostrarTransaccionesAgrupadas() {
        if (historialTransacciones.isEmpty()) {
            System.out.println("📝 No hay transacciones registradas.");
            return;
        }
        
        // Agrupar transacciones por moneda origen y monto
        java.util.Map<String, java.util.List<String>> transaccionesPorOrigen = 
            historialTransacciones.stream()
                .collect(java.util.stream.Collectors.groupingBy(transaccion -> {
                    String[] partes = transaccion.split(" → ");
                    return partes[0]; // "monto monedaOrigen"
                }));
        
        int transaccionNum = 1;
        for (java.util.Map.Entry<String, java.util.List<String>> entry : transaccionesPorOrigen.entrySet()) {
            String origen = entry.getKey();
            java.util.List<String> conversiones = entry.getValue();
            
            System.out.println("Transacción " + transaccionNum + ": " + origen);
            
            for (String conversion : conversiones) {
                String[] partes = conversion.split(" → ");
                String destino = partes[1];
                String[] destinoPartes = destino.split(" ");
                String monedaDestino = destinoPartes[1];
                double cantidad = Double.parseDouble(destinoPartes[0]);
                
                if (monedaDestino.equals("JPY")) {
                    System.out.printf("    Convertido a %s: %.0f %s%n", monedaDestino, cantidad, monedaDestino);
                } else {
                    System.out.printf("    Convertido a %s: %.2f %s%n", monedaDestino, cantidad, monedaDestino);
                }
            }
            System.out.println();
            transaccionNum++;
        }
    }
}
