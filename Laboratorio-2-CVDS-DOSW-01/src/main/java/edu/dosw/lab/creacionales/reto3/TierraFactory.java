package edu.dosw.lab.creacionales.reto3;

public interface TierraFactory {

    MedioTransporte crearAuto(double precio, double velocidad, String descripcion);
    MedioTransporte crearMoto(double precio, double velocidad, String descripcion);
    MedioTransporte crearBicicleta(double precio, double velocidad, String descripcion);
    MedioTransporte crearporMedioTransporte(String tipo);
}
