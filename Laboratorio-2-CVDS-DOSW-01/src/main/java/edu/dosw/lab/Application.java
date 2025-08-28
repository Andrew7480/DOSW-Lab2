package edu.dosw.lab;

import org.springframework.core.retry.RetryOperations;
import edu.dosw.lab.comportamiento.reto1.Reto1TiendaDonPepe;
import edu.dosw.lab.comportamiento.reto6.Reto6Ticket;
import edu.dosw.lab.creacionales.reto2.Reto2Hamburguesa;
import edu.dosw.lab.creacionales.reto3.Reto3Concesionaria;
import edu.dosw.lab.creacionales.reto4.Reto4CasaCambio;
import edu.dosw.lab.solid.reto5.Reto5Cafe;
import edu.dosw.lab.comportamiento.reto7.Reto7ControlMagico;

public class Application {
    public static void main(String[] args) {
        System.out.println("Proyecto Maven configurado y corriendo correctamente");
        Reto1TiendaDonPepe.ejecutar();
        Reto2Hamburguesa.ejecutar();
        Reto3Concesionaria.ejecutar();
        Reto4CasaCambio.ejecutar();
        Reto5Cafe.ejecutar();
        Reto6Ticket.ejecutar();
        Reto7ControlMagico.ejecutar();
    }
}
