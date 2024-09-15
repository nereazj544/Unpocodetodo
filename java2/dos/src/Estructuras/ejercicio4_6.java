package Estructuras;

import java.util.Scanner;

public class ejercicio4_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("> El sisemtna muestra: \033[1m Adivinar la palabra oculta \033[0m ");

        System.out.print("> RESPUESTA: ");
        String palabra = sc.nextLine();

        System.out.printf("> El sistema ha detectado: \033[1m %s \033[0m, parasara a analizar si es la palabra oculta", palabra);
        System.out.println("\n");

        AnalizarPalabraOculta(palabra, sc);


        
    }

    private static void AnalizarPalabraOculta(String palabra, Scanner sc) {
        String palabraOculta = "Shawn";

        do {
            if(!palabra.equals(palabraOculta)){
                System.out.println("> El sistema ha detectado que tu palabra no es la palabra oculta, deberas de serguir intentandolo");
                System.out.println("> Nueva palabra: ");
                palabra = sc.nextLine();
            } else{
                System.out.println("> El sistema ha detectado que tu palabra es: " + palabraOculta + ". has gando.");
                break;
            }
        } while (true);
    }
}
