package edu.dosw.lab.creacionales.reto3;

public interface CategoriaFactory {
    TierraFactory crearTierraFactory();
    AereoFactory crearAereoFactory();
    AcuaticoFactory crearAcuaticoFactory();
}
