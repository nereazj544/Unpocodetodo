package U1Multiprocesos.EjemplosPDF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Creacion de proceso con Java
 * Mostrar contenido por consola
 */

public class Ejemplo2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime r = Runtime.getRuntime();

        // ? Solo funciona con C
        Process p = r.exec("cmd /C dir c:\\");

        InputStream is = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String linea;

        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }
        br.close();
        System.out.println("> El sistema pasara a mostrar el resultado del codigo: " + p.waitFor());
    }
}
