package Argumentosvariablesmetodosyoperadores;

public class Ejercicio2_agrs {
    public static void main(String[] args) {
        //Pasar de "cadena de texto" a un entero 
        /*
         ! Comprobar si hay datos pasados por agrumentos
         */
        if (args.length == 0) {
            System.out.println("> No has introducido un argumento.");
            System.exit(0);
        }
        String manzanas = args[0];
        int valorM = Integer.parseInt(manzanas);
    }
}
