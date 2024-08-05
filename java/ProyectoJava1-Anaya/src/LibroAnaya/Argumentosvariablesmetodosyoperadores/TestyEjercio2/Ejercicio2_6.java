package Argumentosvariablesmetodosyoperadores.TestyEjercio2;

public class Ejercicio2_6 {
    public static void main(String[] args) {
        String apellido = args[0];
        String np = args[1];
        String nh1 = args[2]; //nombre hijo 1
        String nh2 = args[3]; //nombre hijo 2
        String nh3 = args[4]; //nombre hijo 3
        System.out.println("\033[1mFAMILIA: " + apellido + "\033[0m");
        PintarPersona(apellido, nh3);
        PintarPersona(apellido, nh2);
        PintarPersona(apellido, nh1);
        PintarPersona(apellido, np);
    }

    protected static void PintarPersona(String apellido, String nombre) {
        System.out.println( "Nombre: \033[1m " + nombre + " \033[0m " + "Apellido: \033[1m "+ apellido + "\033[0m");
        
    }
}
