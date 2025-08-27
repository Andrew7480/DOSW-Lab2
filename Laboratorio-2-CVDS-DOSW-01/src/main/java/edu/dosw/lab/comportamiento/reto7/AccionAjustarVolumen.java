package edu.dosw.lab.comportamiento.reto7;

public class AccionAjustarVolumen implements AccionRemota {
    private final String usuario;
    private final int volumen;
    private boolean deshecha = false;

    public AccionAjustarVolumen(String usuario, int volumen) {
        this.usuario = usuario;
        this.volumen = volumen;
    }

    @Override
    public void ejecutar() {
        System.out.printf("Acción ejecutada por %s: Volumen ajustado a %d%%\n", usuario, volumen);
    }

    @Override
    public void deshacer() {
        deshecha = true;
        System.out.println("Acción deshecha: Volumen regresado a 0%");
    }

    @Override
    public String getDescripcion() {
        return String.format("Ajustar volumen a %d%%", volumen);
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
