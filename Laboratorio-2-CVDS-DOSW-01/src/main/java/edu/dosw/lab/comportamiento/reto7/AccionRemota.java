public interface AccionRemota {
    void ejecutar();
    void deshacer();
    String getDescripcion();
    String getUsuario();
    boolean fueDeshecha();
}
