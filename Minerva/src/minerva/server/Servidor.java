package minerva.server;

import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author L
 */
public class Servidor implements AutoCloseable {
    private ServerSocket server;
    private Socket socket;
    private int puerto = 8080;
    private BufferedReader entrada;
    private DataOutputStream salida;
    
    
    public void iniciar() {
        // ¡¡ OJITO SI LO EJECUTAS SIN RESTRINGIR QUE SEA A NIVEL LOCAL TODO EL MUNDO TENDRA ACCESO !!
        try {
            // INSTANCIAMOS NUESTRO SERVIDOR QUE ES EL SERVERSOCKET Y RECIBE COMO PARAMETRO EL PUERTO
            server = new ServerSocket(puerto);     
            
            // USARE WHILE PARA QUE ESCUCHE PERPETUAMENTE 
            while (true) {
                // CREAMOS UNA INSTANCIA DE SOCKET
                socket = new Socket();
                
                // CREAMOS UNA CONEXION QUE ESPERA A QUE SE MANDE UNA PETICION PROVENIENTE DE UN PROGRAMA EXTERNO
                // OSEA ESPERAMOS AL QUE EL CLIENTE SE CONECTE
                socket = server.accept();
                System.out.println("ESPERANDO CON EL ACCEPT");
                // CONFIGURAMOS NUESTRA ENTRADA 
                entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // VAMOS A ESPERAR POR UN MENSAJE DE TEXTO Y LO VAMOS A GUARDAR EN LA VARIABLE MENSAJE 
                // Leemos el mensaje enviado por el cliente
                String mensaje = entrada.readLine();

                // CREAMOS EL CANAL DE SALIDA
                salida = new DataOutputStream(socket.getOutputStream());
                // CON WRITE ELEJIMOS EL TIPO DE DATO QUE QUEREMOS ENVIAR, EN ESTE CASO USAMOS UTF PARA 
                // MANDAR CADENA DE TEXTO
                // Enviamos una respuesta al cliente
                salida.writeUTF("ADIOS");
                
                // Cerramos el socket del cliente después de la comunicación
                socket.close();
            }                      
        } catch (Exception e) {
            System.out.println("ERROR: " + e.toString());
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("se cerro el server mr");
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
