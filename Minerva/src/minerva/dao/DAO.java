package minerva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import minerva.model.ExceptionHandler;

/**
 *
 * @author L
 */
abstract class DAO {
    protected static <T> Object consultar(T valorBusqueda, String query) throws Exception {
        ExceptionHandler exceptionHandler;
        PreparedStatement preparedStatement;
        ResultSet resultSet;       
        Object result = null;
        
       
        try (MySQLConnector mySQLConnector = new MySQLConnector()){                    
            Connection connection = mySQLConnector.getConnection();
            
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setObject(1, valorBusqueda);
            
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                result = resultSet.getObject(estraerColumna(query));
            }            
        } catch (SQLException e) {
            exceptionHandler = new ExceptionHandler("", e.toString());
        }
        
        if (result == null) {
            throw new Exception("LA BASE DE DATOS DEVOLVIO UN VALOR NULO");
        }
        
        return result;
    }
    
    protected static String estraerColumna(String query) {
        // Definir la expresión regular
        String regex = "(?i)select\\s+(.*?)\\s+from";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(query);
        
        String a = "";

        // Buscar coincidencias
        if (matcher.find()) {
            a = matcher.group(1);  // Captura el contenido entre SELECT y FROM
        } else {
            System.out.println("No se encontró un contenido entre SELECT y FROM.");
        }
        return a;
    }
}
