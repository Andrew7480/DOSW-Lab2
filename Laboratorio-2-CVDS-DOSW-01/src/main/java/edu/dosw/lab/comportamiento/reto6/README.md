# Sistema de asignación de tickets de soporte

## Descripción general  
El reto consiste en implementar un sistema de gestión de tickets mediante el patrón **Chain of Responsibility**, que permita asignar solicitudes de soporte técnico a diferentes niveles de técnicos (básico, intermedio y avanzado). De esta forma se asegura que los problemas se atiendan de acuerdo a su prioridad y nivel, evitando confusiones y sobrecarga de un solo técnico.

---

## Descripción del problema  
Actualmente no es posible asignar un ticket a un técnico específico de forma directa, lo cual genera retrasos y problemas en la atención al cliente. Algunos técnicos reciben tickets que no pueden resolver por su nivel, lo que obliga a reasignarlos manualmente.  

---

## Objetivo  
El sistema busca resolver este problema implementando una cadena de responsabilidades que cumpla con las siguientes funcionalidades:

- Asignar los tickets al técnico correspondiente según su nivel.  
- Escalar el ticket automáticamente cuando el técnico actual no pueda resolverlo.  
- Asegurar que los tickets con mayor prioridad sean atendidos por un técnico con el nivel adecuado.  
- Reducir el tiempo de resolución evitando asignaciones incorrectas.  

---

## Lineamientos de desarrollo  

### Streams  
Se pueden utilizar **Streams** para procesar y filtrar tickets, aplicando funciones como `filter`, `map` y `forEach` para recorrer las listas de solicitudes y facilitar su asignación y escalamiento.  

### Polimorfismo  
El polimorfismo se aplica en la clase abstracta `tecnico`, ya que así podemos instanciar las clases `TecnicoBasico`, `TecnicoIntermedio` y `TecnicoAvanzado`. En el cual cada clase se comporta de forma diferente.

## OVERRIDE
Gracias a la clase abstracta `Tecnico`, esta tiene un metodo resolver que cada clase absatracta la redefine de tal manera de darle solucion al problema otorgado.

### Encapsulamiento  
Los atributos de los técnicos y de los tickets se mantienen privados o protegidos, garantizando que solo se accedan mediante métodos controlados. Así, la asignación y escalamiento de tickets se maneja de manera segura.  

---

## Patrones de diseño  
- **Chain of Responsibility:** Permite encadenar diferentes técnicos para manejar solicitudes de soporte, de forma que si un técnico no puede resolver el ticket, este se pasa al siguiente en la cadena.   
