package mavendatabase.YT_videos_code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class InsertarDatosSQL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("> El sistema pasara a mostar el menú");
        System.out.println("** MENÚ **");
        System.out.println("1- Insertar datos: teclado");
        System.out.println("2- Insertar datos: argumentos");
        System.out.print("> RESPUESTA (1 o 2): ");

        int r = sc.nextInt();

        switch (r) {
            case 1:
                InsertarDatosScanner(sc);
                break;
            case 2:
                InsertarDatosARGS(args);
                break;

            default:
                System.out.println("> El sistema no ha detectado una opcion valida, por favor intentolo más tarde.");
                break;
        }

    }

    // ! -- CON SCANNER --
    private static void InsertarDatosScanner(Scanner sc) {
        System.out.println("> El sistema ha detectado la opcion 1");
        System.out.println("> El sistema necesita la ruta donde se almacena el archivo \033[1m'.db' \033[0m");
        System.out.print(">RESPUESTA: ");
        String ruta = sc.nextLine();

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + ruta)) {
            System.out.println("> El sistema necesita el nombre de la \033[1m'tabla' \033[0m a mostrar datos");
            System.out.print(">RESPUESTA: ");
            String tb = sc.nextLine();

            if (tb.equals("personajes")) {
                // Sentencias no preparadas

                // * -- NOMBRE
                System.out.println("> El sistema requiere que esribas: Nombre del personaje a añadir");
                System.out.print(">RESPUESTA: ");
                String n = sc.nextLine();

                // * -- JUEGO
                System.out.println(
                        "> El sistema requiere que esribas: Nombre del videojuego al que pertenece el personaje: " + n);
                System.out.print(">RESPUESTA: ");
                String j = sc.nextLine();

                // * -- ID EMPRESA
                System.out.println(
                        "> El sistema requiere que esribas: el id de la empresa a la que pertenece el videojuego: "
                                + j);
                System.out.print(">RESPUESTA: ");
                int id = sc.nextInt();

                String sql = String.format("insert INTO personajes (nombre, juego, empresa_id) values ('%s', '%s', %d)",
                        n, j, id);

                Statement s = connection.createStatement();
                System.out.println("> Datos a añadir: nombre: " + n + ", juego: " + j + " y id empresa: " + id);
                int filas_afectadas = s.executeUpdate(sql);
                System.out.println("> El sistema ha modificado este numero de filas: " + filas_afectadas);

            } else if (tb.equals("empresa")) {
                // Sentencias preparadas

                // * -- NOMBRE
                System.out.println("> El sistema requiere que esribas: Nombre de la empresa a añadir");
                System.out.print(">RESPUESTA: ");
                String n = sc.nextLine();
                String sql = "insert INTO empresa (nombre) values (?)";

                PreparedStatement pStatement = connection.prepareStatement(sql);
                pStatement.setString(1, n);
                int filas_afectadas = pStatement.executeUpdate();
                System.out.println("> El sistema ha modificado este numero de filas: " + filas_afectadas);
            } else {
                System.out.println("> El sistema no a detectado ninguna tabla con el nombre: " + tb
                        + ". Es posible que haya escrito mal el nombre de la tabla o que la tabla no exista.");
            }

        } catch (Exception e) {
            System.out.println(
                    "> El sistema ha detectado un error en la base de datos, a continuacion se mostraran los errores: ");
            e.printStackTrace();
        }
    }

    // ! -- CON ARGS --
    private static void InsertarDatosARGS(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("> El sistema ha detectado la opcion 1");
        System.out.println("> El sistema necesita la ruta donde se almacena el archivo \033[1m'.db' \033[0m");
        System.out.print(">RESPUESTA: ");
        String ruta = sc.nextLine();

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + ruta)) {
            System.out.println("> El sistema necesita el nombre de la \033[1m'tabla' \033[0m a mostrar datos");
            System.out.print(">RESPUESTA: ");
            String tb = sc.nextLine();

            if (tb.equals("personajes")) {
                if (args.length < 3) {
                    System.out.println("> El sistema no ha detectado los 3 argumentos. Nombre, Juego y ID Empresa");
                } else {
                    System.out.println("> El sistema ha detectado los 3 argumentos");
                    String n = args[0];
                    String j = args[1];
                    String i = args[2];

                    int id = Integer.parseInt(i);
                    String sql = "insert INTO personajes (nombre, juego, empresa_id) values (?, ?, ?)";
                    PreparedStatement pStatement = connection.prepareStatement(sql);
                    pStatement.setString(1, n);
                    pStatement.setString(2, j);
                    pStatement.setInt(3, id);
                    System.out.printf("> Datos introducidos: %s, %s, %d", n, j, id);
                    int f = pStatement.executeUpdate();
                    System.out.println("> El sistema ha modificado: " + f);

                }
            } else if (tb.equals("empresa")) {
                if (args.length < 3) {
                    System.out.println("> El sistema no ha detectado los 3 argumentos. Nombre, Juego y ID Empresa");
                } else {
                    System.out.println("> El sistema ha detectado los 3 argumentos");
                    String n = args[0];

                    String sql = "insert INTO empresa (nombre) values (?)";
                    PreparedStatement pStatement = connection.prepareStatement(sql);
                    pStatement.setString(1, n);

                    System.out.printf("> Datos introducidos: %s", n);
                    int f = pStatement.executeUpdate();
                    System.out.println("> El sistema ha modificado: " + f);

                }
            } else {
                System.out.println("> El sistema no ha encontrado la tabla expecificada");
            }
        } catch (Exception e) {
            System.out.println(
                    "> El sistema ha detectado un error en la base de datos, a continuacion se mostraran los errores: ");
            e.printStackTrace();
        }
        sc.close();
    }

}
