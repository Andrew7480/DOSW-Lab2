package edu.dosw.lab.comportamiento.reto1;

public class DescuentoFrecuente implements DiscountStrategy {
    
    public DescuentoFrecuente() {
    }

    @Override
    public double calcularDescuento(double subTotal) {
        return subTotal * 0.10; 
    }
}