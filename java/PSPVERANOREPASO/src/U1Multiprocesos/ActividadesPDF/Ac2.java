package U1Multiprocesos.ActividadesPDF;

import java.io.IOException;

/**
 * Actividad 2
 * Crea un programa Java que use la clase ProcessBuilder para ejecutar el
 * comando “cmd /C dir” y
 * muestre en la consola lo siguiente:
 * • Las variables de entorno del subproceso.
 * • Los argumentos usados para ejecutar el comando.
 * • La salida estándar del subproceso.
 * 
 */
public class Ac2 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/C", "dir" );
        try {
            Process p = pb.start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
