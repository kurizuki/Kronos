package minerva.model.dto;

/**
 *
 * @author L
 */
public class DTOProveedor {
    private long proveedorID;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;

    public DTOProveedor() {
    }

    public DTOProveedor(long proveedorID, String nombre, String direccion, String telefono, String correo) {
        this.proveedorID = proveedorID;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }    
    
}
