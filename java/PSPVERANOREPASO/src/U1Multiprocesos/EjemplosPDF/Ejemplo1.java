package U1Multiprocesos.EjemplosPDF;

import java.io.IOException;

/**
 * Creacion de proceso con Java
 * Abrir notepad
 */
public class Ejemplo1 {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String cmd = "notepad";
        System.out.println("> El sistema abrira: " + cmd);
        Process p;

        try {
            p = r.exec(cmd);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
