package minerva.model.dto;

/**
 *
 * @author L
 */
public class ProveedorDTO {
    private long proveedorID;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;

    public ProveedorDTO() {
    }

    public ProveedorDTO(long proveedorID, String nombre, String direccion, String telefono, String correo) {
        this.proveedorID = proveedorID;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }    
    
}
