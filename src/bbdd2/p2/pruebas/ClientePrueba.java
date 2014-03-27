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
        LinkedList<String> cuentas = new LinkedList<String>();
        cuentas.add("01231");
        ClienteCRUD.agregarCliente(new Cliente(72891478, "Cristofer", "", "", 72, 975123, "", cuentas));
        List<Cliente> clientes = Contenedor.getInstancia().query(new Predicate<Cliente>() {
            @Override
            public boolean match(Cliente c) {
                return true;
            }
        });
        clientes.get(0);
    }
}
