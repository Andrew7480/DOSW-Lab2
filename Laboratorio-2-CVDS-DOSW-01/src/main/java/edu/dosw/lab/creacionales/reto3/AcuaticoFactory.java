package edu.dosw.lab.creacionales.reto3;

public interface AcuaticoFactory {
    MedioTransporte crearLancha(double precio, double velocidad, String descripcion);
    MedioTransporte crearJetSki(double precio, double velocidad, String descripcion);
    MedioTransporte crearVelero(double precio, double velocidad, String descripcion);
    MedioTransporte crearporMedioTransporte(String tipo);
} 