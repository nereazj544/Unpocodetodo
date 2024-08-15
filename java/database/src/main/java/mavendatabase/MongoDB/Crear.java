package mavendatabase.MongoDB;

import java.io.File;
import java.util.Scanner;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Crear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String dbname = "videojuegos";

        System.out.println("> El sistema se conectara a \033[1m\033[32m MongoDB \033[0m");
        MongoClient mClient = new MongoClient();
        MongoDatabase db = mClient.getDatabase(dbname); // si no la detecta se creara automaticamente
        System.out.println(
                "> El sistema ha dectado: " + dbname + ". Si no la detecta la creara automaticamente.");
        System.out.println("");
        do {
            System.out.println("> Crear \033[1m 'empresa' o 'personajes' \033[0m\033[31m ('FIN' PARA TERMINAR)\033[0m");
            String r = sc.nextLine();
            if (r.equalsIgnoreCase("FIN")) {
                break;
            }
            if (r.equals("empresa")) {
                MongoCollection<Document> col = db.getCollection("empresa");
                System.out.println("> El sistema creara empresa");
                System.out.println("> El sistema necesita la ruta de\033[1m 'empresas.json' \033[0m");
                System.out.print("> RESPUESTA: ");

                try {
                    String rt = sc.nextLine();
                    File ruta = new File(rt);
                    if (!ruta.exists()) {
                        System.out.println("> Error: No se pudo encontrar el archivo en la ruta especificada.");
                    }

                    Scanner file = new Scanner(ruta);
                    StringBuilder sb = new StringBuilder();
                    String l;
                    while (file.hasNextLine()) {
                        l = file.nextLine();
                        sb.append(l);
                    }
                    /*
                     * JSONObject jsonObject = new JSONObject(sb.toString());
                     * JSONArray jArray = jsonObject.getJSONArray(r); // Obtener el array
                     * correspondiente ('empresa' o 'personajes')
                     * 
                     * for (int i = 0; i < jArray.length(); i++) {
                     * JSONObject jObject = jArray.getJSONObject(i);
                     * Document doc = Document.parse(jObject.toString());
                     * col.insertOne(doc);
                     * }
                     */

                    JSONArray jArray = new JSONArray(sb.toString());
                    for (int i = 0; i < jArray.length(); i++) {
                        JSONObject jObject = jArray.getJSONObject(i);
                        Document doc = Document.parse(jObject.toString());
                        col.insertOne(doc);
                    }

                    System.out.println("> El sistema ha creado: empresa");
                    file.close();
                } catch (Exception e) {
                    System.out.println("> Error: " + e.getMessage());
                }
            }

            if (r.equals("personajes")) {
                MongoCollection<Document> col = db.getCollection("personajes");
                System.out.println("> El sistema creara personajes");
                System.out.println("> El sistema necesita la ruta de\033[1m 'personajes.json' \033[0m");
                System.out.print("> RESPUESTA: ");

                try {
                    String rt = sc.nextLine();
                    File ruta = new File(rt);
                    if (!ruta.exists()) {
                        System.out.println("> Error: No se pudo encontrar el archivo en la ruta especificada.");
                    }

                    Scanner file = new Scanner(ruta);
                    StringBuilder sb = new StringBuilder();
                    while (file.hasNextLine()) {
                        String l = file.nextLine(); // Corrección aquí
                        sb.append(l);
                    }

                    JSONArray jArray = new JSONArray(sb.toString());
                    for (int i = 0; i < jArray.length(); i++) {
                        JSONObject jObject = jArray.getJSONObject(i);
                        Document doc = Document.parse(jObject.toString());
                        col.insertOne(doc);
                    }
                    file.close();
                    System.out.println("> El sistema ha creado: " + r);
                } catch (Exception e) {
                    System.out.println("> Error: " + e.getMessage());
                }
            }

        } while (true);

        mClient.close();

        sc.close();
    }
}
