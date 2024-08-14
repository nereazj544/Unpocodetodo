package mavendatabase.ConexionDB.SQLite;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class InfoBD {
    public static void main(String[] args) {
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\nzjha\\Desktop\\Clon_Github\\Unpocodetodo\\DATABASE\\Sqlite\\DATA\\BaseSqLite.db")) {
            
            DatabaseMetaData data = c.getMetaData();
            ResultSet rSet;
            
            String n = data.getDatabaseProductName();
            String drive = data.getDriverName();
            String u = data.getURL();
            String us = data.getUserName();
            
            System.out.println("\033[1m INFORMACIÓN TABLA \033[0m");
            System.out.println("> Nombre: " + n);
            System.out.println("> Usuario: " + us);
            System.out.println("> URL: " + u);
            System.out.println("> DRIVE: " + drive);

            rSet = data.getTables(null, "personajes", null, null);
            
            while (rSet.next()) {
                int id = rSet.getInt(1);
                String nom = rSet.getString(2);
                String j = rSet.getString(3);
                int id_em = rSet.getInt(4);

                System.out.println("> ID " + id + ", nombre " + nom + ", juego " + j + ", id empresa " + id_em);
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
