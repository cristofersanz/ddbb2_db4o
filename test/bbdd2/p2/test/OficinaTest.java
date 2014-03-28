/**
 * Author: Cristofer Sanz Blasco (584191)
 * Project: bbdd2p2
 * File: .java
 * Modified: 28/03/14
 * Description: 
 */
package bbdd2.p2.test;

import bbdd2.p2.beans.Oficina;
import bbdd2.p2.crud.OficinaCRUD;
import bbdd2.p2.crud.OficinaException;
import bbdd2.p2.persistencia.Contenedor;
import com.db4o.query.Predicate;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OficinaTest {

    private Oficina oficinaParametrosCorrectos = new Oficina("12345678901234567890",
            "paseo las ramblas, 10", 976123456);

    private Oficina oficinaRepetida = new Oficina("12345678901234567890",
            "echegaray", 97612);

    private Oficina oficinaParaActualizar = new Oficina("12345678901234567890",
            "castellana", 914243546);

    @BeforeClass
    public static void setupClass() throws IOException {
        Path dbPath = FileSystems.getDefault().getPath("database.db4o");
        if (Files.exists(dbPath)) {
            Files.delete(dbPath);
        }
    }

    @Test
    public void _1_agrega_oficina_con_parametros_correctos() throws OficinaException {
        OficinaCRUD.agregarOficina(oficinaParametrosCorrectos);
        Oficina oficinaRecuperada = OficinaCRUD.encontrarOficina(oficinaParametrosCorrectos.getCodigo());
        assertEquals(oficinaParametrosCorrectos, oficinaRecuperada);
    }

    @Test(expected = OficinaException.class)
    public void _2_agrega_oficina_repetida() throws OficinaException {
        OficinaCRUD.agregarOficina(oficinaRepetida);
    }

    @Test
    public void _3_actualiza_oficina_correcta() throws OficinaException {
        OficinaCRUD.actualizarOficina(oficinaParaActualizar);
        Oficina oficinaRecuperada = OficinaCRUD.encontrarOficina(oficinaParaActualizar.getCodigo());
        assertSame(oficinaParaActualizar, oficinaRecuperada);
    }


}
