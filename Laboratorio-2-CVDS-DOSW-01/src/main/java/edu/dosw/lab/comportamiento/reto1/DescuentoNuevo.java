package edu.dosw.lab.comportamiento.reto1;

public class DescuentoNuevo implements DiscountStrategy {
    public DescuentoNuevo() {
    }
    
    @Override
    public double calcularDescuento(double subTotal) {
        return subTotal * 0.05; 
    }
}