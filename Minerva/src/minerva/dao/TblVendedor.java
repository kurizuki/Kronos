package minerva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import minerva.model.ExceptionHandler;
import minerva.model.dto.DTOVendedor;

/**
 *
 * @author L
 */
public class TblVendedor implements IDAOVendedor {
    
    public TblVendedor() {
    }
    
    @Override
    public String getContrasena(String usuario) throws Exception {
        final String QUERY = "SELECT * FROM vendedor WHERE Usuario=?";
    
        String contrasenaDB = null;

        try (IDataBaseConnector mySQLConnector = new MySQLConnector()) {
            
        Connection connection = mySQLConnector.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {

        preparedStatement.setString(1, usuario);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {        
                contrasenaDB = resultSet.getString("Contrasena");
            } else {
                throw new Exception("EL USUARIO NO FUE ENCONTRADO EN LA DB");
            }
        }
        }
        } catch (SQLException e) {
            ExceptionHandler exceptionHandler = new ExceptionHandler("ERROR EN LA EJECUCIÓN DE LA QUERY", e.toString());
        }        
        
        return contrasenaDB;    
    }

    @Override
    public DTOVendedor getVendedor(String usuario) throws Exception {
        final String QUERY = "SELECT * FROM vendedor WHERE Usuario=?";
    
        DTOVendedor vendedorDB = null;

        try (IDataBaseConnector mySQLConnector = new MySQLConnector()) {
            
        Connection connection = mySQLConnector.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {

        preparedStatement.setString(1, usuario);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {        
                vendedorDB = new DTOVendedor(
                resultSet.getLong("VendedorID"),
                resultSet.getString("Nombres"),
                resultSet.getString("Usuario"),
                resultSet.getString("Contrasena"));
            } else {
                throw new Exception("EL USUARIO NO FUE ENCONTRADO EN LA DB");
            }
        }
        }
        } catch (SQLException e) {
            ExceptionHandler exceptionHandler = new ExceptionHandler("ERROR EN LA EJECUCIÓN DE LA QUERY", e.toString());
        }
        
        // EVITAMOS QUE LA CONTRA SEA VISIBLE 
        // LA MEDIDA DE CIBERSEGURIDAD MAS VAGA QUE HE VISTO XDDD
        vendedorDB.setContrasena(null);
        
        return vendedorDB;    
    }

}
