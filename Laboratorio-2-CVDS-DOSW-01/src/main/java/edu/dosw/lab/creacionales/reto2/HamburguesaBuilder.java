package edu.dosw.lab.creacionales.reto2;

import java.util.*;

public interface HamburguesaBuilder {
    void reset();
    void agregarIngrediente(Ingrediente i);
    void agregarIngredienteBase(Ingrediente i);
    void agregarIngredientePersonalizado(String nombre, double precio);
    Hamburguesa build();
    List<Ingrediente> getIngredientesSelection();
    List<Ingrediente> getIngredientesBase();
    void seleccionarIngrediente(Ingrediente i);
}