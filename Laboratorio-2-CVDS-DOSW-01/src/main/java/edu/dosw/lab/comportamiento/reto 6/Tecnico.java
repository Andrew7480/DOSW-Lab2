public abstract class Tecnico {
    protected Tecnico siguiente;

    public void setSiguiente(Tecnico siguiente){
        this.siguiente = siguiente;
    }

    public abstract void resolver(Ticket ticket);

}