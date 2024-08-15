package Actividades.Tema2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ej7 {
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        // BufferedReader br = new BufferdReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\033[1m> El sistema necesita: \033[0m");
        
        System.out.println("\033[1m\033[31m> m1: \033[0m");
        System.out.print("\033[1m> RESPUESTA: \033[0m");
        double m1 = br.read();
        
        br.read();
        System.out.println("\033[1m\033[31m> m2: \033[0m");
        System.out.print("\033[1m> RESPUESTA: \033[0m");
        // double m2 = sc.nextDouble();
        double m2 = br.read();
        br.read();
        
        
        System.out.print("\033[1m> RESPUESTA: \033[0m");
        System.out.println("\033[1m\033[31m> d: \033[0m");
        // double d = sc.nextDouble();
        double d = br.read();

        double g = (6.673 * Math.pow(10, -11));
        double f = g * (m1 * m2) / Math.pow(d, 2);

        System.out.printf("\033[1m> Respuesta:\033[0m m1 tiene el valor de %.2f, m2 tiene el valor de %.2f, d tiene el valor de %.2f. El resultado de G es %.10e. Por lo que F es %.10e\n", m1, m2, d, g, f);

        // sc.close()
        br.close();

    }
}
