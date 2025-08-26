
# Sistema de ventas para la tienda de Don Pepe

> **Descripción general:**  
> El reto de la tienda de Don Pepe consiste en implementar un sistema sencillo y estructurado que permita gestionar las ventas de acuerdo al tipo de cliente y generar recibos detallados y claros, facilitando la administración y evitando errores en los cálculos de descuentos y totales.

## Descripción del problema

Don Pepe cuenta con serios problemas con su contabilidad, pues a fin de mes no cuadran sus cuentas, debido a que factura sus productos de 2 formas distintas, según el tipo de cliente (nuevo o frecuente). Esto genera confusión y pérdidas.

## Objetivo

El sistema tiene como objetivo resolver los problemas del cliente y cumplir con las siguientes funcionalidades:
- Calcular los descuentos correctamente según el tipo de cliente.
- Generar facturas detalladas que incluyan:
    - Productos comprados
    - Precio total
    - Descuento aplicado
- Permitir al cliente agregar productos a un carrito de compras.

## Lineamientos de desarrollo

**Streams:**  
Se utilizan en el carrito de compras para generar la factura, calcular totales y facilitar la búsqueda de productos, aplicando funciones como `map`, `filter`, `reduce` y `forEach` para procesar colecciones de productos de manera eficiente.

### Principios SOLID

- **S (Responsabilidad Única):** Cada clase tiene una única responsabilidad, gestionando solo sus propios atributos y lógica.
- **O (Abierto/Cerrado):** Podemos agregar nuevos tipos de descuentos a los clientes sin modificar el código existente, gracias al uso de la interfaz y el patrón Strategy.
- **L (Sustitución de Liskov):** Las estrategias de descuento pueden ser intercambiadas sin afectar el funcionamiento del sistema.
- **I (Segregación de Interfaces):** En `DiscountStrategy` solo se define lo necesario para el cálculo de los descuentos.
- **D (Inversión de Dependencias):** El carrito de compras depende de la abstracción `DiscountStrategy`, no de implementaciones concretas.

## Polimorfismo

El polimorfismo se integra mediante la interfaz `DiscountStrategy`, permitiendo que el cliente utilice diferentes tipos de descuento sin requerir conocer la implementación específica. Así, el sistema puede seleccionar la estrategia adecuada en tiempo de ejecución.

## Encapsulamiento

Los atributos de las clases se encuentran protegidos o privados, y solo se permite el acceso a través de métodos públicos (`getters`). Además, el precio unitario de los productos es inmutable una vez creado, garantizando la integridad de los datos.

## Patrones de diseño

- **Strategy:** Se utiliza para aplicar cada tipo de descuento mediante la interfaz `DiscountStrategy`, permitiendo cambiar la lógica de descuento sin modificar el resto del sistema.
- **Singleton:** Se aplica en la clase principal `Tienda`, asegurando que solo exista una instancia de la tienda durante la ejecución del programa. Esto facilita la gestión centralizada del catálogo de productos y evita inconsistencias.

## Ejemplo de uso

### Ejemplo de entrada y salida

```
Bienvenido a la tienda Don Pepe!
Cliente: Frecuente
Productos disponibles:
    - Camiseta - $20.000
    - Pantalón - $50.000
    - Galletas - $500
    - Jugo Natural - $3.000
Ingrese su compra:
    - Camiseta: 2 unidades
    - Galletas: 3 unidades
    - Jugo Natural: 5 unidades

--- RECIBO DE COMPRA ---
Cliente: Frecuente
Productos:
    - Camiseta - $40.000
    - Galletas - $1.500
    - Jugo Natural - $15.000

Subtotal: $56.500
Descuento aplicado: $5.650
Total a pagar: $50.850
------------------------
¡Gracias por su compra!
```

---

> _Este reto aplica buenas prácticas, principios SOLID y patrones de diseño para garantizar un sistema robusto, extensible y fácil de mantener._
