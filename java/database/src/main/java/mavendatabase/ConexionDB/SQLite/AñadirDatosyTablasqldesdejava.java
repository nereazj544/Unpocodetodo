package mavendatabase.ConexionDB.SQLite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * AñadirDatosyTablasqldesdejava
 */
public class AñadirDatosyTablasqldesdejava {
    public static void main(String[] args) throws IOException {
        try (Scanner sc = new Scanner(System.in)) {
            // ! -- Pedir archivo base de datos
            System.out.println("> El sistema necesita la ruta del fichero \033[1m'.db'\033[0m: ");
            String url = sc.nextLine();
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + url);

            System.out.println("> Añadir tablas o datos: ");
            String r = sc.nextLine();
            switch (r) {
                case "tablas":
                    Tablas(connection, sc);
                    break;
                case "datos":
                    Datos(connection);
                    break;

                default:
                    break;
            }
        } catch (SQLException e) {
            System.out.println("> El sistema detecto que hubo una falal en la base de datos");
            e.printStackTrace();

        }
    }

    private static void Tablas(Connection connection, Scanner sc) throws IOException, SQLException {
        // ! -- Pedir archivo sql
        System.out.println("> El sistema necesita la ruta del fichero \033[1m'.sql'\033[0m: ");
        String ruta = sc.nextLine();
        File file = new File(ruta);

        // Comprobamos que existe
        if (!file.exists()) {
            System.out.println("> El archivo SQL no se encuentra en la ruta especificada.");
            return;
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder sql = new StringBuilder();
        /*
         * StringBuilder sql = new StringBuilder();
         * String line;
         * while ((line = br.readLine()) != null) {
         * sql.append(line).append("\n");
         * }
         * 
         * Statement statement = connection.createStatement();
         * statement.executeUpdate(sql.toString());
         * 
         * br.close();
         */
        String line;
        while ((line = br.readLine()) != null) {
            sql.append(line).append(" ");
        }
        br.close();

        // Separar las sentencias SQL por ';' y ejecutarlas una por una
        String[] sqlStatements = sql.toString().split(";");
        Statement statement = connection.createStatement();

        for (String sqlStatement : sqlStatements) {
            sqlStatement = sqlStatement.trim();
            if (!sqlStatement.isEmpty()) {
                System.out.println("Ejecutando sentencia SQL: " + sqlStatement);
                statement.executeUpdate(sqlStatement);
            }
        }
        System.out.println("> El sistema ha creado las tabals");
    }

    private static void Datos(Connection connection) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("> fichero o manual");
        System.out.print("> Respuesta: ");
        String r = sc.nextLine();
        switch (r) {
            case "fichero":
                DatosF(connection, sc);
                break;
            case "manual":
                DatosM(connection, sc);
                break;

            default:
                break;
        }
    }

    private static void DatosF(Connection connection, Scanner sc) {
        System.out.println("> El sistema necesita la ruta del fichero \033[1m'.sql' o '.txt'\033[0m: ");
        String ruta = sc.nextLine();
        File file = new File(ruta);

        try (Scanner scanner = new Scanner(file)) {
            StringBuilder sql = new StringBuilder();
            while (scanner.hasNextLine()) {
                sql.append(scanner.nextLine()).append("\n"); // Usar salto de línea para separar sentencias
            }

            // Separar las sentencias SQL por ';' y ejecutarlas una por una
            String[] sqlStatements = sql.toString().split(";");
            Statement statement = connection.createStatement();

            for (String sqlStatement : sqlStatements) {
                sqlStatement = sqlStatement.trim();
                if (!sqlStatement.isEmpty()) {
                    statement.executeUpdate(sqlStatement);
                }
            }

            System.out.println("> Los datos se han insertado correctamente desde el archivo.");
        } catch (SQLException e) {
            System.out.println("> Error al ejecutar las sentencias SQL.");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("> El archivo no se encuentra en la ruta especificada.");
            e.printStackTrace();
        }
    }

    private static void DatosM(Connection connection, Scanner sc) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();

        // Obtener nombres de las tablas
        ResultSet tables = metaData.getTables(null, null, "%", new String[] { "TABLE" });

        System.out.println("Tablas en la base de datos:");
        while (tables.next()) {
            String tableName = tables.getString("\033[1m> TABLE_NAME\033[0m");
            System.out.println(tableName);
        }
        do {

            System.out.println("> El sistema necesita el nombre de la tabla(FIN pa terminar): ");
            String tb = sc.nextLine();

            if (tb.equalsIgnoreCase("FIN")) {
                break;
            }

            if (tb.equals("empresa")) {
                // ! -- DATOS A AÑADIR
                System.out.println("> Nombre de la empresa: ");
                System.out.print("> Respuesta: ");
                String nombre = sc.nextLine();

                // ! -- DATOS AÑADIDOS CON SENTENCIAS PREPARADAS
                String sqlinset = "INSERT INTO empresa (nombre) VALUES (?) ";
                PreparedStatement pStatement = connection.prepareStatement(sqlinset);
                pStatement.setString(1, nombre);
                int f = pStatement.executeUpdate();
                System.out.println("> El sistema ha modificado: " + f);

            } else if (tb.equals("personajes")) {
                // ! -- DATOS A AÑADIR
                System.out.println("> Nombre de personaje: ");
                System.out.print("> Respuesta: ");
                String nombre = sc.nextLine();

                System.out.println("> Juego de personaje: ");
                System.out.print("> Respuesta: ");
                String j = sc.nextLine();

                System.out.println("> ID Empresa: ");
                System.out.print("> Respuesta: ");
                int id = sc.nextInt();

                // ! -- DATOS AÑADIDOS CON SENTENCIAS PREPARADAS
                String sqlinset = "insert INTO personajes (nombre, juego, empresa_id) values (?, ?, ?) ";
                PreparedStatement pStatement = connection.prepareStatement(sqlinset);
                pStatement.setString(1, nombre);
                pStatement.setString(2, j);
                pStatement.setInt(3, id);

                int f = pStatement.executeUpdate();
                System.out.println("> El sistema ha modificado: " + f);

            } else if (tb.equals("libros")) {
                // ! -- DATOS A AÑADIR
                System.out.println("> Nombre del libro: ");
                System.out.print("> Respuesta: ");
                String t = sc.nextLine();

                System.out.println("> Autor: ");
                System.out.print("> Respuesta: ");
                String a = sc.nextLine();

                System.out.println("> ¿es saga? (true o false): ");
                System.out.print("> Respuesta: ");
                String saga = sc.nextLine().trim();
                int esSaga = saga.equalsIgnoreCase("true") ? 1 : 0;

                // ! -- DATOS AÑADIDOS CON SENTENCIAS PREPARADAS
                String sqlinset = "insert INTO libros (titulo, autor, es_saga) values (?, ?, ?) ";
                PreparedStatement pStatement = connection.prepareStatement(sqlinset);
                pStatement.setString(1, t);
                pStatement.setString(2, a);
                pStatement.setInt(3, esSaga);

                int f = pStatement.executeUpdate();
                System.out.println("> El sistema ha modificado: " + f);

            } else if (tb.equals("personajeslibros")) {
                // ! -- DATOS A AÑADIR
                System.out.println("> Nombre de personaje: ");
                System.out.print("> Respuesta: ");
                String nombre = sc.nextLine();

                System.out.println("> nombre de la novela: ");
                System.out.print("> Respuesta: ");
                String nv = sc.nextLine();

                System.out.println("> ¿es protagonista? (true o false): ");
                System.out.print("> Respuesta: ");
                String prota = sc.nextLine().trim();
                int esProta = prota.equalsIgnoreCase("true") ? 1 : 0;

                System.out.println("> ID libro: ");
                System.out.print("> Respuesta: ");
                int id = sc.nextInt();

                // ! -- DATOS AÑADIDOS CON SENTENCIAS PREPARADAS
                String sqlinset = "insert INTO personajeslibros (pnombre, novela, es_protagonista, libros_id) values (?, ?, ?, ?) ";
                PreparedStatement pStatement = connection.prepareStatement(sqlinset);
                pStatement.setString(1, nombre);
                pStatement.setString(2, nv);
                pStatement.setInt(3, esProta);
                pStatement.setInt(4, id);

                int f = pStatement.executeUpdate();
                System.out.println("> El sistema ha modificado: " + f);

            } else {
                System.out.println("> El sistema no ha detectado ningun nombre");

            }
        } while (true);
        sc.close();
    }
}