package Argumentosvariablesmetodosyoperadores;

public class Ejercicio2_agrs {
    public static void main(String[] args) {
        // Pasar de "cadena de texto" a un entero
        /*
         * Comprobar si hay datos pasados por agrumentos
         */
        if (args.length == 0) {
            System.out.println("\033[31m> No has introducido un argumento, dicho argumento debe de estar formado por nuemeros enteros.\033[0m");
            System.exit(0);
        }
        String manzanas = args[0];
        String peras = args[1];

        try {
            int valorM = Integer.parseInt(manzanas);
            int valorP = Integer.parseInt(peras);
            
            // System.out.printf("> El numero de las mazanas es: %d", valorM );
            // System.out.printf("> El numero de las peras es: %d", valorP );
            System.out.println("> El sistema a contado que tienes un total de manzas: \033[1m" + valorM + 
            ".\033[0m\n> El sistema a contado que Tienes un total de peras: \033[1m" + valorP + "\033[0m");
            int resultado = valorM + valorP;
            System.out.println("> El sistema a contado que tienes un total de: \033[1m" + resultado + " \033[0mfrutas; entre las peras y las manzanas");

            
        } catch (NumberFormatException e) {
            System.err.println("\033[31m> El sistema ha detectado un error, se pasara a mostrar dicho error: ");
            System.err.println("\033[31m> El sistema detecto que no has introduccio un formato valido.");
            System.err.println("\033[31m> El sistmea a detectado este error: " + e.getLocalizedMessage() + "\033[0m");
        }
    }
}
