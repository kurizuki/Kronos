package minerva.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import minerva.model.entity.Vendedor;
import minerva.model.dto.DTOVendedor;
import minerva.server.ServidorHTTP;
import minerva.view.panel.PanelProducto;

/**
 *
 * @author L
 */
public class ControllerSystem {
    private DTOVendedor dtoVendedor = null;
    private ExecutorService executor;
    private PanelProducto panelProducto = null;

    public ControllerSystem() {
    }

    public ControllerSystem(String usuario) {
        asignarDTO(usuario);
        this.panelProducto = panelProducto;
        iniciarServidor();
    }
    
    // ASIGNAMOS LOS DTO QUE NECESITA TODO EL PROGRAMA EN GENERAL
    private void asignarDTO(String usuario) {
        try {
            dtoVendedor = Vendedor.readVendedorDB(usuario);
        } catch (Exception ex) {
            System.out.println("CAYO LA UTLIMA BARRERA DE DEFENSA CONTRA LOS ERRRORES XD");
            dtoVendedor = new DTOVendedor(404, "404", "404", null);
        }
    }    
    
    private void iniciarServidor() {
        ServidorHTTP servidorHTTP = new ServidorHTTP();

        // Crear el pool de hilos con un solo hilo
        executor = Executors.newFixedThreadPool(1);

        // Enviar la tarea al executor
        executor.submit(servidorHTTP);        
        
    }
   
}
