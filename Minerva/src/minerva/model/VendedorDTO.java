package minerva.model;

/**
 *
 * @author L
 */
public class VendedorDTO {
    private long vendedorID;
    private String nombres;
    private String usuario;
    private String contrasena;
        
    public VendedorDTO() {
    }

    public VendedorDTO(long vendedorID, String nombres, String usuario) {
        this.vendedorID = vendedorID;
        this.nombres = nombres;
        this.usuario = usuario;
    }
    
    public long getVendedorID() {
        return vendedorID;
    }

    public void setVendedorID(long vendedorID) {
        this.vendedorID = vendedorID;             
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }   

    public String getContrasena() {
        return contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
