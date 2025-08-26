public class AccionEncenderLuz implements AccionRemota {
    private final String usuario;
    private boolean deshecha = false;

    public AccionEncenderLuz(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public void ejecutar() {
        System.out.printf("Acción ejecutada por %s: Luz encendida\n", usuario);
    }

    @Override
    public void deshacer() {
        deshecha = true;
        System.out.println("Acción deshecha: Luz apagada");
    }

    @Override
    public String getDescripcion() {
        return "Encender luz";
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
