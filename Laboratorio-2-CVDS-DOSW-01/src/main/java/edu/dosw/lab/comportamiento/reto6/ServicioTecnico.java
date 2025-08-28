package edu.dosw.lab.comportamiento.reto6;
import java.util.*;
public class ServicioTecnico {
    public void empezar(){
            Scanner sc = new Scanner(System.in);
            
            Tecnico basico = new TecnicoBasico();
            Tecnico intermedio = new TecnicoIntermedio();
            Tecnico avanzado = new TecnicoAvanzado();   

            basico.siguiente = intermedio;
            intermedio.siguiente = avanzado;

        List<Ticket> tickets = new ArrayList<>();

        System.out.print("Número de tickets: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 1; i <= n; i++) {
            System.out.println("\nTicket " + i + ":");

            System.out.print("Nivel (BASICO, INTERMEDIO, AVANZADO): ");
            String nivelStr = sc.nextLine().toUpperCase();
            Nivel nivel = Nivel.valueOf(nivelStr);

            System.out.print("Prioridad (BAJA, MEDIA, ALTA): ");
            String prioridadStr = sc.nextLine().toUpperCase();
            Prioridad prioridad = Prioridad.valueOf(prioridadStr);

            System.out.print("Descripción: ");
            String descripcion = sc.nextLine();

            tickets.add(new Ticket(i, nivel, prioridad, descripcion));
        }

        for (Ticket t : tickets) {
            basico.resolver(t);
        }
        
        long pendientes = tickets.stream().filter(t -> !t.isResuelto()).count();
        long resueltosBasico = tickets.stream().filter(t -> t.isResuelto() && t.getNivel()==Nivel.BASICO).count();
        long resueltosIntermedio = tickets.stream().filter(t -> t.isResuelto() && t.getNivel()==Nivel.INTERMEDIO).count();
        long resueltosAvanzado = tickets.stream().filter(t -> t.isResuelto() && t.getNivel()==Nivel.AVANZADO).count();
        double promedioPrioridad = tickets.stream()
                                          .filter(Ticket::isResuelto)
                                          .mapToInt(t -> t.getPrioridad().getValor())
                                          .average()
                                          .orElse(0);

                                          
        System.out.println("\n--- Estadísticas ---");
        System.out.println("Tickets resueltos:");
        System.out.println("Básico: " + resueltosBasico);
        System.out.println("Intermedio: " + resueltosIntermedio);
        System.out.println("Avanzado: " + resueltosAvanzado);
        System.out.println("Tickets pendientes: " + pendientes);
        System.out.println("Promedio de prioridad de tickets resueltos: " + promedioPrioridad);

        sc.close();
    }
}