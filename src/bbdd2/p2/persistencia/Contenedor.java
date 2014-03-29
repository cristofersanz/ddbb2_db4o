package bbdd2.p2.persistencia;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Clase que permite conectar a la base de datos implementando
 * el patrón singleton. También permite eliminarla.
 *
 * @author Cristofer Sanz
 * @author David Enjuanes
 * @author Victor Arellano
 * @author Alejandro Bean
 * @author Guillermo Sese
 */
public class Contenedor {

    private static String DB_NAME = "database.db4o";

    private static ObjectContainer contenedor;

    private Contenedor() {
        contenedor = Db4oEmbedded.openFile(DB_NAME);
    }

    public static ObjectContainer getInstancia() {
        if (contenedor == null) {
            new Contenedor();
        }

        return contenedor;
    }

    public static void eliminarBD() throws IOException {
        Path dbPath = FileSystems.getDefault().getPath(DB_NAME);

        if (Files.exists(dbPath)) {
            Files.delete(dbPath);
        }
    }
}