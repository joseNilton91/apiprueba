package Maquina;

public class DispensarCincuenta extends IManejador {

    @Override
    public void manejarSolicitud(int cantidad) {
        // calcular el nuemro de billetes necesarios.
        int numero = cantidad / 50000;
        if (numero > 0) {
            // Imprime el mensaje de dispensación
            printDispense("50.000", numero);
            //actualiza la cantidad restante
            cantidad = cantidad % 50000;
        }
        // Si la cantidad no es un múltiplo de 50.000, se pasa la solicitud al siguiente
        // manejador de la cadena
        siguiente.manejarSolicitud(cantidad); 
    }
}

