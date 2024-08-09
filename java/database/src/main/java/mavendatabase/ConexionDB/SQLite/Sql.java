package mavendatabase.ConexionDB.SQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Sql
 * 
 * TODO: Mostrar datos, insetar datos (Con sentencias preparadas y sin
 * sentencias preparadas), consultas
 * TODO: Sentencias preparadas son "VALUES (?)", se coloca un ? por cada valor
 * que haya en la columna, las sentencias no preparadas son pasandole el
 * parametro direcamente
 * 
 */
public class Sql {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ! MENSAJE PRINCIPAL
        System.out.println("> El sistema le pasara a mostar el mMENÚ: ");

        // * MENÚ
        System.out.println("\033[1mMENÚ\033[0m");
        System.out.println("1 - Mostrar datos");
        System.out.println("2 - Insetar datos");
        System.out.println("3 - Consulta");
        System.out.println("\033[1m> RESPUESTA: \033[0m");

        int r = sc.nextInt();

        switch (r) {
            // ? Las cadenas de texto si van con "TEXTO", los numeros no
            // TODO: Llamamos a los metodos que van a llamar a otros metodos a su vez.
            case 1:
                MostrarDatos(sc);
                break;
            case 2:
                // InsetarDatos(sc);
                break;
            case 3:
                // ConsultarDatos(sc);
                break;

            // ? Mensaje por defecto (en caso de que no haya ningun valor de los casos
            // saltara este mensaje)
            default:
                System.out.println(
                        "> El sistema ha detectado que no se ha colocado un numero correcto, por favor vuelva a intentarlo más tarde.");
                break;
        }
        // sc.close(); // ! Cerramos el scanner

    } // END MAIN

    // *MOSTRAR
    private static void MostrarDatos(Scanner sc) {
        // TODO Metodo de mostrar datos. Tenemos dos tablas, asi que las vamos a mostrar
        // por separado pero antes, le preguntaremos al user que tabla quiere mostrar.

        String tp = "TABLA PERSONAJES";
        String te = "TABLA EMPRESA";
        sc.nextLine(); // ? Reseteamos el Scanner

        System.out.println("\033[1mMENÚ\033[0m");
        System.out.printf("1 - Mostrar datos: \033[1m%s\033[0m", tp);
        System.out.println("");
        System.out.printf("1 - Mostrar datos: \033[1m%s\033[0m", te);
        System.out.println("");
        System.out.println("\033[1m> RESPUESTA: \033[0m");
        int n = sc.nextInt();

        switch (n) {
            case 1:
                MostrarDatosPersoanjes();
                break;
            case 2:
                MostrarDatosEmpresa();
                break;

            default:
                System.out.println(
                        "> El sistema ha detectado que no se ha colocado un numero correcto, por favor vuelva a intentarlo más tarde.");
                break;
        }
    }

    // ! --- PERSONAJES ---
    private static void MostrarDatosPersoanjes() {
        // TODO: Crear la conexion a la base de datos SQLite

        Scanner sc = new Scanner(System.in);

        System.out.println(
                "> El sistema necesita que le pases la ruta del fichero con la terminacion \033[1m '.db'\033[0m ");

        // ? Almacenaremos la ruta que nos pase el user en esta variable
        String ruta = sc.nextLine();
        try {
            // ? Conexion con la base de datos
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + ruta);

            Statement s = connection.createStatement();

            // ? Sentecia de sql
            String sql = "SELECT * FROM personajes";

            ResultSet rSet = s.executeQuery(sql);

            // ? Mostrar datos
            while (rSet.next()) {
                System.out.println("> El sistema ha detectado datos, los pasaremos a msotrar: ");
                // ! podemos ponerlo por numeros o por el nombre de la columna (a poder ser bien
                // escrito que sino luego se queja xd)
                System.out.println("> ID del personaje: " + rSet.getInt(1));
                System.out.println("> Nombre del personaje: " + rSet.getString("nombre"));
                System.out.println("> Juego en el que sale el personaje: " + rSet.getString("juego"));
                System.out.println("> ID de la empresa: " + rSet.getString("empresa_id"));
            }
            connection.close();
            sc.close();
            System.out.println("\033[1m \033[32m> El sistema se desconecto correctamente con la base de datos\033[0m");
        } catch (SQLException e) {
            System.out.println(
                    "> El sistema ha detectado un error, a continuacion más informacion acerca de este error: ");
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
            e.printStackTrace();
        }
    }

    // ! --- EMPRESA ---
    private static void MostrarDatosEmpresa() {
        // TODO: Crear la conexion a la base de datos SQLite

        Scanner sc = new Scanner(System.in);

        System.out.println(
                "> El sistema necesita que le pases la ruta del fichero con la terminacion \033[1m '.db'\033[0m ");

        // ? Almacenaremos la ruta que nos pase el user en esta variable
        String ruta = sc.nextLine();
        try {
            // ? Conexion con la base de datos
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + ruta);

            Statement s = connection.createStatement();

            // ? Sentecia de sql
            String sql = "SELECT * FROM empresa";

            ResultSet rSet = s.executeQuery(sql);

            // ? Mostrar datos
            while (rSet.next()) {
                System.out.println("> El sistema ha detectado datos, los pasaremos a msotrar: ");

                System.out.println("> nomrbre de la empresa: " + rSet.getString("nombre"));
                System.out.println("> ID de la empresa: " + rSet.getString("id"));
            }
            connection.close();
            sc.close();
            System.out.println("\033[1m \033[32m> El sistema se desconecto correctamente con la base de datos\033[0m");
        } catch (SQLException e) {
            System.out.println(
                    "> El sistema ha detectado un error, a continuacion más informacion acerca de este error: ");
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
            e.printStackTrace();
        }
    }

}
// ! END CLASS
