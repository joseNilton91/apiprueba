package Maquina;

public class DispensarCien extends IManejador {

    @Override
    public void manejarSolicitud(int cantidad) {
        // calcular el nuemro de billetes necesarios.
        int numero = cantidad / 100000;
        if (numero > 0) {
            // Imprime el mensaje de dispensación
            printDispense("100.000", numero);
            //actualiza la cantidad restante
            cantidad = cantidad % 100000;
        }
        // Si la cantidad no es un múltiplo de 100.000, se pasa la solicitud al siguiente
        // manejador de la cadena
        siguiente.manejarSolicitud(cantidad);
    }
}


