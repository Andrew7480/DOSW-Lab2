package edu.dosw.lab.creacionales.reto2;

public class Reto2Hamburguesa {
    public static void ejecutar() {
        HamburguesaBuilder builder = new Builder();
        Chef chef = new Chef(builder);
        chef.inicializar();
    }
    
}
