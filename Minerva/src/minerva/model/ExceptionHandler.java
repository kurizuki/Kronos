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
    private String tituloError;
    private String detelleError;
    private String fechaActual;
    private String horaActual;
    private String mensajeError;

    public ExceptionHandler() {
    }
    
    /**
     * 
     * @param message Nombre con el cual se quiera identificar al error
     * @param cause Detalles del error
     */
    public ExceptionHandler(String message, String cause) {
        this.tituloError   = message;
        this.detelleError = cause;
        
        manejarException();
    }    
    
    private void manejarException() {
        establecerTiempoActual();
        registrarErrorTxt();
        crearMensajeErrorParaUsuario();
        mostrarMensaje(mensajeError);
    }
    
    /**
     * Eestablece la hora y fechas actuales
     */
    private void establecerTiempoActual() {
        this.fechaActual = LocalDate.now().toString();
        // FORMATE DE LA HORA
        this.horaActual = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }   
    
    /**
     * Registra el error en un archivo de texto
     */
    private void registrarErrorTxt() {
        final String NOMBRE_ARCHIVO = "registroErrores.txt"; // Nombre del archivo donde se registrarán los errores
        mensajeError = """
                             MENSAJE: %s

                             FECHA:  %s
                             HORA :  %s

                             DETALLES: 
                             %s
                             --------------------------------------------------------


                             """.formatted(tituloError, fechaActual, horaActual, detelleError);
       
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
            writer.write(mensajeError); // Escribir el mensaje de error en el archivo
        } catch (IOException e) {
            mensajeError =  """
                                ERROR AL REGISTRAR LOS ERRORES XD

                                DETALLES:
                                %s
                                """.formatted( e.toString());
            mostrarMensaje(mensajeError);
        }
    }
    
    private void crearMensajeErrorParaUsuario() {
        mensajeError =  """
                        MENSAJE: %s

                        DETALLES: 
                        %s                                                                         
                        """.formatted(tituloError, detelleError);
    }
    
    /**
     * Muestra el mensaje de errro a traves de un pequelo cuadro de texto
     */
    private void mostrarMensaje(String mensajeError) {   
        JOptionPane.showMessageDialog(null, mensajeError, "ERROR", 0);
    }
          
}
