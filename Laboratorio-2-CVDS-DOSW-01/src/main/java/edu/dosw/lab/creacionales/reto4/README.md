# Sistema de Casa de Cambio

> **Descripción general:**  
> El reto de la casa de cambio consiste en implementar un sistema que permita convertir cualquier moneda a cualquier otra denominación utilizando tasas de cambio reales, solucionando el problema de "El Gringo" que estafaba a los usuarios aplicando la misma tasa para todas las conversiones.

## Descripción del problema

Una casa de cambio tenía como anterior propietario conocido como "El Gringo", quien para cualquier persona que quisiera cambiar su dinero a dólares (Euros, Yenes, Pesos Colombianos) utilizaba la misma tasa de cambio para todas, por lo que los usuarios eran estafados.

El nuevo dueño ha contratado un equipo para crear un servicio que permita convertir cualquier moneda a cualquier designación de las utilizadas con la tasa real.

## Objetivo

El sistema tiene como objetivo resolver los problemas del anterior propietario y cumplir con las siguientes funcionalidades:
- Aceptar cualquier cantidad de monedas para conversión
- Permitir al usuario ingresar X transacciones
- Mostrar tanto la cantidad original como la convertida
- Usar streams para sumar varios pagos y calcular totales
- Aplicar tasas de cambio reales y específicas para cada moneda

## Lineamientos de desarrollo

**Streams:**  
Se utilizan para calcular totales de transacciones por moneda, agrupar transacciones por origen y procesar el historial de conversiones, aplicando funciones como `groupingBy`, `summingDouble`, `mapToDouble` y `forEach` para manejar colecciones de transacciones de manera eficiente.

## Patrones de Diseño Utilizados

### Patrón de Diseño: **CREACIONAL**
**Patrón Utilizado:** Singleton  
**Justificación:** Se necesita garantizar que existe una única instancia del factory de monedas en toda la aplicación para mantener consistencia en las tasas de cambio. Múltiples instancias podrían causar inconsistencias en los datos y consumo innecesario de memoria.  
**Como Lo aplico:** La clase `MoneyFactory` implementa el patrón Singleton con:
- Constructor privado que impide la creación directa de instancias
- Método estático `obtenerInstancia()` que controla la creación de la única instancia
- Variable estática `instancia` que almacena la referencia única
- Inicialización lazy (solo se crea cuando se necesita por primera vez)

### Patrón de Diseño: **CREACIONAL**  
**Patrón Utilizado:** Factory Method  
**Justificación:** Es necesario encapsular la lógica de creación y gestión de las monedas con sus tasas de cambio. El factory centraliza el acceso a los datos de monedas y proporciona una interfaz uniforme para obtener las tasas de cambio.  
**Como Lo aplico:** La clase `MoneyFactory` actúa como factory mediante:
- Matriz interna que almacena las monedas y sus tasas respecto al dólar
- Métodos para obtener tasas de cambio específicas
- Validación de existencia de monedas
- Encapsulación de la lógica de inicialización de datos

### Patrón de Diseño: **COMPORTAMENTAL**
**Patrón Utilizado:** Strategy  
**Justificación:** El sistema debe ser flexible para permitir diferentes algoritmos de conversión. Aunque actualmente usamos conversión vía dólar, en el futuro se podrían implementar otras estrategias (conversión directa, tasas cruzadas, etc.) sin modificar el código cliente.  
**Como Lo aplico:** La clase `CambioStrategy` implementa la estrategia de conversión:
- Encapsula el algoritmo específico de conversión vía dólar
- Permite cambiar la estrategia sin afectar el código que la usa
- Separa la lógica de conversión de la interfaz de usuario
- Facilita la extensibilidad para futuras estrategias de conversión

## Estrategia de Conversión Implementada

**Metodología:** Conversión vía dólar americano (USD)
1. **Paso 1:** Convertir la moneda origen a dólares usando la fórmula: `cantidad / tasa_origen`
2. **Paso 2:** Convertir los dólares a la moneda destino usando: `cantidad_dolares * tasa_destino`

