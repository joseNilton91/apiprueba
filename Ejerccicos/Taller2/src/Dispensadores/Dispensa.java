package Dispensadores;

public abstract class Dispensa {
    protected Dispensa siguiente;

   // metodo que va a recibir la cantidad que se va a dispensar
    public abstract void  dispen(int cantidad);

    // metodo que me permite establecer el siguente valor u objeto en la cadena
    public void setSiguiente(Dispensa siguiente){
        this.siguiente = siguiente;
    }

    
} 
