package minerva.server;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 *
 * @author L
 */
public class ServidorHTTP {
    static final int PUERTO = 8080;
    
    public static void iniciar() {
        try {            
            HttpServer httpServer = HttpServer.create(new InetSocketAddress("0.0.0.0",PUERTO), 6);
            
            // Crear contexto para registrar producto
            HttpContext contextoRegistrar = httpServer.createContext("/registrar-producto");
            contextoRegistrar.setHandler(ServidorHTTP::solicitudRegistrarProducto);
            
            // Crea un contexto específico para la ruta "/registrar-producto"
            HttpContext contexto = httpServer.createContext("/validar-codigo-barras");
            contexto.setHandler(ServidorHTTP::solicitudValidarCodigoBarras);
            
            httpServer.start();
            System.out.println("Servidor iniciado en el puerto " + PUERTO);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.toString());
        }    
    }
    
    private static void solicitudValidarCodigoBarras(HttpExchange exchange) throws IOException {
        
        // Agregar encabezados CORS PARA QUE NODE JS PUEDA ESTABLECER CONEXION
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
        exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");
        
        String clienteIp = exchange.getRemoteAddress().getAddress().getHostAddress();
        System.out.println("Conexión desde: " + clienteIp + " - Ruta: " + exchange.getRequestURI());
        if ("OPTIONS".equals(exchange.getRequestMethod())) {
               // Responder a la solicitud preflight
               exchange.sendResponseHeaders(204, -1); // No content
               return;
        }
        // Solo manejar solicitudes POST
        if ("POST".equals(exchange.getRequestMethod())) {
            // Leer el cuerpo de la solicitud
            BufferedReader reader = new BufferedReader(new InputStreamReader(exchange.getRequestBody()));
            String jsonBuilder = new String();
            String linea;

            while ((linea = reader.readLine()) != null) {
                jsonBuilder += linea;
            }
            
            System.out.println(jsonBuilder);

            // Convertir el JSON a una cadena
            Gson gson = new Gson();
            

            // Aquí puedes procesar el JSON como desees


            // Respuesta al cliente
            String respuesta = "Validar Codigo de barras";
            final int CODIGO_RESPUESTA = 200;
            
            exchange.sendResponseHeaders(CODIGO_RESPUESTA, respuesta.getBytes().length);

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(respuesta.getBytes());
            }
        } else {
            // Manejar métodos no soportados
            String respuesta = "Método no soportado";
            final int CODIGO_RESPUESTA = 405; // Method Not Allowed
            exchange.sendResponseHeaders(CODIGO_RESPUESTA, respuesta.getBytes().length);
            
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(respuesta.getBytes());
            }
        }
    }
    
    private static void solicitudRegistrarProducto(HttpExchange exchange) throws IOException {
        // Agregar encabezados CORS PARA QUE NODE JS PUEDA ESTABLECER CONEXION
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
        exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");
        if ("OPTIONS".equals(exchange.getRequestMethod())) {
               // Responder a la solicitud preflight
               exchange.sendResponseHeaders(204, -1); // No content
               return;
        }
        // Solo manejar solicitudes POST
        if ("POST".equals(exchange.getRequestMethod())) {
            // Leer el cuerpo de la solicitud
            BufferedReader reader = new BufferedReader(new InputStreamReader(exchange.getRequestBody()));
            String jsonBuilder = new String();
            String linea;

            while ((linea = reader.readLine()) != null) {
                jsonBuilder += linea;
            }
            
            System.out.println(jsonBuilder);

            // Convertir el JSON a una cadena
            Gson gson = new Gson();
            

            // Aquí puedes procesar el JSON como desees


            // Respuesta al cliente
            String respuesta = "Registrar Producto";
            final int CODIGO_RESPUESTA = 200;
            
            exchange.sendResponseHeaders(CODIGO_RESPUESTA, respuesta.getBytes().length);

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(respuesta.getBytes());
            }
        } else {
            // Manejar métodos no soportados
            String respuesta = "Método no soportado";
            final int CODIGO_RESPUESTA = 405; // Method Not Allowed
            exchange.sendResponseHeaders(CODIGO_RESPUESTA, respuesta.getBytes().length);
            
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(respuesta.getBytes());
            }
        }
    }
//    implements Runnable y implements AutoCloseable son dos interfaces en Java que sirven para propósitos diferentes. Aquí te explico cada una:
//
//1. implements Runnable
//Propósito: Se utiliza para definir un bloque de código que puede ser ejecutado en un hilo separado (thread).
//Método clave: Debes implementar el método run(), que contiene el código que se ejecutará en el nuevo hilo.
//Uso común: Se utiliza principalmente en programación concurrente para crear tareas que se pueden ejecutar en paralelo.
//Ejemplo:
//
//java
//Copiar código
//public class MiTarea implements Runnable {
//    @Override
//    public void run() {
//        System.out.println("Tarea en ejecución en un hilo separado.");
//    }
//}
//
//// Para ejecutar la tarea:
//Thread hilo = new Thread(new MiTarea());
//hilo.start();
}
