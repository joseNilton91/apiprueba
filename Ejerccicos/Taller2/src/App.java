import Dispensadores.DispensadorCien;
import Dispensadores.DispensadorCinco;
import Dispensadores.DispensadorCincuenta;
import Dispensadores.DispensadorDiez;
import Dispensadores.DispensadorVeinte;

public class App {
        public static void main(String[] args) {
            // Creamos los objetos de la cadena
            DispensadorCien D1 = new DispensadorCien();
            DispensadorCincuenta D2 = new DispensadorCincuenta();
            DispensadorVeinte D3= new DispensadorVeinte();
            DispensadorDiez D4 = new DispensadorDiez();
            DispensadorCinco D5 = new DispensadorCinco();

    
            // Los enlazamos entre sí
            D1.setSiguiente(D2);
            D2.setSiguiente(D3);
            D3.setSiguiente(D4);
            D4.setSiguiente(D5);
    try {
            System.out.println("Dispensando 400.000");
            D1.dispen(235000);
            System.out.println("Dispensando 120.000");
            D1.dispen(120000);
            System.out.println("Dispensando 17.500");
            D1.dispen(17500);
            System.out.println("Dispensando 12.300");
            D1.dispen(12300);
             // Esto debe lanzar una excepción
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
