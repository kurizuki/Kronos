package minerva.model.dto;

/**
 *
 * @author L
 */
public class DTOProducto {
    // VARIALBLES DE LA DB
    private long productoID;
    private String nombre;
    private double precio;
    private String descripcion;
    private long stock;
    private long codigoBarras;
    private String ubicacionAlmacen = "";
    // -----------------------


    public DTOProducto() {
    }

    public DTOProducto(long productoID, String nombre, double precio, String descripcion, long stock, long codigoBarras, String ubicacionAlmacen) {
        this.productoID = productoID;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
        this.codigoBarras = codigoBarras;
        this.ubicacionAlmacen = ubicacionAlmacen;
    }

    public DTOProducto(String nombre, double precio, String descripcion, long stock, long codigoBarras, String ubicacionAlmacen) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
        this.codigoBarras = codigoBarras;
        this.ubicacionAlmacen = ubicacionAlmacen;
    }
    
    public long getProductoID() {
        return productoID;
    }

    public void setProductoID(long productoID) {
        this.productoID = productoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public long getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(long codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getUbicacionAlmacen() {
        return ubicacionAlmacen;
    }

    public void setUbicacionAlmacen(String ubicacionAlmacen) {
        this.ubicacionAlmacen = ubicacionAlmacen;
    }
    
    
    
}
