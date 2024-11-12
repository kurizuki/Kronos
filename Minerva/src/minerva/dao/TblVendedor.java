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
public class TblVendedor implements ICrud<DTOVendedor, String>, IDAOVendedor {
    public TblVendedor() {
    }

    @Override
    public void create(DTOVendedor entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DTOVendedor read(String usuario) throws Exception {
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
            ExceptionHandler exceptionHandler= new ExceptionHandler("ERROR EN LA EJECUCIÓN DE LA QUERY", e.toString());
        }
        
        return vendedorDB;
    }

    @Override
    public void update(DTOVendedor entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LinkedList<DTOVendedor> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    @Override
    public String getContrasena(String usuario) throws Exception {
        return read(usuario).getContrasena();
    }

    @Override
    public DTOVendedor getVendedor(String usuario) throws Exception {
        DTOVendedor vendedor = read(usuario);
        vendedor.setContrasena(null);
        return vendedor;    
    }

}
