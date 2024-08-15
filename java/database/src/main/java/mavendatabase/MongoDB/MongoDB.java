package mavendatabase.MongoDB;

import java.util.Scanner;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import mavendatabase.Main;

public class MongoDB {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Opciones(sc);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void Opciones(Scanner sc) {
        System.out.println("> El sistema pasara a mostrar el menú");
        System.out.println("MENÚ");
        System.out.println("1 - Crear colecciones (usando archivo json)");
        System.out.println("2 - Colecciones: Consultas");

        int r = sc.nextInt();

        switch (r) {
            case 1:
                CrearColeccion(sc);
                break;
            case 2:
                Consultas(sc);
                break;

            default:
                System.out.println("> El sistema detecto de que no has introduccido bien los parametros, 1 o 2");
                break;
        }
    }

    private static void CrearColeccion(Scanner sc) {
        String dbname = "Videojuegos2";

        System.out.println("> El sistema va a conectar con\033[1m\033[32m MongoDB\033[0m");
        MongoClient mc = new MongoClient();
        MongoDatabase db = mc.getDatabase(dbname);
        MongoCollection<Document> collection;
        System.out.println("> El sistema se ha conectado a\033[1m\033[32m MongoDB\033[0m");

        do {
            System.out.println("> El sistema necesita que escribas: empresa, personajes o opciones (fin para salir)");
            String r = sc.nextLine();
            if (r.equals("opciones")) {
                Opciones(sc);
            }

            // TODO: INSERTAR DATOS

            if (r.equalsIgnoreCase("fin")) {
                break;
            }
        } while (true);

    }

    // TODO: Menu de consultas.
    private static void Consultas(Scanner sc) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Consultas'");
    }
}
