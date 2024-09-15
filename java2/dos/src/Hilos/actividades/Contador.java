package Hilos.actividades;

// Pattern \p{Alpha}+
/*
 * Contar: lineas, caracteres y palabras de un archvio de txt
 */

import java.util.regex.Pattern;


public class Contador {
    private Pattern pattern = Pattern.compile("\\p{Alpha}+");

    public static void main(String[] args) {
         if (args.length < 2) {
            System.out.println("> Se necesita el modo y el archvio a escanerar.");
         }
    }

}
