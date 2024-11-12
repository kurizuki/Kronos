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
public class TblProducto implements ICrud<DTOProducto, Long>, IDAOProducto {

    @Override
    public void create(DTOProducto entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DTOProducto read(Long identificador) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(DTOProducto entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Long identificador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LinkedList<DTOProducto> listAll() throws Exception {
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
        
        return listProductoDTO;
    }

    @Override
    public ArrayList listarProducto() throws Exception {        
        return new ArrayList<>(listAll()); // Convierte LinkedList a ArrayList directamente
    } 

}