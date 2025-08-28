package edu.dosw.lab.comportamiento.reto6;
public class TecnicoAvanzado extends Tecnico {
    @Override
    public void resolver(Ticket ticket) {
        if (ticket.getNivel() == Nivel.AVANZADO) {

            ticket.setResuelto(true);
            System.out.println("Ticket " + ticket.getId() + ": Técnico Avanzado resolvió el problema.");

        } else {
            System.out.println("Ticket " + ticket.getId() + ": Ningún técnico disponible. Pendiente de escalamiento.");
        }
    }
}
