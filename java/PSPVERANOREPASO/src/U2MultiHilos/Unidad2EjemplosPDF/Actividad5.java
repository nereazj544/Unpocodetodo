package U2multihilos.Unidad2EjemplosPDF;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/* 
* Activad 5
 * Crea un programa que reciba a través de la línea de comandos los parámetros siguientes:
• Una ruta a una carpeta que contenga varios ficheros de texto.
• A continuación, un indicador que admitirá únicamente dos valores: S o C.
El objetivo del programa es contar cuántas líneas, palabras y caracteres contiene cada fichero de texto. El indicador 
determinará si esto se hará procesando los ficheros de forma secuencial (indicador S) en el hilo principal, o 
concurrentemente usando un hilo para cada fichero (indicador C).
En cualquier caso, el programa medirá el tiempo total de proceso de todos los ficheros y finalizará mostrando todos 
los datos obtenidos en la salida estándar.
Haz una prueba de procesamiento secuencial y otra de procesamiento concurrente usando los mismos ficheros de 
texto en ambos casos. Una vez que tengas los resultados, comparte con el resto de la clase tus datos y conclusiones 
acerca del rendimiento obtenido en ambos casos
 */

public class Actividad5 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println(
                    "> El sistema no ha detectado dos parametros de entrada: Ruta del arcivo y modo 'S' o 'C'");
            System.exit(0);
        }
        System.out.println("> El sistema puede continuar ya que ha detectado parametros.");

        String path = args[0]; // Path for file txt (Ruta del archivo txt)
        String mood = args[1].toUpperCase(); // Mood S or C (Modo S o C)

        if (!mood.equals("S") && !mood.equals("C")) {
            System.out.println("> El sistema detectodo que Modo no es ni S o C");
        }

        File folder = new File(path);
        if (!folder.isDirectory()) {
            System.out.println("> El sistema ha detectado que la carpeta no es valida");
        }

        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));
        if (files == null || files.length == 0) {
            System.out.println("> El sistema no ha encontrado ficheros de textos");
        }

        long timeStar = System.currentTimeMillis();

        if (mood.equals("S")) {
            Secuencial(files);
        } else {
            Concurrente(files);
        }

        long timeEnd = System.currentTimeMillis();
        System.out.println("> El sitema calcualo el tiempo de proceso: " + (timeEnd - timeStar) + " ms");
    }

    private static void Secuencial(File[] files) {
        for (File file : files) {
            Files(file);
        }
    }

    private static void Files(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int word = 0; // palabras
            int character = 0; // caracteres
            int line = 0; // lineas
            String Line;
            while ((Line = br.readLine()) != null) {
                line++;
                character += Line.length();
                word += countWord(Line);
            }
            System.out.printf("Fichero: %s, Líneas: %d, Palabras: %d, Caracteres: %d%n",
                    file.getName(), line, word, character);

        } catch (Exception e) {
            System.err.println("Error al procesar el fichero " + file.getName() + ": " + e.getMessage());
        }
    }

    private static void Concurrente(File[] files) {
        List<Thread> threads = new ArrayList<>();
        for (File file : files) {
            Thread thread = new Thread(() -> Files(file));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    private static int countWord(String Line) {
        String[] words = Line.trim().split("\\s+");
        return words.length > 0 && !words[0].isEmpty() ? words.length : 0;
    }
}
