package Argumentosvariablesmetodosyoperadores.TestyEjercio2;

/*
 * Mostrar un mensjae con un argumento variable
 * Escribir un programa que imprima por pantalla el argumento que ha recibido: ("He recibido este argumento: ") seguido del valor de dicho argumento
 */
public class Ejercicio2_1 {
    public static void main(String[] args) {
        String a = args[0];
        String n = args[1];
        int valor = Integer.parseInt(n);
        System.out.println("> He recibido este argumento: "+ a);
        System.out.println("> He recibido este argumento: "+ valor);
        System.out.println("\033[1m> CON FORMTATO\033[0m");
        System.out.printf("> He recibido esta cadena de texto: %s\n", a);
        System.out.printf("> He recibido este numero: %d\n", valor);
    }
}
