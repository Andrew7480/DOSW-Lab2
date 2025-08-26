package edu.dosw.lab.creacionales.reto2;

import java.util.*;

public class Builder implements HamburguesaBuilder {
    private List<Ingrediente> ingredientesTemp;
    private List<Ingrediente> ingredientesBase;

    public Builder() {
        reset();
        ingredientesBase = new ArrayList<>();
        Ingrediente Pan = new Ingrediente("Pan", 3000);
        Ingrediente Carne = new Ingrediente("Carne", 10000);
        Ingrediente Queso = new Ingrediente("Queso", 5000);
        Ingrediente Lechuga = new Ingrediente("Lechuga", 2000);
        Ingrediente Tomate = new Ingrediente("Tomate", 2000);
        Ingrediente SalsaEspecial = new Ingrediente("Salsa especial", 3000);

        agregarIngredienteBase(Pan);
        agregarIngredienteBase(Carne);
        agregarIngredienteBase(Queso);
        agregarIngredienteBase(Lechuga);
        agregarIngredienteBase(Tomate);
        agregarIngredienteBase(SalsaEspecial);
    }

    @Override
    public void reset() {
        ingredientesTemp = new ArrayList<>();
    }

    @Override
    public void agregarIngrediente(Ingrediente i) {
        ingredientesTemp.add(i);
    }
    public void agregarIngredienteBase(Ingrediente i) {
        ingredientesBase.add(i);
    }

    @Override
    public void agregarIngredientePersonalizado(String nombre, double precio) {
        ingredientesTemp.add(new Ingrediente(nombre, precio));
    }

    @Override
    public Hamburguesa build() {
        Hamburguesa h = new Hamburguesa(ingredientesTemp);
        reset();
        return h;
    }

    @Override
    public List<Ingrediente> getIngredientesSelection() {
        return ingredientesTemp;
    }

    @Override
    public void seleccionarIngrediente(Ingrediente ingrediente) {
        agregarIngrediente(ingrediente);
    }

    @Override
    public List<Ingrediente> getIngredientesBase() {
        return ingredientesBase;
    }
}