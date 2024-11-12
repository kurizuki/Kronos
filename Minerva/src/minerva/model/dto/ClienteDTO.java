package minerva.model.dto;

/**
 *
 * @author L
 */
public class ClienteDTO {
    // VARIALBLES DE LA DB
    private long clienteID;
    private String nombres;
    private long edad;
    private String telefono;
    private String direccion;
    // -----------------------

    public ClienteDTO() {
    }

    public ClienteDTO(long clienteID, String nombres, long edad, String telefono, String direccion) {
        this.clienteID = clienteID;
        this.nombres = nombres;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    
    
}
