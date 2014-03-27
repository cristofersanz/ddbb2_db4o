/**
 * Author: Cristofer Sanz Blasco (584191)
 * Project: bbdd2p2
 * File: .java
 * Modified: 27/03/14
 * Description: 
 */
package bbdd2.p2.pruebas;

import bbdd2.p2.beans.Cliente;
import bbdd2.p2.crud.ClienteCRUD;
import bbdd2.p2.crud.ClienteException;
import bbdd2.p2.persistencia.Contenedor;
import com.db4o.query.Predicate;

import java.util.LinkedList;
import java.util.List;

public class ClientePrueba {
    public static void main(String[] args) throws ClienteException {

        ClienteCRUD.agregarCliente(new Cliente(100, "Pepe", null, null, 0, 0, null, null));
        Cliente cliente = ClienteCRUD.encontrarCliente(100);
        ClienteCRUD.actualizarCliente(new Cliente(100, "Jose", null, null, 0, 0, null, null));
        cliente = ClienteCRUD.encontrarCliente(100);
        ClienteCRUD.eliminarCliente(cliente);
    }
}
