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

public class Contenedor {

    private static ObjectContainer contenedor;

    private Contenedor() {
        contenedor = Db4oEmbedded.openFile("database.db4o");
    }

    public static ObjectContainer getInstancia() {
        if (contenedor == null) {
            new Contenedor();
        }

        return contenedor;
    }
}
