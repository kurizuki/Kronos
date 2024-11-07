package minerva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import minerva.model.MySQLConnector;

/**
 *
 * @author L
 */
public class ProductoDAO {
    private Connection connection;

    public ProductoDAO() {
    }
    
    public boolean consultarExisteProducto(String productoID) {
        final String QUERY = "SELECT ProductoID FROM producto WHERE ProductoID=?";
        String productoIDDB = "";

        try {
            
            productoIDDB = (String) consultar(productoID, QUERY, "ProductoID");
            
        } catch (Exception e) {
            productoID = "404";
            return false; // RETORNA FALSE SI EL PRODCUTO NO EXISTE EN LA DB
        }
        
        if (productoID.equals(productoIDDB)) {
            return true; // RETORNA TRUE SI EL PRODCUTO EXISTE
        }

        return false; // RETORNA FALSE SI EL PRODCUTO NO EXISTE
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
