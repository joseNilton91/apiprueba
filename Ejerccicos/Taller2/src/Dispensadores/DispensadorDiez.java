package Dispensadores;

public class DispensadorDiez extends Dispensa{

    @Override
    public void dispen(int cantidad) {
     // Verificar si la cantidad es divisible por 10.000
        if (cantidad >= 10000) {
         // Calcular el número de billetes de 10.000 a dispensar
         int numero = cantidad / 10000;
         // Calcular el resto a pasar al siguiente dispensador
         int resto = cantidad % 10000;
         // Imprimir el número de billetes de 10.000 dispensados
         System.out.println("Dispensando " + numero + " billete(s) de 10.000");
         // Si hay resto, pasar al siguiente dispensador
            if (resto != 0) {
             this.siguiente.dispen(resto);
             }
            else {
             // Si la cantidad no es divisible por 10.000, pasar al siguiente dispensador
             this.siguiente.dispen(cantidad);
            }
        }
    }
}