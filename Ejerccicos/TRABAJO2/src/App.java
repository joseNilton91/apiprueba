import Maquina.DispensarCien;
import Maquina.DispensarCinco;
import Maquina.DispensarCincuenta;
import Maquina.DispensarDiez;
import Maquina.DispensarVeinte;
import Maquina.IManejador;

public class App {
    public static void main(String[] args) throws Exception {
        /// creo la cadena de responsabilidades
        IManejador DCien = new DispensarCien();
        IManejador DCincuenta = new DispensarCincuenta();
        IManejador DVeinte = new DispensarVeinte();
        IManejador DDiez = new DispensarDiez();
        IManejador DCinco = new DispensarCinco();

        // establezco el orden de la cadena de responsabilidad
        DCien.setsiguiente(DCincuenta);
        DCincuenta.setsiguiente(DVeinte);
        DVeinte.setsiguiente(DDiez);
        DDiez.setsiguiente(DCinco);

        // Inicia la solicitud con una cantidad válida
        int cantidad = 510000;
        System.out.println("Solicitando " + cantidad + " pesos");
        DCien.manejarSolicitud(cantidad);

        try {
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}