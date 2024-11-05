package minerva.server;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpsServer;
import com.sun.net.httpserver.HttpsConfigurator;
import java.io.BufferedReader;
import javax.net.ssl.SSLContext;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.security.KeyStore;

public class ServidorHTTPS {
    static final int PUERTO = 8080; // Cambia el puerto a 8443 o cualquier otro puerto seguro

    public ServidorHTTPS() {
    }
    
    public static void iniciar() {
        try {
            System.out.println("CARGANDO EL KEYSTORE");
            // Cargar el keystore
            String keystorePath = ".\\src\\main\\java\\servidor\\keystore.jks"; // Cambia esto
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream(keystorePath), "drakotako1234".toCharArray());

            System.out.println("CREAMOS EL KEYMANGERFACTORY");
            // Crear el KeyManagerFactory
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, "drakotako1234".toCharArray());
            System.out.println("CREANDO EL TRUST MANAGER FACTORY");
            // Crear el TrustManagerFactory
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            System.out.println("CONFIGURANDO SSL");
            // Configurar el contexto SSL
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
            System.out.println("CREAMOS EL HTTPSERVER");
            // Crear HttpsServer
            HttpsServer httpsServer = HttpsServer.create(new InetSocketAddress("0.0.0.0", PUERTO), 0);
            httpsServer.setHttpsConfigurator(new HttpsConfigurator(sslContext));

            // Crear contexto y manejar solicitudes como en tu código original
            httpsServer.createContext("/registrar-producto", ServidorHTTPS::solicitudRegistrarProducto);
            httpsServer.createContext("/validar-codigo-barras", ServidorHTTPS::solicitudValidarCodigoBarras);

            httpsServer.start();
            System.out.println("Servidor HTTPS iniciado en el puerto " + PUERTO);
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
}