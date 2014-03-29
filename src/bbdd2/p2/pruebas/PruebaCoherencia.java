/**
 * Author: Cristofer Sanz Blasco (584191)
 * Project: bbdd2p2
 * File: .java
 * Modified: 27/03/14
 * Description: 
 */
package bbdd2.p2.pruebas;

import bbdd2.p2.crud.ClienteException;
import bbdd2.p2.crud.CuentaException;
import bbdd2.p2.persistencia.Contenedor;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import static bbdd2.p2.persistencia.Contenedor.eliminarBD;
import static bbdd2.p2.pruebas.Datos.*;

public class PruebaCoherencia {


    public static void main(String[] args) throws ClienteException, CuentaException, IOException {
        eliminarBD();

        /* Agregamos los datos */
        agregarClientes();
        agregarCuentas();

        /* Mostramos que los clientes no estan aun asociados a cuentas */
        mostrarClientes();

        /* Actualizamos los clientes para asociarlos a cuentas */
        actualizarClientes();

        /* Mostramos los clientes asociados */
        mostrarClientes();

        /* Eliminamos las cuentas */
        eliminarCuentas();

        /* Comprobamos como los clientes han perdido las referencias a las cuentas */
        mostrarClientes();

        /* Eliminamos el resto de datos */
        eliminarClientes();
    }
}