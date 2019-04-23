/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author edwinlebreton
 */
public class DBConnection { 
    
    public static Connection ConexionDB() {
        try {
            String URL = "jdbc:derby://localhost/usuarios;create=true";

            Connection connection = DriverManager.getConnection(URL, "root", "admin");
            if (connection != null) {
                System.out.println("Connexion done");
            }
            return connection;
            
        } 
        catch (SQLException ex) {
            System.out.println("Error in connecting to database " + ex.getMessage());
            return null;
        }
    }
}
