package Argumentosvariablesmetodosyoperadores.TestyEjercio2;

import java.util.Scanner;

public class Ejercico2_3_Versionavanzada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("> El sismeta mostrara el menú: ");
        System.out.println("\033[1m** MENÚ ** \033[0m");
        System.out.println("1- Con Args");
        System.out.println("2- Con Scaner");
        System.out.println("3- Ultima forma");

        int opction = sc.nextInt();

        switch (opction) {
            case 1:
                AreaRectanguloAgrs(args);
                break;
            case 2:
                AreaRectanguloScanner(sc);
                break;
            case 3:
                OtraForma(sc);
                break;

            default:
                System.out.println("\033[1m \033[31m> El sistema no ha detado una opcion valida.\033[0m");
                System.exit(0);
                break;
        }
    }

    private static void OtraForma(Scanner sc) {
        sc.nextLine();
        System.out.println("> El sistema necesita la altura: ");
        int altura = sc.nextInt();
        System.out.println("> El sistema necesita la longitud: ");
        int longitud = sc.nextInt();
        CalcularArea(altura, longitud);
        
    }
    
    private static void CalcularArea(int altura, int longitud) {
        int r = altura * longitud;
        System.out.println("> El sistema ha calculado el resultado: "+ r);
    
    }


    public static void AreaRectanguloAgrs(String[] args) {
        if (args.length < 2) {
            System.out.println("\033[1m \033[31m> El sistema no ha detado argumentos validos.\033[0m");
            System.out.println(
                "\033[1m \033[31m> El sistema necesita los siguientes valores: Longitud y Altura del rectangulo.\033[0m");
            }
            
            int longitud = Integer.parseInt(args[0]);
            int altura = Integer.parseInt(args[1]);
            int r = longitud * altura;
            System.out.println("> El sistema ha calculado el area del rectandulo y este es el resultado: " +  r);
            
        }
    
    private static void AreaRectanguloScanner(Scanner sc) {
        sc.nextLine(); // Reseteamos el scanner
        System.out.println("> El sistema necesita la longitud: ");
        int longitud = sc.nextInt();
        System.out.println("> El sistema necesita la altura: ");
        int altura = sc.nextInt();
        int r = longitud * altura;
        System.out.println("> El sistema ha calculado el area del rectandulo y este es el resultado: " +  r);
    }
}
