package minerva.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author L
 */
public class MySQLConnector implements AutoCloseable{    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver",
     USUARIO    = "root",    
     CONTRASENA = "Drakotako147258369#",
    
     PROTOCOLO_CONEXION = "jdbc:mysql",
     IP                 = "localhost",
     PUERTO             = "3306",
     BD                 = "Apolo",   
            
     URL                = PROTOCOLO_CONEXION + "://" + IP +":" + PUERTO + "/ " + BD;
    
    private Connection connection = null;

    public MySQLConnector() { 
        
    }
 
    public Connection getConnection() {
        try {
            // SE CARGA EL DRIVER 
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            
            System.out.println("CONEXION CON LA BASE DE DATOS " + BD + " ESTABLECIDA");
        } catch (SQLException e) {
            System.out.println("CONEXION CON LA BASE DE DATOS " + BD + " RECHAZADA");
            System.out.println("ERROR: " + e.toString());
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: " + e.toString());
        }
        return connection;
    }
    
    private void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("CONEXION CON LA BASE DE DATOS " + BD + " CERRADA");
            }
        } catch (SQLException e) {
            System.out.println("CONEXION CON LA BASE DE DATOS " + BD + " NO PUDO SER CERRADA");
            System.out.println("ERROR: " + e.toString());
        }       
    }

    @Override
    public void close() {       
        closeConnection();
    }
}
