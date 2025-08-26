package edu.dosw.lab.creacionales.reto3;

public class EconomicoFactory implements CategoriaFactory {

    @Override
    public TierraFactory crearTierraFactory() {
        return new EconomicoTierraFactory();
    }

    @Override
    public AereoFactory crearAereoFactory() {
        return new EconomicoAereoFactory();
    }

    @Override
    public AcuaticoFactory crearAcuaticoFactory() {
        return new EconomicoAcuaticoFactory();
    }

}
