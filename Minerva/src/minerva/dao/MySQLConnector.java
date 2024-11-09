package minerva.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import minerva.model.ExceptionHandler;

/**
 *
 * @author L
 */
class MySQLConnector implements AutoCloseable{    
    private static final String 
     DRIVER = "com.mysql.cj.jdbc.Driver",
     USUARIO    = "root",    
     CONTRASENA = "Drakotako147258369#",
    
     PROTOCOLO_CONEXION = "jdbc:mysql",
     IP                 = "localhost",
     PUERTO             = "3306",
     DB                 = "Apolo",   
            
     URL                = PROTOCOLO_CONEXION + "://" + IP +":" + PUERTO + "/" + DB;
    
    private Connection connection = null;

    MySQLConnector() {         
    }
    
    /**
     * 
     * @return Devuelve la clase connection
     */
    Connection getConnection() {
        openConnection();
        return connection;
    }
    
    /**
     * Establece la conexion con la DB
     */
    private void openConnection() {
        ExceptionHandler exceptionHandler;
        try {
            // SE CARGA EL DRIVER 
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            
        } catch (SQLException e) {
            exceptionHandler = new ExceptionHandler("CONEXION CON LA BASE DE DATOS " + DB + " RECHAZADA", e.toString());
        } catch (ClassNotFoundException e) {
            exceptionHandler = new ExceptionHandler("ERROR DE DRIVER MYSQL", e.toString());
        }
    }
    
    /**
     * Cierra la conexion con la DB
     */
    private void closeConnection() {
        ExceptionHandler exceptionHandler;
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            exceptionHandler = new ExceptionHandler("CONEXION CON LA BASE DE DATOS " + DB + " NO PUDO SER CERRADA", e.toString());
        }
    }

    @Override
    public void close() {       
        closeConnection();
    }
}
