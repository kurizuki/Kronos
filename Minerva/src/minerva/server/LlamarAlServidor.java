package minerva.server;

/**.
 *
 * @author L
 */
public class LlamarAlServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServidorHTTP servidor = new ServidorHTTP();
        servidor.iniciar();
    }
    
}
