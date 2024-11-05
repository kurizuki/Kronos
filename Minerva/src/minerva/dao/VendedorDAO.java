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
       
    public boolean consultarUsuario(String usuario) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String query = "SELECT Usuario FROM vendedor WHERE Usuario=?";

        try (MySQLConnector mySQLConnector = new MySQLConnector()) {
            connection = mySQLConnector.getConnection();
            preparedStatement = connection.prepareStatement(query);
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
    
    public boolean consultarCredenciales(String usuario, String contrasena) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String query = "SELECT Contrasena FROM vendedor WHERE Usuario=?";
        
        try (MySQLConnector mySQLConnector = new MySQLConnector()){
            connection = mySQLConnector.getConnection();

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, usuario);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {        
                String contrasenaDB = resultSet.getString("Contrasena");

                if (contrasenaDB.equals(contrasena)) {
                    return true; // RETORNA TRUE SI LAS CREDENCIALES SON VALIDAS
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.toString());
        }

        return false; // RETORNA FALSE SI LAS CREDENCIALES SON INVALIDAS
    }
}
