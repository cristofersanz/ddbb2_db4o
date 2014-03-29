package bbdd2.p2.crud;

/**
 * Clase de excepción arrojada en ClienteCRUD.
 *
 * @author Cristofer Sanz
 * @author David Enjuanes
 * @author Victor Arellano
 * @author Alejandro Bean
 * @author Guillermo Sese
 */
public class ClienteException extends Throwable {

    public ClienteException(String message) {
        super(message);
    }
}
