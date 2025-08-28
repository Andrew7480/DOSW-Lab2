package edu.dosw.lab.comportamiento.reto6;
public class TecnicoIntermedio extends Tecnico {
     @Override
    public void resolver(Ticket ticket) {
        if (ticket.getNivel() == Nivel.INTERMEDIO 
            && (ticket.getPrioridad() == Prioridad.BAJA || ticket.getPrioridad() == Prioridad.MEDIA)) {

            ticket.setResuelto(true);
            System.out.println("Ticket " + ticket.getId() + ": Técnico Intermedio resolvió el problema.");

        } else if (siguiente != null) {
            siguiente.resolver(ticket);
        } else {
            System.out.println("Ticket " + ticket.getId() + ": Ningún técnico disponible. Pendiente de escalamiento.");
        }
    }
}
