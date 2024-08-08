package mavendatabase.ConexionDB.SQLite;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * InsertarDatos
 */
public class InsertarDatos_Scanner {
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
                    InsertarDatosP(conexion, sc);
                    break;
                case 2:
                    InsertarDatosM(conexion, sc);
                    break;

                default:
                    System.out.println("\033[31m>El sistema no ha detectado una opcion valida. \033[0m");
                    // En caso de insertar un numeor que no es
                    System.exit(0);
                    break;
            }
            // sc.close(); // Cerrar Scanner

        } catch (SQLException e) {
            System.out.println("\033[31m> El sistema a detectado un error en la base de datos.");
            System.out.println("\033[0m");
            System.out.println("\033[31m> El sistema mostrara más posibles errores: \033[0m");
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
            e.printStackTrace();
        }

    }
    // END MAIN

    // ! --- PERSONAJES ---
    private static void InsertarDatosP(Connection conexion, Scanner sc) throws SQLException {
        // * MANERAS PARA RESETEAR SCANNER

        // * Primera manera:
        sc.nextLine();

        // * Segunda manera:
        // ? String enter = sc.nextLine();
        System.out.println("> El sistema necesita: NOMBRE PERSONAJE");
        String nombre = sc.nextLine();
        System.out.println("> El sistema necesita: JEUGO DEL PERSONAJE");
        String juego = sc.nextLine();
        System.out.println("> El sistema necesita: EMPRESA ID");
        int empresaid = sc.nextInt();

        // String sql = "INSERT INTO personajes (nombre, juego, empresa_id) VALUES ('" +
        // nombre +"'', '"+ juego + "', " + empresaid+")";
        String sql = String.format("INSERT INTO personajes (nombre, juego, empresa_id) VALUES ('%s', '%s', '%d')",
                nombre, juego, empresaid);

        Statement s = conexion.createStatement();
        int f = s.executeUpdate(sql);
        System.out.println("\033[1m \033[32m> El sistema ha añadido correctamente los daots a la base de datos\033[0m");
        System.out.println("\033[1m \033[32m> El sistema mostrara dichos datos: \033[0m");
        System.out.printf("\033[1m Dato insertado: %s \033[0m", nombre);
        System.out.println("");
        System.out.printf("\033[1m Dato insertado: %s \033[0m", juego);
        System.out.println("");
        System.out.printf("\033[1m Dato insertado: %s \033[0m", empresaid);
        System.out.println("");
        System.out.println("> El sistema detecto que se han modificado algunas filas: " + f);

        conexion.close();
        sc.close();
        System.out.println("\033[1m \033[32m> El sistema se desconecto correctamente con la base de datos\033[0m");
    }
    
    // ! --- EMPRESA ---
    // ? SENTENCIAS PREPARADAS
    private static void InsertarDatosM(Connection conexion, Scanner sc) throws SQLException {
        sc.nextLine();
        System.out.println("> El sistema necesita: NOMBRE DE LA EMPRESA");
        String nombre = sc.nextLine();
        
        String sqlPreparada = "INSERT INTO empresa (nombre) VALUES (?)";
        PreparedStatement pStatement = conexion.prepareStatement(sqlPreparada);
        pStatement.setString(1, nombre);
        int f = pStatement.executeUpdate();
        System.out.println("\033[1m \033[32m> El sistema mostrara dichos datos: \033[0m");
        System.out.printf("\033[1m Dato insertado: %s \033[0m", nombre);
        System.out.println("");
        System.out.println("> El sistema detecto que se han modificado algunas filas: " + f);
        
        
        conexion.close();
        sc.close();
        System.out.println("\033[1m \033[32m> El sistema se desconecto correctamente con la base de datos\033[0m");
    }
    
}
// END CLASS