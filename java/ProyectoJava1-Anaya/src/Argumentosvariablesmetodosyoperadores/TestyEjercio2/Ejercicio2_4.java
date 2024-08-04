package Argumentosvariablesmetodosyoperadores.TestyEjercio2;

public class Ejercicio2_4 {
    public static void main(String[] args) {
        String a1 = args[0]; //Apellido 1
        // String a2 = args[1]; //Apellido 2
        String nh1 = args[1]; //nombre hijo 1
        String nh2 = args[2]; //nombre hijo 2
        String nh3 = args[3]; //nombre hijo 3
        String np = args[4]; //nombre padre
        // String nm = args[5]; //nombre madre

        System.out.println("> El sistema ha detectado lo siguiente: ");
        System.out.println("> Padre: " + np +" "+ a1);
        // System.out.println("> Madre: " + nm +" "+ a1);
        System.out.println("> Los hijos: ");
        System.out.println("> Primer hijo: " + nh1 +" "+ a1);
        System.out.println("> Segundo hijo: " + nh2+" "+  a1);
        System.out.println("> Tercer hijo: " + nh3 +" "+ a1 );

    }
}
