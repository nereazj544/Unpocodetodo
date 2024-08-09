package mavendatabase.ConexionDB.SQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * InsertarDatos_AGRS
 ** NOTE: Si quieres pasar un argumento (args) con espacio se ha de colocar ""
 * * Ejemplo: Rockstar Games > "Rockstar Games" 
 */
public class InsertarDatos_AGRS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String personaje = "TABLA DE PERSONAJES";
        String empresa = "TABLA DE EMPRESA";

        System.out
                .println("> El sistema necesita la tura donde se aloja el archivo con la extension: \033[1m.db\033[0m");
        String url = sc.nextLine();

        try {
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + url);
            System.out.println("\033[1m \033[32m> El sistema se conecto correctamente con la base de datos\033[0m");

            System.out.println("> El sistema pregunta: ¿Que desea hacer?");
            System.out.println("> El sistema muestra: Menú");

            System.out.println("\033[1m MENÚ \033[0m");
            System.out.printf("\033[1m 1- Insetar datos: %s \033[0m", personaje);
            System.out.println("");
            System.out.printf("\033[1m 2- Insetar datos: %s \033[0m", empresa);
            System.out.println("");
            System.out.print("> Respuesta: ");
            int respuesta = sc.nextInt();

            // Switch para gestionar el flujo de respuesta
            switch (respuesta) {
                case 1:
                    // Llamada al metodo
                    InsertarDatosP(conexion, args);
                    break;
                case 2:
                    InsertarDatosM(conexion, args);
                    break;

                default:
                    System.out.println("\033[31m>El sistema no ha detectado una opcion valida. \033[0m");
                    // En caso de insertar un numeor que no es
                    System.exit(0);
                    break;
            }
            sc.close(); // Cerrar Scanner

        } catch (SQLException e) {
            System.out.println("\033[0m");
            System.out.println(
                    "\033[31m> El sistema a detectado estos posibles errores:\n\033[0em\033[13m  Erroes en la conesxion, \033[0em\033[13m  Erroes en la consulta SQL, \033[0em\033[13m  Probleas de concurrencia \033[0em\033[13m  Otros errores...");
            System.out.println("\033[0m");
            System.out.println("\033[31m> El sistema mostrara más posibles errores: \033[0m");
            e.printStackTrace();
        }

    }
    // END MAIN

    // ! --- PERSONAJES ---
    private static void InsertarDatosP(Connection conexion, String[] args) throws SQLException {
        if (args.length < 3) {
            System.out.println(
                    "\033[31m> El sistema a detectado que no se ha pasado ningun argumento, por favor inserte los datos correspondientes: Nombre, juego y id empresa.\033[0m");

        } else {
            System.out.println("\033[32m> El sistema ha detectado que se han pasado  argumentos. \033[0m");

            // * Guardamos los datos pasados por agumentos
            String nombre = args[0];
            String juego = args[1];
            String idempresa = args[2];
            int id = Integer.parseInt(idempresa);

            // * Los añadimos a la variable que almacena la orden de insertar datos
            String sql = String.format("INSERT INTO personajes (nombre, juego, empresa_id) VALUES ('%s', '%s', %d)",
                    nombre, juego, id);

            // ? Creamos Statament
            Statement s = conexion.createStatement();
            int f = s.executeUpdate(sql);
            System.out.println(
                    "\033[1m \033[32m> El sistema ha añadido correctamente los daots a la base de datos\033[0m");
            System.out.println("\033[1m \033[32m> El sistema mostrara dichos datos: \033[0m");
            System.out.printf("\033[1m Dato insertado: %s \033[0m", nombre);
            System.out.println("");
            System.out.printf("\033[1m Dato insertado: %s \033[0m", juego);
            System.out.println("");
            System.out.printf("\033[1m Dato insertado: %s \033[0m", id);
            System.out.println("");
            System.out.println("> El sistema detecto que se han modificado algunas filas: " + f);

            conexion.close();
            System.out.println("\033[1m \033[32m> El sistema se desconecto correctamente con la base de datos\033[0m");

        }
    }

    // ! --- EMPRESA ---
    private static void InsertarDatosM(Connection conexion, String[] args) throws SQLException {
        if (args.length < 1) {
            System.out.println(
                    "\033[31m> El sistema a detectado que no se ha pasado ningun argumento, por favor inserte los datos correspondientes: Nombre de empresa.\033[0m");

        } else {
            System.out.println("\033[32m> El sistema ha detectado que se han pasado  argumentos. \033[0m");

            String name = args[0];

            String sqlPreparada = ("INSERT INTO empresa (nombre) VALUES (?)");
            PreparedStatement pStatement = conexion.prepareStatement(sqlPreparada);

            pStatement.setString(1, name);
            int f = pStatement.executeUpdate();

            System.out.println("\033[1m \033[32m> El sistema mostrara dichos datos: \033[0m");
            System.out.printf("\033[1m Dato insertado: %s \033[0m", name);
            System.out.println("");
            System.out.println("> El sistema detecto que se han modificado algunas filas: " + f);

            conexion.close();
            System.out.println("\033[1m \033[32m> El sistema se desconecto correctamente con la base de datos\033[0m");
        }
    }
}
// END CLASS