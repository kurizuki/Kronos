package minerva.model.dto;

/**
 *
 * @author L
 */
public class DTOCliente {
    // VARIALBLES DE LA DB
    private long clienteID;
    private String nombres;
    private long edad;
    private String telefono;
    private String direccion;
    // -----------------------

    public DTOCliente() {
    }

    public DTOCliente(long clienteID, String nombres, long edad, String telefono, String direccion) {
        this.clienteID = clienteID;
        this.nombres = nombres;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    
    
}
