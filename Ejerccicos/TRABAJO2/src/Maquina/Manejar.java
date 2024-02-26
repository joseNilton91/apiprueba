package Maquina;

public interface Manejar {
    // me sirve para ir delgando responsabilidades
    void setsiguiente(Manejar siguiente);
    // este metodo es para manejar la cantidad solicitada
    void manejarSolicitud(int cantidad);
    
}
