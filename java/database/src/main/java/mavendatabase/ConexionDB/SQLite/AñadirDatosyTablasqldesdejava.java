package mavendatabase.ConexionDB.SQLite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * AñadirDatosyTablasqldesdejava
 */
public class AñadirDatosyTablasqldesdejava {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            // ! -- Pedir archivo base de datos
            System.out.println("> El sistema necesita la ruta del fichero \033[1m'.db'\033[0m: ");
            String url = sc.nextLine();
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + url);

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
                    statement.executeUpdate(sqlStatement);
                }
            }

            connection.close();
            System.out.println("> Los datos y las tablas se han añadido correctamente.");

            connection.close();
        } catch (SQLException e) {
            System.out.println("> El sistema detecto que hubo una falal en la base de datos");
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("> El sistemana ha detectado un error en algun lado.");
            e.printStackTrace();
        }
    }

}