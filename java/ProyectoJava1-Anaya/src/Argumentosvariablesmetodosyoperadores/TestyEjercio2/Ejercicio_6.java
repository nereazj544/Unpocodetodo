package Argumentosvariablesmetodosyoperadores.TestyEjercio2;

public class Ejercicio_6 {
    public static void main(String[] args) {
        String apellido = args[0];
        String np = args[1];
        String nh1 = args[2]; //nombre hijo 1
        String nh2 = args[3]; //nombre hijo 2
        String nh3 = args[4]; //nombre hijo 3
        PintarPersona(apellido, nh3);
        PintarPersona(apellido, nh2);
        PintarPersona(apellido, nh1);
        PintarPersona(apellido, np);
    }

    private static void PintarPersona(String apellido, String nombre) {
        System.out.println("> Padre: " + nombre + " " + apellido);
        System.out.println("> Primer hijo: " + nombre +" "+ apellido);
        System.out.println("> Segundo hijo: " + nombre+" "+ apellido);
        System.out.println("> Tercer hijo: " + nombre +" "+ apellido);
    }
}
