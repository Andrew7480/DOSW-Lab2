package edu.dosw.lab.comportamiento.reto7;

import java.util.ArrayList;
import java.util.List;

public class HistorialAcciones {
    private final List<AccionRemota> acciones;

    public HistorialAcciones() {
        this.acciones = new ArrayList<>();
    }

    public void registrarAccion(AccionRemota accion) {
        acciones.add(accion);
    }

    public AccionRemota obtenerAccion(int indice) {
        if (indice >= 1 && indice <= acciones.size()) {
            return acciones.get(indice - 1);
        }
        return null;
    }

    public void mostrarHistorialCompleto() {
        System.out.println("\n--- Historial completo ---");
        for (int i = 0; i < acciones.size(); i++) {
            AccionRemota accion = acciones.get(i);
            String estado = accion.fueDeshecha() ? " (deshecha)" : "";
            System.out.printf("%d: %s - Usuario: %s%s\n", 
                i + 1, accion.getDescripcion(), accion.getUsuario(), estado);
        }
    }

    public void mostrarResumenFinal() {
        System.out.println("\n--- Investigando quién desconfiguró los electrodomésticos ---");
        
        // Mostrar quién realizó acciones que desconfiguran (acciones deshhechas)
        String usuarioConMasDesconfigurados = encontrarUsuarioConMasAccionesDeshechas();
        if (usuarioConMasDesconfigurados != null) {
            int accionesDeshechas = contarAccionesDeshechas(usuarioConMasDesconfigurados);
            System.out.println("Se detecta que " + usuarioConMasDesconfigurados + 
                " realizó " + accionesDeshechas + 
                " acciones que alteraron la configuración.");
        }

        // Mostrar estadísticas por usuario
        mostrarEstadisticasPorUsuario();
    }

    private String encontrarUsuarioConMasAccionesDeshechas() {
        String usuarioConMas = null;
        int maxDeshechas = 0;
        
        List<String> usuariosUnicos = obtenerUsuariosUnicos();
        for (String usuario : usuariosUnicos) {
            int deshechas = contarAccionesDeshechas(usuario);
            if (deshechas > maxDeshechas) {
                maxDeshechas = deshechas;
                usuarioConMas = usuario;
            }
        }
        
        return maxDeshechas > 0 ? usuarioConMas : null;
    }

    private int contarAccionesDeshechas(String usuario) {
        int contador = 0;
        for (AccionRemota accion : acciones) {
            if (accion.getUsuario().equals(usuario) && accion.fueDeshecha()) {
                contador++;
            }
        }
        return contador;
    }

    private void mostrarEstadisticasPorUsuario() {
        List<String> usuariosUnicos = obtenerUsuariosUnicos();
        
        for (String usuario : usuariosUnicos) {
            int totalAcciones = contarAccionesTotales(usuario);
            System.out.printf("%s realizó %d acción%s.\n", 
                usuario, totalAcciones, totalAcciones == 1 ? "" : "es");
        }
    }

    private List<String> obtenerUsuariosUnicos() {
        List<String> usuarios = new ArrayList<>();
        for (AccionRemota accion : acciones) {
            if (!usuarios.contains(accion.getUsuario())) {
                usuarios.add(accion.getUsuario());
            }
        }
        return usuarios;
    }

    private int contarAccionesTotales(String usuario) {
        int contador = 0;
        for (AccionRemota accion : acciones) {
            if (accion.getUsuario().equals(usuario)) {
                contador++;
            }
        }
        return contador;
    }

    public int obtenerTamaño() {
        return acciones.size();
    }
}
