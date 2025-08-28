package edu.dosw.lab.comportamiento.reto6;
public class TecnicoBasico extends Tecnico {
    @Override
    public void resolver(Ticket ticket) {
        if (ticket.getNivel() == Nivel.BASICO 
            && ticket.getPrioridad() == Prioridad.BAJA) {

            ticket.setResuelto(true);
            System.out.println("Ticket " + ticket.getId() + ": Técnico Básico resolvió el problema.");

        } else if (siguiente != null) {
            siguiente.resolver(ticket);
        } else {
            System.out.println("Ticket " + ticket.getId() + ": Ningún técnico disponible. Pendiente de escalamiento.");
        }
    }

}
