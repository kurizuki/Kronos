package minerva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import minerva.model.ExceptionHandler;
import minerva.model.dto.DTOProducto;

/**
 *
 * @author L
 */
public class TblProducto implements IDAOProducto {

    public TblProducto() {
    }
    
    @Override
    public ArrayList listAll() throws Exception {
        final String QUERY = "SELECT * FROM producto";
        LinkedList<DTOProducto> listProductoDTO = new LinkedList<>();

        try (IDataBaseConnector mySQLConnector = new MySQLConnector()) {
            
        Connection connection = mySQLConnector.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {

        try (ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) { 
                listProductoDTO.add(new DTOProducto(         
                        resultSet.getLong("ProductoID"), 
                        resultSet.getString("Nombre"), 
                        resultSet.getDouble("Precio"), 
                        resultSet.getString("Descripcion"), 
                        resultSet.getLong("Stock"), 
                        resultSet.getLong("CodigoBarras"),
                        resultSet.getString("UbicacionAlmacen")));                        
            } 
        }
        }
        } catch (SQLException e) {
            ExceptionHandler exceptionHandler= new ExceptionHandler("ERROR EN LA EJECUCIÓN DE LA QUERY", e.toString());
        }
        
        if (listProductoDTO.isEmpty()) {
            throw new Exception("NO EXISTEN PRODUCTOS EN LA DB");
        }
        
        return new ArrayList<>(listProductoDTO); // Convierte LinkedList a ArrayList directamente
    } 

    @Override
    public DTOProducto read(long codigoBarras) throws Exception {
        final String QUERY = "SELECT * FROM producto WHERE CodigoBarras=?";
    
        DTOProducto dtoProducto = null;

        try (IDataBaseConnector mySQLConnector = new MySQLConnector()) {
            
        Connection connection = mySQLConnector.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {

        preparedStatement.setLong(1, codigoBarras);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {        
                dtoProducto = new DTOProducto(
                resultSet.getLong("ProductoID"),
                resultSet.getString("Nombre"),
                resultSet.getDouble("Precio"),
                resultSet.getString("Descripcion"),
                resultSet.getLong("Stock"),
                resultSet.getLong("CodigoBarras"),
                resultSet.getString("UbicacionAlmacen"));
            } else {
                throw new Exception("EL PRUDUCTO NO FUE ENCONTRADO EN LA DB");
            }
        }
        }
        } catch (SQLException e) {
            ExceptionHandler exceptionHandler = new ExceptionHandler("ERROR EN LA EJECUCIÓN DE LA QUERY", e.toString());
        }
        
        return dtoProducto;
    }

    @Override
    public void create(DTOProducto dtoProducto) throws Exception {
        final String QUERY = "INSERT INTO producto(Nombre, Precio, Descripcion, Stock, CodigoBarras, UbicacionAlmacen) VALUES(?, ?, ?, ?, ?, ?)";
    
        try (IDataBaseConnector mySQLConnector = new MySQLConnector()) {
            
        Connection connection = mySQLConnector.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {

        preparedStatement.setString(1, dtoProducto.getNombre());       // Set Nombre
        preparedStatement.setDouble(2, dtoProducto.getPrecio());   // Set Precio 
        preparedStatement.setString(3, dtoProducto.getDescripcion());  // Set Descripcion
        preparedStatement.setLong(4, dtoProducto.getStock());           // Set Stock 
        preparedStatement.setLong(5, dtoProducto.getCodigoBarras());    // Set CodigoBarras 
        preparedStatement.setString(6, dtoProducto.getUbicacionAlmacen());    // Set UbicacionAlmacen

        // Ejecutar la actualización (ya que es un INSERT)
        int rowsAffected = preparedStatement.executeUpdate();

        // Verificar si se insertaron filas
        if (!(rowsAffected > 0)) {
            throw new Exception("EL PRUDUCTO NO FUE INSERTADO EN LA DB");
        }                            
        
        }
        } catch (SQLException e) {
            ExceptionHandler exceptionHandler = new ExceptionHandler("ERROR EN LA EJECUCIÓN DE LA QUERY", e.toString());
        }
    }

    @Override
    public void update(DTOProducto dtoProducto) throws Exception {
        final String QUERY = "UPDATE producto SET Nombre = ?, Precio = ?, Descripcion = ?, Stock = ?, CodigoBarras = ?, UbicacionAlmacen = ? WHERE ProductoID = ?";
    
        try (IDataBaseConnector mySQLConnector = new MySQLConnector()) {
            
        Connection connection = mySQLConnector.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {

        preparedStatement.setString(1, dtoProducto.getNombre());       // Set Nombre
        preparedStatement.setDouble(2, dtoProducto.getPrecio());   // Set Precio 
        preparedStatement.setString(3, dtoProducto.getDescripcion());  // Set Descripcion
        preparedStatement.setLong(4, dtoProducto.getStock());           // Set Stock 
        preparedStatement.setLong(5, dtoProducto.getCodigoBarras());    // Set CodigoBarras 
        preparedStatement.setString(6, dtoProducto.getUbicacionAlmacen());    // Set UbicacionAlmacen
        preparedStatement.setLong(7, dtoProducto.getProductoID()); // set ProdcutoID
        
        // Ejecutar la actualización (ya que es un INSERT)
        int rowsAffected = preparedStatement.executeUpdate();

        // Verificar si se insertaron filas
        if (!(rowsAffected > 0)) {
            throw new Exception("EL PRUDUCTO NO FUE INSERTADO EN LA DB");
        }                            
        
        }
        } catch (SQLException e) {
            ExceptionHandler exceptionHandler = new ExceptionHandler("ERROR EN LA EJECUCIÓN DE LA QUERY", e.toString());
        }
    }

}
