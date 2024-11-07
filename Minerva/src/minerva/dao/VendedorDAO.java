package minerva.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import minerva.model.MySQLConnector;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author L
 */
public class VendedorDAO {
    private Connection connection;
    
    public VendedorDAO() {
        
    }
    
    public boolean consultarExisteUsuario(String usuario) {
        final String QUERY = "SELECT Usuario FROM vendedor WHERE Usuario=?";
        String usuarioDB = "";
        
        try {
            
            usuarioDB = (String) consultar(usuario, QUERY, "Usuario");

        } catch (Exception e) {
            return false; // RETORNA FALSE SI LO QUE DEVUELVE LA BASE DE DATOS ES NULO
        }
        
        if (usuarioDB.equals(usuario)) {
            return true; // RETORNA TRUE SI EL USUARIO EXISTE
        }
        return false; // RETORNA FALSE SI EL USUARIO NO EXISTE
    }
    
    public String consultarContrasena(String usuario) {
        final String QUERY = "SELECT Contrasena FROM vendedor WHERE Usuario=?";
        String contrasenaDB = "";
        
        try {
            
            contrasenaDB = (String) consultar(usuario, QUERY, "Contrasena");
            
        } catch (Exception e) {
            contrasenaDB = "404";
        }       
        
        return contrasenaDB; 
    }
 
    public int consultarID(String usuario) {
        final String QUERY = "SELECT VendedorID FROM vendedor WHERE Usuario=?";
        int usuarioID = 0;
        
        try {
            
            usuarioID = (int) (long) consultar(usuario, QUERY, "VendedorID");
            
        } catch (Exception e) {
            usuarioID = -404;
        }
        
        return  usuarioID; 
    }
    
    public String consultarNombres(String usuario) {        
        final String QUERY = "SELECT Nombres FROM vendedor WHERE Usuario=?";
        String nombres = "";
        
        try {
        
            nombres = (String) consultar(usuario, QUERY, "Nombres");
        
        } catch (Exception e) {
            nombres = "404";
        }
        
        return nombres;
    }
   
    private <T> Object consultar(T param, String query, String columna) throws Exception {
        PreparedStatement preparedStatement;
        ResultSet resultSet;       
        Object result = null;

        try (MySQLConnector mySQLConnector = new MySQLConnector()){
            connection = mySQLConnector.getConnection();
            
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setObject(1, param);
            
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                result = resultSet.getObject(columna);
            }            
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.toString());
        }
        
        if (result == null) {
            throw new Exception("ITEM NO ENCONTRADO");
        }
        
        return result;
    }
}
