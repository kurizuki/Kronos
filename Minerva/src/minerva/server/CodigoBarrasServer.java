package minerva.server;

/**
 *
 * @author L
 */
public class CodigoBarrasServer {
    private static long codigoBarras = 404;

    public CodigoBarrasServer() {
    }

    public CodigoBarrasServer(long codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public static long getCodigoBarras() {
        return codigoBarras;
    }

    public static void setCodigoBarras(long codigoBarras) {
        CodigoBarrasServer.codigoBarras = codigoBarras;
    }

}
