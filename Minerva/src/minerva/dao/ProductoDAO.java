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
    
    public boolean consultarExisteProductoPorID(int productoID) {
        int productoIDDB = (int) consultarPorID(productoID, "ProductoID");
        
        if (productoID == productoIDDB) {
            return true; // RETORNA TRUE SI EL PRODCUTO EXISTE
        }

        return false; // RETORNA FALSE SI EL PRODCUTO NO EXISTE
    }
    
    public boolean consultarExisteProductoPorBarras(int codigoBarras) {
        int productoCodigoBarrasDB = (int) consultarPorBarras(codigoBarras, "CodigoBarras");
        
        if (codigoBarras == productoCodigoBarrasDB) {
            return true; // RETORNA TRUE SI EL PRODCUTO EXISTE
        }

        return false; // RETORNA FALSE SI EL PRODCUTO NO EXISTE
    }
    
    public int consultarProductoID(int codigoBarras) {
        return (int) consultarPorBarras(codigoBarras, "CodigoBarras");
    }
    
    public int consultarProductoCodigoBarras(int productoID) {
        return (int) consultarPorID(productoID, "ProductoID");
    }
    
    public String consultarNombrePorID(int productoID) {        
        return (String) consultarPorID(productoID, "Nombre");
    }
    
    public String consultarNombrePorBarras(int codigoBarras) {              
        return (String) consultarPorBarras(codigoBarras, "Nombre");
    }
    
    public double consultarPrecioPorID(int productoID) {                
        return (double) consultarPorID(productoID, "Precio");
    }
    
    public double consultarPrecioPorBarras(int codigoBarras) {                
        return (double) consultarPorBarras(codigoBarras, "Precio");
    }
    
    public String consultarDescripcionPorID(int productoID) {        
        return (String) consultarPorID(productoID, "Descripcion");
    }
    
    public String consultarDescripcionPorBarras(int codigoBarras) {
        return (String) consultarPorBarras(codigoBarras, "Descripcion");
    }
    
    public int consultarStockPorID(int productoID) {
        return (int) consultarPorID(productoID, "Stock");
    }
    
    public int consultarStockPorBarras(int codigoBarras) {        
        return (int) consultarPorBarras(codigoBarras, "Stock");
    }
    
    public String consultarUbicacionAlmacenPorID(int productoID) {        
        return (String) consultarPorID(productoID, "UbicacionAlmacen");
    }
    
    public String consultarUbicacionAlmacenPorBarras(int codigoBarras) {
        return (String) consultarPorBarras(codigoBarras, "UbicacionAlmacen");
    }
    
    /**
     * @param  columnaConsulta es la columna que quieres consultar
     */    
    private Object consultarPorBarras(int codigoBarras, String columnaConsulta) {
        final String QUERY = "SELECT "+ columnaConsulta +" FROM producto WHERE CodigoBarras=?";
        Object result = null;
        
        try {
            
            result = consultar(codigoBarras, QUERY, columnaConsulta);

        } catch (Exception e) {
            result = 404;
        }

        return result;
    }
    
    /**
     * @param  columnaConsulta es la columna que quieres consultar
     */    
    private Object consultarPorID(int productoID, String columnaConsulta) {
        final String QUERY = "SELECT "+ columnaConsulta +" FROM producto WHERE ProductoID=?";
        Object result = null;
        
        try {
            
            result = consultar(productoID, QUERY, columnaConsulta);

        } catch (Exception e) {
            result = 404;
        }

        return result;
    }
    
    /**
     * @param  columnaConsulta es la columna que quieres consultar
     */    
    private <T> Object consultar(T valorBusqueda, String query, String columnaConsulta) throws Exception {
        PreparedStatement preparedStatement;
        ResultSet resultSet;       
        Object result = null;

        try (MySQLConnector mySQLConnector = new MySQLConnector()){
            connection = mySQLConnector.getConnection();
            
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setObject(1, valorBusqueda);
            
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                result = resultSet.getObject(columnaConsulta);
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
