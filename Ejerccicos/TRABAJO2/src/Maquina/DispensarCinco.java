package Maquina;

public class DispensarCinco extends IManejador {

    @Override
    public void manejarSolicitud(int cantidad) {
        // Calcula el número de billetes de 5.000 necesarios
        int numero = cantidad / 5000; 
        if (numero > 0) {
            // Imprime el mensaje de dispensación
            printDispense("5.000", numero); 
            // Actualiza la cantidad restante
            cantidad = cantidad % 5000; // Actualiza la cantidad restante
        }
        if (cantidad > 0) {
             // Si la cantidad no es un múltiplo de 5.000, arroja un error
            throw new IllegalArgumentException("La cantidad debe ser un múltiplo de 5.000");
        }
    }
}