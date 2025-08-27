package edu.dosw.lab.comportamiento.reto7;

public interface AccionRemota {
    void ejecutar();
    void deshacer();
    String getDescripcion();
    String getUsuario();
    boolean fueDeshecha();
}
