package minerva.controller;

import minerva.model.Vendedor;

/**
 *
 * @author L
 */
public class PuntoVentaController {
    private Vendedor vendedor = new Vendedor();
    private NuevaVentaController nuevaVentaController;
    private ClientesController clientesController;
    private ProveedorController proveedorController;
    private ProductosController productosController;
    private VentasController ventasController;


    public PuntoVentaController() {
    }

    public PuntoVentaController(String usuario, NuevaVentaController nuevaVentaController, ClientesController clientesController, ProveedorController proveedorController, ProductosController productosController, VentasController ventasController) {
        vendedor.asignarDatosVendedor(usuario);
        this.nuevaVentaController = nuevaVentaController;
        this.clientesController = clientesController;
        this.proveedorController = proveedorController;
        this.productosController = productosController;
        this.ventasController = ventasController;
        System.out.println("INICIAMOS DATOS");
        inicializarValores();
    }
    
    private void inicializarValores() {
        nuevaVentaController.setVendedorUsuario(vendedor.getUsuario());
    } 
    
    
    
    
}
