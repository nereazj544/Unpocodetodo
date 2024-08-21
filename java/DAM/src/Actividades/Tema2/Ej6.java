package Actividades.Tema2;

import java.util.Scanner;

public class Ej6 {
    public static void main(String[] args) {
        // Area = 3,14 * r^2
        // Perimetro = 2r * pi

        Scanner sc = new Scanner(System.in);

        System.out.println("> El sistema calculara el Area");
        System.out.println("> El sistema necesita el radio del circulo");
        System.out.print("> RESPUESTA: ");
        int radio = sc.nextInt();
        double resultado = Math.pow(radio, 2) * Math.PI;

        // System.out.println(resultado);
        System.out.printf("> Resultado: %.2f", resultado);
        
        System.out.println("\n> El sistema calculara el Perimetro");
        System.out.println("> El sistema necesita el radio del circulo");
        System.out.print("> RESPUESTA: ");
        int rad = sc.nextInt();
        double resultado2 = 2 * rad * Math.PI;
        System.out.printf("> Resultado: %.2f", resultado2);


        sc.close();
    }
}
