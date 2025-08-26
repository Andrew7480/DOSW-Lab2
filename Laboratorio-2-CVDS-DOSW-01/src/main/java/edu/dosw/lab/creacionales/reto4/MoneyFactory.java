import java.util.HashMap;
import java.util.Map;

/**
 * Factory Singleton que maneja todas las monedas y sus tasas de cambio respecto al dólar
 */
public class MoneyFactory {
    private static MoneyFactory instancia;
    private Map<String, Double> monedas;
    
    // Constructor privado para implementar Singleton
    private MoneyFactory() {
        inicializarMonedas();
    }
    
    /**
     * Obtiene la única instancia del factory (Singleton)
     */
    public static MoneyFactory obtenerInstancia() {
        if (instancia == null) {
            instancia = new MoneyFactory();
        }
        return instancia;
    }
    
    /**
     * Inicializa la matriz de monedas con sus tasas de cambio respecto al dólar
     * Cada valor representa cuánto de esa moneda equivale a 1 dólar
     */
    private void inicializarMonedas() {
        monedas = new HashMap<>();
        
        // Matriz de monedas: [nombre, cuánto de esta moneda equivale a 1 dólar]
        String[][] datosMonedas = {
            {"USD", "1.0"},        // Dólar estadounidense (base)
            {"EUR", "0.909"},      // Euro (50 EUR = 55 USD → 1 USD = 0.909 EUR)
            {"JPY", "150.0"},      // Yen japonés (8250 JPY = 55 USD → 1 USD = 150 JPY)
            {"COP", "4000.0"},     // Peso colombiano (100000 COP = 25 USD → 1 USD = 4000 COP)

        };
        
        // Cargar las monedas en el mapa
        for (String[] datos : datosMonedas) {
            String nombre = datos[0];
            double tasa = Double.parseDouble(datos[1]);
            monedas.put(nombre, tasa);
        }
    }
    
    /**
     * Obtiene la tasa de cambio de una moneda respecto al dólar
     */
    public double obtenerTasaCambio(String moneda) {
        Double tasa = monedas.get(moneda.toUpperCase());
        if (tasa == null) {
            throw new IllegalArgumentException("Moneda no soportada: " + moneda);
        }
        return tasa;
    }
    
    /**
     * Verifica si una moneda está disponible
     */
    public boolean existeMoneda(String moneda) {
        return monedas.containsKey(moneda.toUpperCase());
    }
    
    /**
     * Obtiene todas las monedas disponibles
     */
    public Map<String, Double> obtenerTodasLasMonedas() {
        return new HashMap<>(monedas);
    }
    
    /**
     * Muestra todas las monedas disponibles con sus tasas
     */
    public void mostrarMonedasDisponibles() {
        System.out.println("=== MONEDAS DISPONIBLES ===");
        for (Map.Entry<String, Double> entry : monedas.entrySet()) {
            System.out.println(entry.getKey() + " - 1 USD = " + entry.getValue() + " " + entry.getKey());
        }
    }
}
