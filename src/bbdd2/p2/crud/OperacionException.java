package bbdd2.p2.crud;

/**
 * Clase de excepción arrojada en OperacionCRUD.
 *
 * @author Cristofer Sanz
 * @author David Enjuanes
 * @author Victor Arellano
 * @author Alejandro Bean
 * @author Guillermo Sese
 */
public class OperacionException extends Exception {
    public OperacionException(String message) {
        super(message);
    }
}
