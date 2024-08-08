package mavendatabase.SQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MostarDatos {
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
            System.out.printf("\033[1m 1- Consultar: %s \033[0m", personaje);
            System.out.println("");
            System.out.printf("\033[1m 2- Consultar: %s \033[0m", empresa);
            System.out.println("");
            System.out.print("> Respuesta: ");
            int respuesta = sc.nextInt();

            // Switch para gestionar el flujo de respuesta
            switch (respuesta) {
                case 1:
                    ConsultarPersonaje(conexion); // Llamada al metodo
                    break;
                case 2:
                    ConsultarEmpresa(conexion);
                    break;

                default:
                    System.out.println("\033[31m>El sistema no ha detectado una opcion valida. \033[0m");
                    break;
            }
            sc.close();

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

    // METODOS DE CONSULTA
    private static void ConsultarPersonaje(Connection conexion) throws SQLException {
        String o = "1- Consultar Personajes";
        System.out.println("\033[1m> El sistema dectecto opcion: " + o + "\033[0m");
        Statement s = conexion.createStatement();
        String sql = "SELECT * FROM personajes";
        ResultSet rset = s.executeQuery(sql);
        while (rset.next()) {
            System.out.println("> TABLA PESONAJES");
            System.out.println("> ID del personaje: " + rset.getInt("id"));
            System.out.println("> Nombre del personaje: " + rset.getString("nombre"));
            System.out.println("> Juego al que pertenece el personaje: " + rset.getString("juego"));

            System.out.println("> Empresa: " + rset.getString("empresa_id"));

        }
        conexion.close();
        System.out.println("\033[1m \033[32m> El sistema se desconecto correctamente con la base de datos\033[0m");
    }

    private static void ConsultarEmpresa(Connection conexion) throws SQLException {
        String o = "1- Consultar Empresa";
        System.out.println("\033[1m> El sistema dectecto opcion: " + o + "\033[0m");
        Statement s = conexion.createStatement();
        String sql = "SELECT * FROM empresa";
        ResultSet rset = s.executeQuery(sql);
        while (rset.next()) {
            System.out.println("> TABLA EMPRESA");
            System.out.println("> ID de la empresa: " + rset.getInt("id"));
            System.out.println("> Nombre de la empresa: " + rset.getString("nombre"));
        }
        System.out.println("\033[1m \033[32m> El sistema se desconecto correctamente con la base de datos\033[0m");
        conexion.close();

    }

}