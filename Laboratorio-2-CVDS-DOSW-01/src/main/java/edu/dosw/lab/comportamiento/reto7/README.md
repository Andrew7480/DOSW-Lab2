# Control Remoto Mágico

> **Descripción general:**  
> El reto del Control Remoto Mágico consiste en implementar un sistema que permite al usuario ejecutar acciones sobre varios dispositivos del hogar: luces, puertas, música y persianas. Cada acción puede tener parámetros específicos, puede ser deshecha después de ejecutarse, y el sistema mantiene un historial completo para descubrir quién desconfiguró cada aparato.

## Descripción del problema

Un control remoto mágico que permite al usuario ejecutar acciones sobre varios dispositivos del hogar, pero alguien ha desconfigurado los electrodomésticos. Tu tarea es usarlo para probar, ejecutar y deshacer acciones, y al final descubrir quién desconfiguró cada aparato.

## Objetivo

El sistema tiene como objetivo resolver el problema de descubrir quién desconfiguró los electrodomésticos y cumplir con las siguientes funcionalidades:

- Permitir ejecutar X acciones, registrar quién las ejecutó (usuario)
- Cada acción puede tener parámetros específicos (por ejemplo: ajustar volumen)
- Permitir deshacer cualquier acción individual
- Registrar un historial completo para revisar quién desconfiguró qué
- Mostrar un resumen final con las acciones ejecutadas y quién las hizo

## Lineamientos de desarrollo

**Patrones de Diseño:**  
Se utiliza el patrón Command para encapsular cada acción como un objeto independiente, permitiendo ejecutar, deshacer y almacenar comandos de manera uniforme. Esto facilita el manejo del historial y la funcionalidad de deshacer.

### Principios SOLID

- **S (Responsabilidad Única):** Cada clase tiene una única responsabilidad bien definida: `AccionAjustarVolumen` solo maneja el ajuste de volumen, `HistorialAcciones` solo gestiona el historial, etc.
- **O (Abierto/Cerrado):** Es fácil agregar nuevas acciones implementando `AccionRemota` sin modificar código existente.
- **L (Sustitución de Liskov):** Todas las implementaciones de `AccionRemota` son intercambiables sin afectar el funcionamiento del sistema.
- **I (Segregación de Interfaces):** `AccionRemota` define solo los métodos necesarios para todas las acciones, sin forzar implementaciones innecesarias.
- **D (Inversión de Dependencias):** `ControlRemotoMagico` depende de la abstracción `AccionRemota`, no de implementaciones concretas directamente.

## Polimorfismo

El polimorfismo se integra mediante la interfaz `AccionRemota`, permitiendo que el control remoto ejecute diferentes tipos de acciones sin conocer la implementación específica. El sistema puede manejar cualquier acción que implemente la interfaz de manera uniforme.

## Encapsulamiento

Los atributos de las clases están protegidos como `private` y `final` cuando es apropiado. El acceso se realiza únicamente a través de métodos públicos, garantizando la integridad de los datos y el estado de las acciones.

## Patrones de diseño

### Patrón de Diseño
**Comportamiento**

### Patrón Utilizado
**Command (Comando)**

### Justificación
El patrón Command encapsula cada acción como un objeto independiente, permitiendo ejecutar, deshacer y almacenar comandos de manera uniforme. Esto facilita el manejo del historial y la funcionalidad de deshacer sin necesidad de patrones adicionales de creación. Es ideal para sistemas que requieren operaciones reversibles y seguimiento de acciones.

### Cómo Lo Aplico
1. **`AccionRemota`** es la interfaz Command que define los métodos `ejecutar()`, `deshacer()`, `getDescripcion()`, `getUsuario()` y `fueDeshecha()`
2. **Cada acción específica** (`AccionAjustarVolumen`, `AccionEncenderLuz`, `AccionAbrirPuerta`, `AccionReproducirMusica`) es un ConcreteCommand que implementa la interfaz
3. **`ControlRemotoMagico`** actúa como Invoker que ejecuta comandos, los crea directamente y gestiona la interacción con el usuario
4. **`HistorialAcciones`** almacena y gestiona los comandos ejecutados, proporcionando funcionalidades de análisis y reporte

## Ejemplo de uso

### Ejemplo de entrada y salida

```
Número de acciones a registrar: 4

Acción 1:
Usuario: Andrés
Seleccione: 1. Encender luz 2. Abrir puerta 3. Reproducir música 4. Ajustar volumen
4
Ingrese valor (0-100): 75
Deshacer acción? (si/no): si

Acción 2:
Usuario: Camila
Seleccione: 1. Encender luz 2. Abrir puerta 3. Reproducir música 4. Ajustar volumen
2
Deshacer acción? (si/no): no

Acción 3:
Usuario: Andrés
Seleccione: 1. Encender luz 2. Abrir puerta 3. Reproducir música 4. Ajustar volumen
3
Deshacer acción? (si/no): si

Acción 4:
Usuario: Laura
Seleccione: 1. Encender luz 2. Abrir puerta 3. Reproducir música 4. Ajustar volumen
1
Deshacer acción? (si/no): no

Acción ejecutada por Camila: Puerta abierta
Acción ejecutada por Laura: Luz encendida

--- Historial completo ---
1: Ajustar volumen a 75% - Usuario: Andrés (deshecha)
2: Abrir puerta - Usuario: Camila
3: Reproducir música - Usuario: Andrés (deshecha)
4: Encender luz - Usuario: Laura

--- Investigando quién desconfiguró los electrodomésticos ---
Se detecta que Andrés realizó 2 acciones que alteraron la configuración.
Andrés realizó 2 acciónes.
Camila realizó 1 acción.
Laura realizó 1 acción.
```

## Estructura del Proyecto

### Clases Principales
1. **AccionRemota.java** - Interfaz que define el contrato para todas las acciones
2. **AccionAjustarVolumen.java** - Implementación para ajustar volumen con parámetro específico
3. **AccionEncenderLuz.java** - Implementación para encender/apagar luz
4. **AccionAbrirPuerta.java** - Implementación para abrir/cerrar puerta
5. **AccionReproducirMusica.java** - Implementación para reproducir/detener música
6. **HistorialAcciones.java** - Gestor del historial y análisis de acciones
7. **ControlRemotoMagico.java** - Clase principal que orquesta el flujo del programa
8. **Main.java** - Punto de entrada del programa

---

> _Este reto aplica buenas prácticas de programación, principios SOLID y el patrón Command para garantizar un sistema robusto, extensible y fácil de mantener, permitiendo descubrir eficientemente quién desconfiguró los electrodomésticos del hogar._
