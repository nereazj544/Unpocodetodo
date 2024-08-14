import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LeerArchivoEjemplo {
    public static void main(String[] args) {
        // Ruta al archivo
        String ruta = "java\\Ejemplos\\src\\read.txt";
        File file = new File(ruta);

        // Leer archivo usando BufferedReader
        System.out.println("Leyendo archivo usando BufferedReader:");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        // Leer archivo usando Scanner
        System.out.println("\nLeyendo archivo usando Scanner:");
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }
    }
}
