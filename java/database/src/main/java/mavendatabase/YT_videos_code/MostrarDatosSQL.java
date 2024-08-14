package mavendatabase.YT_videos_code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MostrarDatosSQL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("> El sistema necesita la ruta donde se almacena el archivo \033[1m'.db' \033[0m");
        System.out.print(">RESPUESTA: ");
        String ruta = sc.nextLine();
        
        try {
            Connection connection  = DriverManager.getConnection("jdbc:sqlite:" + ruta);
            
            System.out.println("> El sistema necesita el \033[1m 'nombre' \033[0m de la tabla a mostrar datos: ");
            System.out.print(">RESPUESTA: ");
            String tb = sc.nextLine();

            String sql = String.format("SELECT * FROM %s", tb);
            Statement s = connection.createStatement();
            ResultSet rSet = s.executeQuery(sql);

            if (tb.equals("personajes")) {
                while (rSet.next()) {
                    System.out.println("> ID del personaje: " + rSet.getInt("id"));
                    System.out.println("> Nombre del personaje: " + rSet.getString("nombre"));
                    System.out.println("> Juego al que pertenece el personaje: " + rSet.getString("juego"));
                    System.out.println("> Empresa al que pertenece el videojuego: " + rSet.getInt("empresa_id"));
                }
            } else if (tb.equals("empresa")) {
                while (rSet.next()) {
                    System.out.println("> ID de la empresa: " + rSet.getInt(1));
                    System.out.println("> Nombre de la empresa: " + rSet.getString(2));
                }
                
            }else{
                System.out.printf("> El sistema no ha detectado ninguna tabla con el nombre:'%s', introduca o revise si esta bien escrito el nombre de la tabla.", tb);
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("> El sistema ha detectado un error en la base de datos, a continuacion se mostraran los errores: ");
            e.printStackTrace();
        }

        sc.close();
    }
}
