public class AccionAbrirPuerta implements AccionRemota {
    private final String usuario;
    private boolean deshecha = false;

    public AccionAbrirPuerta(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public void ejecutar() {
        System.out.printf("Acción ejecutada por %s: Puerta abierta\n", usuario);
    }

    @Override
    public void deshacer() {
        deshecha = true;
        System.out.println("Acción deshecha: Puerta cerrada");
    }

    @Override
    public String getDescripcion() {
        return "Abrir puerta";
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
