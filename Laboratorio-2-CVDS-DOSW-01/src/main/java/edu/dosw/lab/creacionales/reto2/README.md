
# Sistema de hamburguesas personalizadas del Chef

> **Descripción general:**  
> Un Chef prepara hamburguesas personalizadas para sus clientes, permitiendo elegir entre diferentes ingredientes y agregando opciones personalizadas. El objetivo es construir la hamburguesa paso a paso, mostrando el resultado final y el precio total.

## Descripción del problema

El Chef necesita un sistema que permita a los clientes seleccionar los ingredientes de su hamburguesa, incluyendo la opción de agregar ingredientes personalizados. No todos los ingredientes son obligatorios y cada hamburguesa puede ser única según la elección del cliente.

## Objetivo

El sistema debe cumplir con las siguientes funcionalidades:
- Permitir al usuario elegir ingredientes y agregar personalizados.
- Calcular el precio total usando streams.
- Mostrar la hamburguesa final con todos los ingredientes seleccionados.

## Lineamientos de desarrollo

**Streams:**  
Se utilizan streams para sumar los precios de los ingredientes seleccionados y mostrar la lista de ingredientes de forma eficiente.

## Patrón de diseño

- **Categoría:** Creacional
- **Patrón utilizado:** Builder
- **Justificación:** El patrón Builder permite construir la hamburguesa paso a paso, facilitando la personalización y separación entre la construcción y la representación final.
- **Cómo lo aplico:** Se define la interfaz `HamburguesaBuilder` con métodos para seleccionar ingredientes, agregar personalizados, construir la hamburguesa y reiniciar el proceso. Es importante recalcar que este nos permite construir paso a paso la hamburgesa El `Chef` utiliza el builder para crear la hamburguesa según las elecciones del usuario.

## Ejemplo de uso

### Ejemplo de entrada y salida

```
Seleccione ingredientes para su hamburguesa:
1. Pan ($3.000)
2. Carne ($10.000)
3. Queso ($5.000)
4. Lechuga ($2.000)
5. Tomate ($2.000)
6. Salsa especial ($3.000)
7. Agregar un nuevo ingrediente
Ingrese los números separados por coma: 1,2,3,7

Ingrese el nombre del nuevo ingrediente: Tocino
Ingrese el precio del ingrediente: 4.000

--- HAMBURGUESA PERSONALIZADA ---
Ingredientes seleccionados: Pan, Carne, Queso, Tocino
Precio total: $22.000
------------------------------
¡Disfrute su hamburguesa!
```

---

> _Este reto aplica buenas prácticas, el patrón Builder y programación funcional para garantizar un sistema flexible y fácil de mantener._
