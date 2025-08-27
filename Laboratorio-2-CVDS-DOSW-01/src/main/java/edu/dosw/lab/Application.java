package edu.dosw.lab;

import org.springframework.core.retry.RetryOperations;

import edu.dosw.lab.comportamiento.reto1.Reto1TiendaDonPepe;
import edu.dosw.lab.creacionales.reto2.Reto2Hamburguesa;
import edu.dosw.lab.creacionales.reto3.Reto3Concesionaria;

public class Application {
    public static void main(String[] args) {
        System.out.println("Proyecto Maven configurado y corriendo correctamente");
        Reto1TiendaDonPepe.ejecutar();
        Reto2Hamburguesa.ejecutar();
        Reto3Concesionaria.ejecutar();
    }
}
