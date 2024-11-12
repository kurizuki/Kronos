package minerva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import minerva.model.ExceptionHandler;
import minerva.model.VendedorDTO;

/**
 *
 * @author L
 */
public class TablaVendedor implements ICrud<VendedorDTO, String>, IVendedorDAO {
    public TablaVendedor() {
    }

    @Override
    public void create(VendedorDTO entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public VendedorDTO read(String usuario) throws Exception {
        final String QUERY = "SELECT * FROM vendedor WHERE Usuario=?";
    
        VendedorDTO vendedorDB = null;

        try (IDataBaseConnector mySQLConnector = new MySQLConnector()) {
            
            Connection connection = mySQLConnector.getConnection();
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
                
                preparedStatement.setString(1, usuario);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {        
                        vendedorDB = new VendedorDTO();
                        vendedorDB.setVendedorID(resultSet.getLong("VendedorID"));
                        vendedorDB.setNombres(resultSet.getString("Nombres"));
                        vendedorDB.setUsuario(resultSet.getString("Usuario"));
                        vendedorDB.setContrasena(resultSet.getString("Contrasena"));
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
    public void update(VendedorDTO entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LinkedList<VendedorDTO> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    @Override
    public String getContrasena(String usuario) throws Exception {
        return read(usuario).getContrasena();
    }

    @Override
    public VendedorDTO getVendedor(String usuario) throws Exception {
        VendedorDTO vendedor = read(usuario);
        vendedor.setContrasena(null);
        return vendedor;    
    }

}
