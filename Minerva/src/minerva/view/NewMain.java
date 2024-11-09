package minerva.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import minerva.model.ExceptionHandler;

/**
 *
 * @author L
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            int a = 1/0;
        } catch (Exception e) {
            final String message = "Conexion con la base de datos " + "APOLO" + " rechazada";
            ExceptionHandler exceptionHandler = new ExceptionHandler(message, e.toString());
        }
    }
//    private boolean consultarExisteProducto(String productoID) {
//        PreparedStatement preparedStatement;
//        ResultSet resultSet;
//        final String QUERY = "SELECT ProductoID FROM producto WHERE ProductoID=?";
//        String productoIDDB = "";
//
//        try (MySQLConnector mySQLConnector = new MySQLConnector()) {
//            Connection connection = mySQLConnector.getConnection();
//            preparedStatement = connection.prepareStatement(QUERY);
//            preparedStatement.setString(1, productoID);
//            resultSet = preparedStatement.executeQuery();            
//            while (resultSet.next()) {        
//                productoIDDB = String.valueOf(resultSet.getInt("ProductoID"));
//                if (productoIDDB.equals(productoID)) {
//                    return true; // RETORNA TRUE SI EL USUARIO EXISTE
//                }
//            } 
//        } catch (SQLException e) {
//            System.out.println("ERROR: " + e.toString());
//        }
//
//        return false; // RETORNA FALSE SI EL USUARIO NO EXISTE
//    }

}
