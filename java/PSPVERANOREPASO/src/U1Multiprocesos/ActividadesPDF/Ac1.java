package U1Multiprocesos.ActividadesPDF;

import java.util.Scanner;

/**
 * * ACTIVIDAD 1
 * Escribe un programa Java que lea 2 números de la entrada estándar y visualice
 * su suma. Si los datos introducidos no son numéricos, muestra el mensaje
 * correspondiente en la salida estándar de error. Crea otro programa Java para
 * ejecutar el anterior y visualizar la salida del mismo
 */

public class Ac1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // try {
            System.out.println("> El sistema necesita un numero: ");
            int n1 = sc.nextInt();

            System.out.println("> El sistema necesita un numero: ");
            int n2 = sc.nextInt();

            int r = n1 + n2;

            System.out.println("> El sistema ha calculado la suma: " + r);
        // } catch (NumberFormatException e) {
        //     System.out.println("> El sistema detecto que no has introducido numeros validos, introduca numeros validos.");
        // }

        sc.close();

    }
}
