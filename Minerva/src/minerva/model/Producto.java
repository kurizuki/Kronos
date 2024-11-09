package minerva.model;

import minerva.dao.ProductoDAO;

/**
 *
 * @author L
 */
public class Producto {
    private static ProductoDAO productoDAO = new ProductoDAO();
    // VARIALBLES DE LA DB
    private int productoID;
    private String nombre;
    private double precio;
    private String descripcion;
    private int stock;
    private int codigoBarras;
    // AGREGAR MOVIMIENTOS PRODUCTO
    private String ubicacionAlmacen;


    public Producto() {
    }

    public Producto(String nombre, double precio, String descripcion, int stock, int codigoBarras, String ubicacionAlmacen) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
        this.codigoBarras = codigoBarras;
        this.ubicacionAlmacen = ubicacionAlmacen;
    }   

    public double getPrecio() {
        return precio;
    }
    
    public void asignarDatosProducto(int codigoBarras) {
        // VALIDAMOS QUE EXISTA EN DB
        if (productoDAO.consultarExistePorBarras(codigoBarras)) {
            this.productoID       = productoDAO.consultarID(codigoBarras);
            this.nombre           = productoDAO.consultarNombrePorBarras(codigoBarras);
            this.precio           = productoDAO.consultarPrecioPorBarras(codigoBarras);
            this.descripcion      = productoDAO.consultarDescripcionPorBarras(codigoBarras);
            this.stock            = productoDAO.consultarStockPorBarras(codigoBarras);
            this.codigoBarras     = codigoBarras;
            this.ubicacionAlmacen = productoDAO.consultarUbicacionAlmacenPorBarras(codigoBarras);
        }        
    }
    
    public static Object[] consultarDatosProducto(int codigoBarras) {
        Object[] object = new Object[7];
        // VALIDAMOS QUE EXISTA EN DB
        if (productoDAO.consultarExistePorBarras(codigoBarras)) {
            object[0] = productoDAO.consultarID(codigoBarras);
            object[1] = productoDAO.consultarNombrePorBarras(codigoBarras);
            object[2] = productoDAO.consultarPrecioPorBarras(codigoBarras);
            object[3] = productoDAO.consultarDescripcionPorBarras(codigoBarras);
            object[4] = productoDAO.consultarStockPorBarras(codigoBarras);
            object[5] = codigoBarras;
            object[6] = productoDAO.consultarUbicacionAlmacenPorBarras(codigoBarras);
        } else {
            for (int i = 0; i < object.length; i++) {
                object[i] = "PRODUCTO NO EXISTE";
            }
        }
        return object;
    }
}
