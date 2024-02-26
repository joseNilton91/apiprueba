package Maquina;

public class DispensarVeinte extends IManejador {

    @Override
    public void manejarSolicitud(int cantidad) {
       // calcular el nuemero de billetes necesarios.
        int numero = cantidad / 20000;
        if (numero > 0) {
            // Imprime el mensaje de dispensación
            printDispense("20.000", numero);
            //actualiza la cantidad restante
            cantidad = cantidad % 20000;
        }
        // Si la cantidad no es un múltiplo de 20.000, se pasa la solicitud al siguiente
        // manejador de la cadena
        siguiente.manejarSolicitud(cantidad); 
        
    }
}

