package Maquina;

public abstract class IManejador implements Manejar {

    protected Manejar siguiente;

    @Override
    public void setsiguiente(Manejar siguiente) {

        this.siguiente = siguiente;

    }

    @Override
    public void manejarSolicitud(int cantidad) {
        if (siguiente != null) {
            // si existe un siguiente manejador le delega la solicitud
            siguiente.manejarSolicitud(cantidad);

        }

    }

    // Un método auxiliar para imprimir el mensaje de dispensación
    protected void printDispense(String type, int numero) {
        System.out.println("Dispensando " + numero + " billete(s) de " + type);
    }
}
