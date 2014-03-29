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

import java.io.IOException;

import static bbdd2.p2.persistencia.Contenedor.eliminarBD;
import static bbdd2.p2.pruebas.Datos.*;

public class PruebaCoherencia {

    public static void main(String[] args) throws ClienteException, CuentaException, IOException {
        eliminarBD();

        /* Agregamos los datos */
        agregarClientes();
        agregarCuentas();

        /* Mostramos que los clientes no estan aun asociados a cuentas */
        System.out.printf("\nClientes sin referencia a cuentas:\n");
        mostrarClientes();

        /* Actualizamos los clientes para asociarlos a cuentas */
        actualizarClientes();

        /* Mostramos los clientes asociados */
        System.out.printf("\nClientes actualizados (con referencia a cuentas):\n");
        mostrarClientes();

        /* Eliminamos las cuentas */
        eliminarCuentas();

        /* Comprobamos como los clientes han perdido las referencias a las cuentas */
        System.out.println("\nEliminadas las cuentas. Los clientes vuelven a no tener referencias a cuentas:\n");
        mostrarClientes();

        /* Eliminamos el resto de datos */
        eliminarClientes();
    }
}