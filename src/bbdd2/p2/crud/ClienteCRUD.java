/**
 * Author: Cristofer Sanz Blasco (584191)
 * Project: bbdd2p2
 * File: .java
 * Modified: 27/03/14
 * Description: 
 */
package bbdd2.p2.crud;

import bbdd2.p2.beans.Cliente;
import bbdd2.p2.beans.Cuenta;
import bbdd2.p2.persistencia.Contenedor;
import com.db4o.query.Predicate;

import java.util.List;

public class ClienteCRUD {

    public static void agregarCliente(Cliente cliente) throws ClienteException {
        comprobarExistenciaCuentas(cliente);
        Contenedor.getInstancia().store(cliente);
    }

    private static void comprobarExistenciaCuentas(Cliente cliente) throws ClienteException {
        if (cliente.getCuentas() != null) {
            for (final String numeroCuenta : cliente.getCuentas()) {
                List<Cuenta> cuentas = Contenedor.getInstancia().query(new Predicate<Cuenta>() {
                    @Override
                    public boolean match(Cuenta cuenta) {
                        return cuenta.getNumero() == numeroCuenta;
                    }
                });

                if (cuentas.size() == 0) {
                    throw new ClienteException("Cuentas de cliente no existen.");
                }
            }
        }
    }
}
