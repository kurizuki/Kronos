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
    
    public boolean consultarExistenciaUsuario(String usuario) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        final String QUERY = "SELECT Usuario FROM vendedor WHERE Usuario=?";

        try (MySQLConnector mySQLConnector = new MySQLConnector()) {
            connection = mySQLConnector.getConnection();
            preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, usuario);
            resultSet = preparedStatement.executeQuery();            
            while (resultSet.next()) {        
                String usuarioDB = resultSet.getString("Usuario");
                if (usuarioDB.equals(usuario)) {
                    return true; // RETORNA TRUE SI EL USUARIO EXISTE
                }
            } 
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.toString());
        }

        return false; // RETORNA FALSE SI EL USUARIO NO EXISTE
    }
    
    public String consultarContrasena(String usuario, String contrasena) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        final String QUERY = "SELECT Contrasena FROM vendedor WHERE Usuario=?";
        String contrasenaDB = "";
        
        try (MySQLConnector mySQLConnector = new MySQLConnector()){
            connection = mySQLConnector.getConnection();

            preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, usuario);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {        
                contrasenaDB = resultSet.getString("Contrasena");
                return contrasenaDB;
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.toString());
        }

        return contrasenaDB; 
    }
    
    public String[] consultarDatos(String usuario) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        final String QUERY = "SELECT VendedorID, Nombres, Usuario FROM vendedor WHERE Nombres=?";
        String[] datosUsuario = new String[3];
        
        try (MySQLConnector mySQLConnector = new MySQLConnector()){
            connection = mySQLConnector.getConnection();

            preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, usuario);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {     
                // CONVERTIMOS EL ID EN STRING 
                datosUsuario[0] = String.valueOf(resultSet.getInt("VendedorID"));
                datosUsuario[1] = resultSet.getString("Nombres");
                datosUsuario[2] = resultSet.getString("Usuario");
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.toString());
        }

        return datosUsuario; // RETORNA FALSE SI LAS CREDENCIALES SON INVALIDAS
    }
}
