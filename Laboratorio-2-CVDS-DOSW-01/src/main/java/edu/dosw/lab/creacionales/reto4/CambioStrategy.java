package edu.dosw.lab.creacionales.reto4;

/**
 * Estrategia de conversión que implementa el patrón Strategy
 * Convierte cualquier moneda a dólares primero, luego a la moneda destino
 */
public class CambioStrategy {
    private MoneyFactory factory;
    
    public CambioStrategy() {
        this.factory = MoneyFactory.obtenerInstancia();
    }
    
    /**
     * Convierte una cantidad de una moneda origen a una moneda destino
     * Estrategia: Moneda Origen → USD → Moneda Destino
     */
    public double convertir(double cantidad, String monedaOrigen, String monedaDestino) {
        // Validar que ambas monedas existan
        if (!factory.existeMoneda(monedaOrigen)) {
            throw new IllegalArgumentException("Moneda origen no válida: " + monedaOrigen);
        }
        if (!factory.existeMoneda(monedaDestino)) {
            throw new IllegalArgumentException("Moneda destino no válida: " + monedaDestino);
        }
        
        // Si es la misma moneda, retornar la cantidad original
        if (monedaOrigen.equalsIgnoreCase(monedaDestino)) {
            return cantidad;
        }
        
        // Paso 1: Convertir moneda origen a dólares
        double cantidadEnDolares = convertirADolares(cantidad, monedaOrigen);
        
        // Paso 2: Convertir dólares a moneda destino
        double cantidadFinal = convertirDeDolares(cantidadEnDolares, monedaDestino);
        
        return cantidadFinal;
    }
    
    /**
     * Convierte una cantidad de cualquier moneda a dólares
     */
    private double convertirADolares(double cantidad, String monedaOrigen) {
        if (monedaOrigen.equalsIgnoreCase("USD")) {
            return cantidad; // Ya está en dólares
        }
        
        double tasa = factory.obtenerTasaCambio(monedaOrigen);
        // Si 1 USD = X monedaOrigen, entonces cantidad/X = cantidad en USD
        return cantidad / tasa;
    }
    
    /**
     * Convierte una cantidad de dólares a cualquier moneda
     */
    private double convertirDeDolares(double cantidadDolares, String monedaDestino) {
        if (monedaDestino.equalsIgnoreCase("USD")) {
            return cantidadDolares; // Ya está en dólares
        }
        
        double tasa = factory.obtenerTasaCambio(monedaDestino);
        // Si 1 USD = X monedaDestino, entonces cantidadDolares * X = cantidad en monedaDestino
        return cantidadDolares * tasa;
    }
    
    /**
     * Muestra el proceso de conversión paso a paso
     */
    public void mostrarProcesoConversion(double cantidad, String monedaOrigen, String monedaDestino) {
        System.out.println("\n--- PROCESO DE CONVERSIÓN ---");
        System.out.printf("Cantidad original: %.2f %s%n", cantidad, monedaOrigen.toUpperCase());
        
        if (!monedaOrigen.equalsIgnoreCase("USD")) {
            double cantidadEnDolares = convertirADolares(cantidad, monedaOrigen);
            System.out.printf("Paso 1 (%s → USD): %.2f USD%n", monedaOrigen.toUpperCase(), cantidadEnDolares);
            
            if (!monedaDestino.equalsIgnoreCase("USD")) {
                double cantidadFinal = convertirDeDolares(cantidadEnDolares, monedaDestino);
                System.out.printf("Paso 2 (USD → %s): %.2f %s%n", monedaDestino.toUpperCase(), cantidadFinal, monedaDestino.toUpperCase());
            }
        } else if (!monedaDestino.equalsIgnoreCase("USD")) {
            double cantidadFinal = convertirDeDolares(cantidad, monedaDestino);
            System.out.printf("Conversión (USD → %s): %.2f %s%n", monedaDestino.toUpperCase(), cantidadFinal, monedaDestino.toUpperCase());
        }
    }
}