**Ventajas de esta estrategia:**
- Simplifica los cálculos (solo necesitamos tasas respecto a USD)
- Reduce la complejidad de O(n²) a O(n) en el almacenamiento de tasas
- Facilita el mantenimiento y actualización de tasas de cambio
- Es el estándar internacional real usado en mercados financieros

## Encapsulamiento

Los atributos de las clases se encuentran protegidos mediante modificadores de acceso privados, y solo se permite el acceso a través de métodos públicos controlados. Las tasas de cambio son inmutables una vez inicializadas en el factory, garantizando la integridad de los datos.

## Polimorfismo

El polimorfismo se implementa mediante la estrategia de conversión, permitiendo que el sistema utilice diferentes algoritmos de cambio sin requerir conocer la implementación específica. Así, el sistema puede seleccionar o cambiar la estrategia de conversión en tiempo de ejecución.


## Funcionalidades Implementadas
- **Conversiones múltiples:** Permite realizar X transacciones en una sola ejecución
- **Múltiples monedas destino:** Cada transacción puede convertir a varias monedas separadas por coma
- **Historial agrupado:** Muestra las transacciones organizadas por origen
- **Cálculo con Streams:** Suma totales por moneda usando Java Streams
- **Validación de monedas:** Verifica que las monedas existan
- **Interfaz simplificada:** Inicio directo sin menús, solo funcionalidad principal

## Monedas Soportadas y Tasas
| Moneda | Código | Tasa (1 USD = X) |
|--------|--------|------------------|
| Dólar Estadounidense | USD | 1.0 |
| Euro | EUR | 0.909 |
| Yen Japonés | JPY | 150.0 |
| Peso Colombiano | COP | 4000.0 |


## Uso de Java Streams

El sistema utiliza Java Streams para procesar y agrupar transacciones:

### 1. Agrupación por moneda destino y suma de totales:
```java
historialTransacciones.stream()
    .collect(Collectors.groupingBy(
        transaccion -> {
            String[] partes = transaccion.split(" → ");
            String destino = partes[1];
            return destino.split(" ")[1]; // Código de moneda
        },
        Collectors.summingDouble(transaccion -> {
            String[] partes = transaccion.split(" → ");
            String destino = partes[1];
            return Double.parseDouble(destino.split(" ")[0]);
        })
    ))
```

### 2. Agrupación por transacción origen:
```java
historialTransacciones.stream()
    .collect(Collectors.groupingBy(transaccion -> {
        String[] partes = transaccion.split(" → ");
        return partes[0]; // "monto monedaOrigen"
    }))
```

**Funciones utilizadas:**
- **`.stream()`:** Convierte la lista en un stream para procesamiento
- **`.collect()`:** Recolecta los resultados en una estructura de datos
- **`.groupingBy()`:** Agrupa elementos por un criterio específico
- **`.summingDouble()`:** Suma valores double de los elementos agrupados
- **`.forEach()`:** Itera sobre los resultados para mostrarlos

## Ejemplo de uso

### Ejemplo de entrada y salida

```
Ingrese número de transacciones: 2

--- Transacción 1 ---
Ingrese monto: 50
Ingrese moneda de origen (USD, EUR, JPY, COP): EUR
Ingrese monedas destino (separadas por coma, ej: USD,JPY): USD,JPY

--- Transacción 2 ---
Ingrese monto: 100000
Ingrese moneda de origen (USD, EUR, JPY, COP): COP
Ingrese monedas destino (separadas por coma, ej: USD,JPY): USD,EUR

Transacción 1: 50 EUR
    Convertido a USD: 55 USD
    Convertido a JPY: 8250 JPY

Transacción 2: 100000 COP
    Convertido a USD: 25.00 USD
    Convertido a EUR: 22,73 EUR

---- Totales por moneda ----
USD: 80 USD
JPY: 8250 JPY
EUR: 22,73 EUR
```

---

> _Este reto aplica buenas prácticas, principios SOLID y patrones de diseño para garantizar un sistema robusto, extensible y fácil de mantener, eliminando las estafas del anterior propietario con una interfaz simplificada y eficiente._
