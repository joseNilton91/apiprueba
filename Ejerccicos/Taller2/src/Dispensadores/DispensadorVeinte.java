package Dispensadores;

public class DispensadorVeinte extends Dispensa {

    @Override
   public void dispen(int cantidad) {
    // Verificar si la cantidad es divisible por 20.000
        if(cantidad >= 20000){
         // Calcular el número de billetes de 20.000 a dispensar
         int numero = cantidad / 20000;
         // Calcular el resto a pasar al siguiente dispensador
         int resto = cantidad % 20000;
         // Imprimir el número de billetes de 20.000 dispensados
         System.out.println("Dispensando " + numero + " billete(s) de 20.000");
         // Si hay resto, pasar al siguiente dispensador
            if (resto != 0) {
             this.siguiente.dispen(resto);
            }
             else {
             // Si la cantidad no es divisible por 20.000, pasar al siguiente dispensador
             this.siguiente.dispen(cantidad);
            }
        }
    }
}