"# DOSW-Lab2" 
# Preguntas iniciales

---

## 1. ¿Qué ventaja ofrece el polimorfismo en el diseño de clases frente al uso de múltiples condicionales para determinar el comportamiento de un objeto?

El polimorfismo permite que diferentes clases compartan una misma interfaz, pero que cada una tenga su propia implementación. Esto hace que no sea necesario usar varios `if` o `switch` para saber qué comportamiento ejecutar.

**Ventajas:**
- Permite que el sistema sea más escalable.
- El código es más fácil de leer y mantener.
- Cada clase maneja su propio comportamiento.

**Ejemplo:**

```java
// Sin polimorfismo
if (animal.tipo.equals("Perro")) {
    animal.ladrar();
} else if (animal.tipo.equals("Gato")) {
    animal.maullar();
}

// Con polimorfismo
animal.hacerSonido(); // Cada clase implementa su propia versión
```

---

## 2. ¿Por qué una clase inmutable puede mejorar la seguridad?

Una clase inmutable es aquella que no permite modificar su estado después de ser creada. Esto mejora la seguridad, sobre todo cuando hay varios hilos ejecutándose al mismo tiempo.

**Beneficios:**
- Evita problemas de concurrencia.
- El estado del objeto siempre es predecible.
- Se reduce la probabilidad de errores.

**Ejemplo:**

```java
public final class Persona {
    private final String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
```

---

## 3. ¿Qué problema podría aparecer si los atributos de las clases se mantienen públicos en lugar de privados con getters y setters controlados?

Si dejamos los atributos públicos, cualquiera puede cambiar su valor sin control y eso puede generar inconsistencias.

**Problemas:**
- No se pueden validar los datos.
- Es más fácil que se corrompa la información.
- Hace que el mantenimiento sea más complicado.

**Solución:**

```java
private int edad;

public void setEdad(int edad) {
    if (edad >= 0) {
        this.edad = edad;
    }
}
```

---

## 4. Según el principio de **Abierto/Cerrado**, ¿cómo deberíamos modificar el sistema si queremos añadir una nueva funcionalidad sin alterar el código existente?

El principio dice que las clases deben estar "abiertas" para extender su funcionalidad pero "cerradas" para modificar el código que ya existe. 

La idea es crear nuevas clases o implementar interfaces en lugar de cambiar las clases que ya están funcionando.

**Ejemplo:**

```java
interface Calculadora {
    double calcular(double valor);
}

class ImpuestoColombia implements Calculadora {
    public double calcular(double valor) {
        return valor * 0.19;
    }
}
```

---

## 5. ¿Por qué es importante que una clase cumpla con el **Principio de Única Responsabilidad** y qué ejemplo sencillo podrías dar donde se vulnere?

Una clase debería hacer solo una cosa, así es más fácil de entender y mantener.

**Importancia:**
- El código es más fácil de probar.
- Se reduce la dependencia entre clases.
- Si hay un cambio, afecta menos partes del sistema.

**Ejemplo de violación:**

```java
class Reporte {
    void generarPDF() { ... }
    void enviarCorreo() { ... } // Esto es otra responsabilidad
}
```

**Solución:**
Separar en dos clases:
- `GeneradorPDF`
- `CorreoService`

---

## 6. ¿Qué es y por qué usamos el `pom.xml`?

El archivo **`pom.xml`** es el corazón de un proyecto Maven. Ahí se definen las dependencias, configuraciones y plugins que necesita el proyecto para compilarse y ejecutarse correctamente.

**Ventajas:**
- Automatiza la gestión de dependencias.
- Ayuda en la integración continua.
- Estandariza la estructura del proyecto.

---

## 7. ¿Qué diferencia hay entre `mvn compile`, `mvn package` y `mvn install`?

| **Comando**      | **Función principal**                 | **Salida generada** | **Ubicación** |
|-------------------|-------------------------------------|----------------------|---------------|
| `mvn compile`     | Compila el código fuente             | Archivos `.class`    | `target/`     |
| `mvn package`     | Crea el archivo ejecutable          | `.jar` o `.war`      | `target/`     |
| `mvn install`     | Instala el paquete en el repositorio local | `.jar` o `.war` | `.m2/repository/` |

**Ejemplo en consola:**

```bash
mvn compile
mvn package
mvn install
```

---

## 8. ¿Qué diferencia existe entre una **interfaz** y una **clase abstracta**?

- Una **interfaz** define qué métodos deben implementarse, pero no dice cómo.
- Una **clase abstracta** puede tener métodos implementados y también métodos abstractos. Sirve como base para otras clases.

**Ejemplo:**

```java
interface Vehiculo {
    void acelerar();
}

abstract class Auto implements Vehiculo {
    int velocidad;

    public void frenar() {
        velocidad = 0;
    }
}
```
**Referencias**

- Sierra, K., & Bates, B. (2005). Head First Java (2nd ed.). O'Reilly Media.
- OpenAI, comunicación personal, 21 de agosto de 2025
