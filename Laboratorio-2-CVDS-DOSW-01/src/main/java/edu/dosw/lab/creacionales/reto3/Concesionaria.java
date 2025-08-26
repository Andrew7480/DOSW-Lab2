package edu.dosw.lab.creacionales.reto3;

import java.util.*;

public class Concesionaria {
    private List<MedioTransporte> vehiculos;

    public Concesionaria() {
        this.vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(MedioTransporte vehiculo) {
        vehiculos.add(vehiculo);
    }

    public List<MedioTransporte> obtenerVehiculos() {
        return vehiculos;
    }
}
