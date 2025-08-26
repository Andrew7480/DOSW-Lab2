import java.util.Scanner;

public class ControlRemotoMagico {
    private final HistorialAcciones historial;
    private final Scanner scanner;

    public ControlRemotoMagico() {
        this.historial = new HistorialAcciones();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.print("Número de acciones a registrar: ");
        int numeroAcciones = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        for (int i = 1; i <= numeroAcciones; i++) {
            System.out.println("\nAcción " + i + ":");
            registrarAccion();
        }
        
        // Ejecutar y procesar todas las acciones
        ejecutarYProcesarAcciones();
        
        // Mostrar historial y resumen final
        historial.mostrarHistorialCompleto();
        historial.mostrarResumenFinal();
    }

    private void registrarAccion() {
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine().trim();
        
        System.out.print("Seleccione: 1. Encender luz 2. Abrir puerta 3. Reproducir música 4. Ajustar volumen\n");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        AccionRemota accion = crearAccion(opcion, usuario);
        historial.registrarAccion(accion);
        
        System.out.print("Deshacer acción? (si/no): ");
        String respuesta = scanner.nextLine().trim().toLowerCase();
        
        if (respuesta.equals("si")) {
            accion.deshacer();
        }
    }

    private AccionRemota crearAccion(int opcion, String usuario) {
        switch (opcion) {
            case 1:
                return new AccionEncenderLuz(usuario);
            case 2:
                return new AccionAbrirPuerta(usuario);
            case 3:
                return new AccionReproducirMusica(usuario);
            case 4:
                System.out.print("Ingrese valor (0-100): ");
                int volumen = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                return new AccionAjustarVolumen(usuario, volumen);
            default:
                throw new IllegalArgumentException("Opción de acción no válida: " + opcion);
        }
    }

    private void ejecutarYProcesarAcciones() {
        System.out.println();
        
        // Ejecutar acciones no deshhechas durante el registro
        for (int i = 1; i <= historial.obtenerTamaño(); i++) {
            AccionRemota accion = historial.obtenerAccion(i);
            if (accion != null && !accion.fueDeshecha()) {
                accion.ejecutar();
                
                // Deshacer inmediatamente después de ejecutar si es volumen o música
                if (accion instanceof AccionAjustarVolumen || accion instanceof AccionReproducirMusica) {
                    accion.deshacer();
                }
            }
        }
    }

}
