/**
 * Author: Cristofer Sanz Blasco (584191)
 * Project: bbdd2p2
 * File: .java
 * Modified: 29/03/14
 * Description: 
 */
package bbdd2.p2.pruebas;

import bbdd2.p2.beans.CCorriente;
import bbdd2.p2.beans.Cliente;
import bbdd2.p2.crud.ClienteException;
import bbdd2.p2.crud.CuentaException;
import bbdd2.p2.persistencia.Contenedor;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static bbdd2.p2.persistencia.Contenedor.eliminarBD;
import static bbdd2.p2.pruebas.Datos.*;

public class PruebaQBE {

    public static void main(String[] args) throws ClienteException, CuentaException, IOException {
        eliminarBD();

        /* Agregamos los datos */
        agregarClientes();
        agregarCuentas();
        actualizarClientes();

        /*****************
         * CONSULTAS QBE *
         *****************/
        /* (Query 1) Recuperar todos los clientes que se llamen Alberto */
        System.out.printf("\n\n(Query 1) Recuperar todos los clientes que se llamen Alberto\n");

        List<Cliente> clientesAlberto = Contenedor.getInstancia().queryByExample(
                new Cliente(0, "Alberto", null, null, 0, 0, null, null)
        );

        for (Cliente cliente : clientesAlberto) {
            System.out.printf(cliente.toString());
        }


        /* (Query 2) Recuperar todos los clientes pertenecientes a la cuenta con número 3 */
        System.out.printf("\n\n(Query 2) Recuperar todos los clientes pertenecientes a la cuenta con número 3\n");

        LinkedList<String> numerosCuenta = new LinkedList<String>();
        numerosCuenta.add("3");

        List<Cliente> clientesCuenta3 = Contenedor.getInstancia().queryByExample(
                new Cliente(0, null, null, null, 0, 0, null, numerosCuenta)
        );

        for (Cliente cliente : clientesCuenta3) {
            System.out.printf(cliente.toString());
        }


        /* (Query 3) Recuperar todas las cuentas corrientes */
        System.out.printf("\n\n(Query 3) Recuperar todas las cuentas corrientes\n");

        List<CCorriente> cuentasCorrientes = Contenedor.getInstancia().queryByExample(
                CCorriente.class
        );

        for (CCorriente cCorriente : cuentasCorrientes) {
            System.out.printf(cCorriente.toString());
        }
    }
}
