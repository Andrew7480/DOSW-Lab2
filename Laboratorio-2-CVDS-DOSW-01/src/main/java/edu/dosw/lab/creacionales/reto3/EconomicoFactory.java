package edu.dosw.lab.creacionales.reto3;

import java.util.*;

public class EconomicoFactory implements CategoriaFactory {
    private List<String> tipos;
    private Map<String, List<String>> modelosPorTipo;

    public EconomicoFactory() {
        this.tipos = List.of("Tierra", "Aereo", "Acuatico");
        modelosPorTipo = new HashMap<>();
        modelosPorTipo.put("Tierra", List.of("Auto", "Bicicleta", "Moto"));
        modelosPorTipo.put("Aereo", List.of("Avion", "Helicoptero", "Avioneta"));
        modelosPorTipo.put("Acuatico", List.of("Lancha", "Velero", "Jetski"));
    }

    public TierraFactory crearTierraFactory() {
        return new TierraFactory() {
            @Override
            public MedioTransporte crearAuto(double precio, double velocidad, String descripcion) {
                return new Auto(precio, velocidad, descripcion);
            }
            @Override
            public MedioTransporte crearMoto(double precio, double velocidad, String descripcion) {
                return new Moto(precio, velocidad, descripcion);
            }
            @Override
            public MedioTransporte crearBicicleta(double precio, double velocidad, String descripcion) {
                return new Bicicleta(precio, velocidad, descripcion);
            }
            @Override
            public MedioTransporte crearporMedioTransporte(String tipo) {
                switch (tipo) {
                    case "Auto":
                        return crearAuto(0, 0, null);
                    case "Moto":
                        return crearMoto(0, 0, null);
                    case "Bicicleta":
                        return crearBicicleta(0, 0, null);
                    default:
                        throw new IllegalArgumentException("Tipo de vehículo no reconocido: " + tipo);
                }
            }
        };
    }

    public AereoFactory crearAereoFactory() {
        return new AereoFactory() {
            @Override
            public MedioTransporte crearAvion(double precio, double velocidad, String descripcion) {
                return new Avion(precio, velocidad, descripcion);
            }
            @Override
            public MedioTransporte crearHelicoptero(double precio, double velocidad, String descripcion) {
                return new Helicoptero(precio, velocidad, descripcion);
            }
            @Override
            public MedioTransporte crearAvioneta(double precio, double velocidad, String descripcion) {
                return new Avioneta(precio, velocidad, descripcion);
            }
            @Override
            public MedioTransporte crearporMedioTransporte(String tipo) {
                switch (tipo) {
                    case "Avion":
                        return crearAvion(0, 0, null);
                    case "Helicoptero":
                        return crearHelicoptero(0, 0, null);
                    case "Avioneta":
                        return crearAvioneta(0, 0, null);
                    default:
                        throw new IllegalArgumentException("Tipo de vehículo no reconocido: " + tipo);
                }
            }
        };
    }

    public AcuaticoFactory crearAcuaticoFactory() {
        return new AcuaticoFactory() {
            public MedioTransporte crearLancha(double precio, double velocidad, String descripcion) {
                return new Lancha(precio, velocidad, descripcion);
            }
            public MedioTransporte crearVelero(double precio, double velocidad, String descripcion) {
                return new Velero(precio, velocidad, descripcion);
            }
            public MedioTransporte crearJetSki(double precio, double velocidad, String descripcion) {
                return new JetSki(precio, velocidad, descripcion);
            }
            @Override
            public MedioTransporte crearporMedioTransporte(String tipo) {
                switch (tipo) {
                    case "Lancha":
                        return crearLancha(0, 0, null);
                    case "Velero":
                        return crearVelero(0, 0, null);
                    case "Jetski":
                        return crearJetSki(0, 0, null);
                    default:
                        throw new IllegalArgumentException("Tipo de vehículo no reconocido: " + tipo);
                }
            }
        };
    }

    @Override
    public List<String> tipos() {
        return tipos;
    }

    @Override
    public List<String> modelos(String tipo) {
        return modelosPorTipo.getOrDefault(tipo, Collections.emptyList());
    }

    @Override
    public MedioTransporte crearPorFactory(String tipo, String modelo) {
        switch (tipo){
            case "Tierra":
                return crearTierraFactory().crearporMedioTransporte(modelo);
            case "Aereo":
                return crearAereoFactory().crearporMedioTransporte(modelo);
            case "Acuatico":
                return crearAcuaticoFactory().crearporMedioTransporte(modelo);
            default:
                throw new IllegalArgumentException("Tipo de vehículo no reconocido: " + tipo);
        }
    }
}
