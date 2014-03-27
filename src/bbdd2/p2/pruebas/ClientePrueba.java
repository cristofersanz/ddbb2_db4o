/**
 * Author: Cristofer Sanz Blasco (584191)
 * Project: bbdd2p2
 * File: .java
 * Modified: 27/03/14
 * Description: 
 */
package bbdd2.p2.pruebas;

import bbdd2.p2.beans.CAhorro;
import bbdd2.p2.beans.CCorriente;
import bbdd2.p2.beans.Cliente;
import bbdd2.p2.beans.Cuenta;
import bbdd2.p2.crud.ClienteCRUD;
import bbdd2.p2.crud.ClienteException;
import bbdd2.p2.crud.CuentaCRUD;
import bbdd2.p2.crud.CuentaException;
import bbdd2.p2.persistencia.Contenedor;
import com.db4o.query.Predicate;

import java.util.LinkedList;
import java.util.List;

public class ClientePrueba {
    public static void main(String[] args) throws ClienteException, CuentaException {
        CuentaCRUD.agregarCCorriente(new CCorriente("0", null, null, null, 0, null));
        Cuenta cuenta = CuentaCRUD.encontrarCuenta("0");
        CuentaCRUD.actualizarCuenta(new CCorriente("0", null, null, null, 2, null));
        CuentaCRUD.eliminarCuenta(cuenta);
    }
}
