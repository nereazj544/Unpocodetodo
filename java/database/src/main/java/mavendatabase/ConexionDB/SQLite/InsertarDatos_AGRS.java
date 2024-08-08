package mavendatabase.ConexionDB.SQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * InsertarDatos_AGRS
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
                    InsertarDatosP(conexion);
                    break;
                case 2:
                    InsertarDatosM(conexion);
                    break;

                default:
                    System.out.println("\033[31m>El sistema no ha detectado una opcion valida. \033[0m");
                    // En caso de insertar un numeor que no es
                    System.exit(0);
                    break;
            }
            sc.close(); // Cerrar Scanner

        } catch (SQLException e) {
            System.out.println("\033[31m> El sistema a detectado un error en la base de datos.");
            System.out.println("\033[0m");
            System.out.println("\033[31m> El sistema a detectado estos posibles errores:" +
                    "\033[0em\033[13m - Erroes en la conesxion" +
                    "\033[0em\033[13m - Erroes en la consulta SQL" +
                    "\033[0em\033[13m - Probleas de concurrencia" +
                    "\033[0em\033[13m - Otros errores...");
            System.out.println("\033[0m");
            System.out.println("\033[31m> El sistema mostrara más posibles errores: \033[0m");
            e.printStackTrace();
        }

    }
    // END MAIN

    // ! --- PERSONAJES ---
    private static void InsertarDatosP(Connection conexion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'InsertarDatosP'");
    }

    // ! --- EMPRESA ---
    private static void InsertarDatosM(Connection conexion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'InsertarDatosP'");
    }

}
// END CLASS