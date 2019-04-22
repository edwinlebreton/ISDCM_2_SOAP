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
public class JdbcDerbyConnection {
    
    static final String DATABASE = "usuarios";
    static final String USER = "root";
    static final String PASSWORD = "admin";
    
    
    public static Connection ConexionDB() {
        try {
            String dbURL = "jdbc:derby://localhost/"+DATABASE +";create=true";

            Connection conn2 = DriverManager.getConnection(dbURL, USER, PASSWORD);
            if (conn2 != null) {
                System.out.println("Conexión exitosa a la base de datos");
            }
            return conn2;
            
        } 
        catch (SQLException ex) {
            System.out.println("Error en la conexion a la base de datos " + ex.getMessage());
            return null;
        }
    }
}
