package edu.dosw.lab.creacionales.reto3;

public interface AereoFactory {

    MedioTransporte crearAvion(double precio, double velocidad, String descripcion);
    MedioTransporte crearHelicoptero(double precio, double velocidad, String descripcion);
    MedioTransporte crearAvioneta(double precio, double velocidad, String descripcion);
}
