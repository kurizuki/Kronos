package minerva.model.dto;

/**
 *
 * @author L
 */
public class DTOCliente {
    // VARIALBLES DE LA DB
    private long clienteID;
    private String nombres = "ANONIMO";
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

    public long getClienteID() {
        return clienteID;
    }

    public void setClienteID(long clienteID) {
        this.clienteID = clienteID;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public long getEdad() {
        return edad;
    }

    public void setEdad(long edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
    
}
