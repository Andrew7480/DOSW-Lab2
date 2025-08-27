package edu.dosw.lab.comportamiento.reto7;

public class AccionReproducirMusica implements AccionRemota {
    private final String usuario;
    private boolean deshecha = false;

    public AccionReproducirMusica(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public void ejecutar() {
        System.out.printf("Acción ejecutada por %s: Música reproducida\n", usuario);
    }

    @Override
    public void deshacer() {
        deshecha = true;
        System.out.println("Acción deshecha: Música detenida");
    }

    @Override
    public String getDescripcion() {
        return "Reproducir música";
    }

    @Override
    public String getUsuario() {
        return usuario;
    }

    @Override
    public boolean fueDeshecha() {
        return deshecha;
    }
}
