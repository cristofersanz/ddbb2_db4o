/**
 * Author: Cristofer Sanz Blasco (584191)
 * Project: bbdd2p2
 * File: .java
 * Modified: 27/03/14
 * Description: 
 */
package bbdd2.p2.persistencia;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Contenedor {

    private static String DB_NAME = "database.db4o";

    private static ObjectContainer contenedor;

    private Contenedor() {
        contenedor = Db4oEmbedded.openFile(DB_NAME);       // TODO Evitar hardcodear el nombre de la BD
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
            Files.delete(dbPath);    // TODO Evitar hardcodear el nombre de la BD
        }
    }
}