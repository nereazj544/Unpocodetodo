package mavendatabase.MongoDB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


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
        sc.nextLine();
        String dbname = "Videojuegos2";

        System.out.println("> El sistema va a conectar con\033[1m\033[32m MongoDB\033[0m");
        MongoClient mc = new MongoClient();
        MongoDatabase db = mc.getDatabase(dbname);
        MongoCollection<Document> collection;
        System.out.println("> El sistema se ha conectado a\033[1m\033[32m MongoDB\033[0m");

        do {
            System.out.println("\033[1m\033[36m> El sistema necesita que escribas: empresa, personajes o opciones (fin para salir)\033[0m");
            String r = sc.nextLine();
            if (r.equals("opciones")) {
                Opciones(sc);
            }

            // TODO: INSERTAR DATOS

            if (r.equalsIgnoreCase("fin")) {
                break;
            }

            if (r.equals("empresa")) {
                collection = db.getCollection("empresa");

                System.out.println("> El sistema creara: " + r);
                System.out.println("> El sistema necesita la ruta del archivo \033[1m'.json'\033[0m");
                System.out.print("> RESPUESTA: ");

                try {
                    String ruta = sc.nextLine();
                    File file = new File(ruta);
                    if (!file.exists()) {
                        System.out.println(
                                "\033[31\033[1m> Error: No se pudo encontrar el archivo en la ruta especificada.\033[0m");
                    } else {
                        // * -- Usando Scanner
                        Scanner scFile = new Scanner(file);
                        StringBuilder sb = new StringBuilder();

                        String linea;

                        while (scFile.hasNextLine()) {
                            linea = scFile.nextLine();
                            sb.append(linea);
                        }

                        JSONArray array = new JSONArray(sb.toString());
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject object = array.getJSONObject(i);
                            Document d = Document.parse(object.toString());
                            collection.insertOne(d);
                        }

                        scFile.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (r.equals("personajes")) {
                collection = db.getCollection("personajes");

                System.out.println("> El sistema creara: " + r);
                System.out.println("> El sistema necesita la ruta del archivo \033[1m'.json'\033[0m");
                System.out.print("> RESPUESTA: ");

                try {
                    String ruta = sc.nextLine();
                    // File file = new File(ruta);
                    // if (!file.exists()) {
                    // System.out.println(
                    // "\033[31\033[1m> Error: No se pudo encontrar el archivo en la ruta
                    // especificada.\033[0m");
                    // } else {
                    // * -- Usando Buffereard
                    FileReader fr = new FileReader(ruta);
                    BufferedReader bf = new BufferedReader(fr);
                    StringBuilder sb = new StringBuilder();

                    String linea;

                    while ((linea = bf.readLine()) != null) {
                        sb.append(linea);
                    }

                    JSONArray array = new JSONArray(sb.toString());
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        Document d = Document.parse(object.toString());
                        collection.insertOne(d);
                    }

                    // }
                    bf.close();
                } catch (FileNotFoundException e) {
                    System.out.println("> El sistema no ha detectado el archivo");
                }catch (IOException e){
                    System.out.println("> El sistema ha detectado un error");
                }
            }

        } while (true);

    }

    // TODO: Menu de consultas.
    private static void Consultas(Scanner sc) {
        System.out.println("> Menu de las consultas: ");
        System.out.println("1- Generear archivo Json");
        System.out.println("2- Insertar datos (teclado)");
        System.out.println("3- Borrar datos (teclados)");
        System.out.println("4- Listar Datos");
        System.out.println("5- Buscar Datos");
        int r = sc.nextInt();
        

    }
}
