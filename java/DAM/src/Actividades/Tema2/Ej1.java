package Actividades.Tema2;

import java.util.Scanner;

/*
 * Escribir y ejecutar un programa que  imprima  el  nombre,  edad y dirección del alumno.
 */
public class Ej1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("> El sistema necesita lo siguiente: ");

        System.out.println("\033[1m> NOMBRE \033[0m");
        System.out.print("> RESPUESTA: ");
        String n = sc.nextLine();

        System.out.println("\033[1m> EDAD\033[0m");
        System.out.print("> RESPUESTA: ");
        int e = sc.nextInt();
        sc.nextLine();
        System.out.println("\033[1m> DIRECCION \033[0m");
        System.out.print("> RESPUESTA: ");
        String d = sc.nextLine();

        System.out.println(
                "> El sistema ha detectado que tu nombre es: " + n + ", tu edad es: " + e + " y tu direccion es: " + d);

        sc.close();
    }

}
