package EstructurassCondicionales.TestyEjercicios;
/* Ejercicio 3.6: OPERADOR TERNARIO – Calcula el valor absoluto de un float recibido como parámetro.
 */
public class Ej3_6 {
    public static void main(String[] args) {
        float valor = Integer.parseInt(args[0]);
        float abs = valor > 0 ? valor : -valor;
        System.out.println("> El valor absoluto de: " + valor + " es: "+ abs);
    }
}
