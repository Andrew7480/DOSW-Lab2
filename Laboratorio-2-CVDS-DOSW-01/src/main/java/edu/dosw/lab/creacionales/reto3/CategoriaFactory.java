package edu.dosw.lab.creacionales.reto3;

import java.util.List;

public interface CategoriaFactory {

    List<String> tipos();
    List<String> modelos(String tipo);
    MedioTransporte crearPorFactory(String tipo, String modelo);
    TierraFactory crearTierraFactory();
    AereoFactory crearAereoFactory();
    AcuaticoFactory crearAcuaticoFactory();
}
