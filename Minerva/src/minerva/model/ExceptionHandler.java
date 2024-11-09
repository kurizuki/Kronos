package minerva.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author L
 */
public class ExceptionHandler {
    private String message;
    private String cause;
    private String localDate;
    private String localTime;

    public ExceptionHandler() {
    }
    
    /**
     * 
     * @param message Nombre con el cual se quiera identificar al error
     * @param cause Detalles del error
     */
    public ExceptionHandler(String message, String cause) {
        this.message   = message;
        this.cause     = cause;
        
        manejarError();
    }    
    
    private void manejarError() {
        establecerTiempo();
        registrarErrorTxt();
        mostrarMensajeAlUsuario();
    }
    
    /**
     * Eestablece la hora y fechas actuales
     */
    private void establecerTiempo() {
        this.localDate = LocalDate.now().toString();
        // FORMATE DE LA HORA
        this.localTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }   
    
    /**
     * Registra el error en un archivo de texto
     */
    private void registrarErrorTxt() {
        final String NOMBRE_ARCHIVO = "registroErrores.txt"; // Nombre del archivo donde se registrarán los errores
        final String MENSAJE_ERROR = """
                             MENSAJE: %s

                             FECHA:  %s
                             HORA :  %s

                             DETALLES: 
                             %s
                             --------------------------------------------------------


                             """.formatted(message, localDate, localTime, cause);
       
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
            writer.write(MENSAJE_ERROR); // Escribir el mensaje de error en el archivo
        } catch (IOException e) {
            final String ERROR_AL_REGISTRAR ="""
                                             ERROR AL REGISTRAR LOS ERRORES XD
                                             
                                             DETALLES:
                                             %s
                                             """.formatted( e.toString());
        
            JOptionPane.showMessageDialog(null, ERROR_AL_REGISTRAR , "ERROR", 0);
        }
    }
    
    /**
     * Muestra el mensaje de errro a traves de un pequelo cuadro de texto
     */
    private void mostrarMensajeAlUsuario() {
        final String MENSAJE_ERROR = """
                                     MENSAJE: %s
                         
                                     DETALLES: 
                                     %s                                                                         
                                     """.formatted(message, cause);
       
        JOptionPane.showMessageDialog(null, MENSAJE_ERROR, "ERROR", 0);
    }
      
}
