package bbdd2.p2.pruebas;

import bbdd2.p2.beans.CAhorro;
import bbdd2.p2.beans.CCorriente;
import bbdd2.p2.beans.Cliente;
import bbdd2.p2.crud.ClienteCRUD;
import bbdd2.p2.crud.ClienteException;
import bbdd2.p2.crud.CuentaCRUD;
import bbdd2.p2.crud.CuentaException;

import java.util.LinkedList;

/**
 * Clase con datos de prueba para realizar pruebas
 * sobre la base de datos.
 *
 * @author Cristofer
 */
public class Datos {

    /**
     * *********
     * CLIENTES *
     * **********
     */
    /* Clientes de cuenta1 */
    static Cliente cliente1 = new Cliente(98347298, "Alberto", "Romero", "Ap #741-9479 In St.", 24, 975685329, "alb@aol.com", null);
    static Cliente cliente2 = new Cliente(47976294, "Leticia", "Montero", "297-8336 Ut Av.", 18, 968196804, "let@aol.com", null);
    static Cliente cliente3 = new Cliente(83571235, "Isabel", "Valer", "P.O. Box 785, 492 Amet St.", 57, 840918908, "isa@aol.com", null);
    /* Cliente de cuenta2 */
    static Cliente cliente4 = new Cliente(97239508, "Ignacio", "Isaar", "7749 Etiam Avenue", 31, 985495409, "ign@aol.com", null);
    /*Clientes de cuenta3 */
    static Cliente cliente5 = new Cliente(23091283, "Rosa", "Sanz", "1404 Turpis Rd.", 31, 654095409, "ros@aol.com", null);
    static Cliente cliente6 = new Cliente(11295882, "Alberto", "Redondo", "148-5851 Arcu. St.", 72, 684680468, "alt@aol.com", null);
    static Cliente cliente7 = new Cliente(48320958, "Ana", "Garcia", "1428 Erat, Rd.", 19, 941685401, "ana@aol.com", null);
    static Cliente cliente8 = new Cliente(21349012, "Mayra", "Sainz", "P.O. Box 481, 964 Street", 19, 681980646, "may@aol.com", null);

    /**
     * ********
     * CUENTAS *
     * *********
     */
    static LinkedList<Integer> listaClientesCuenta1 = new LinkedList<Integer>();
    static LinkedList<Integer> listaClientesCuenta2 = new LinkedList<Integer>();
    static LinkedList<Integer> listaClientesCuenta3 = new LinkedList<Integer>();

    static {
        listaClientesCuenta1.add(98347298);     // Cliente1
        listaClientesCuenta1.add(47976294);     // Cliente2
        listaClientesCuenta1.add(83571235);     // Cliente3
        listaClientesCuenta2.add(97239508);     // Cliente4
        listaClientesCuenta3.add(23091283);     // Cliente5
        listaClientesCuenta3.add(11295882);     // Cliente6
        listaClientesCuenta3.add(48320958);     // Cliente7
        listaClientesCuenta3.add(21349012);     // Cliente8
    }

    static CAhorro cuenta1 = new CAhorro("1", null, listaClientesCuenta1, null, null, 2560, 2);
    static CCorriente cuenta2 = new CCorriente("2", null, listaClientesCuenta2, null, null, 1960, null);
    static CCorriente cuenta3 = new CCorriente("3", null, listaClientesCuenta3, null, null, 12990, null);


    /**
     * **********************
     * CLIENTES ACTUALIZADOS *
     * ***********************
     */
    static LinkedList<String> listaCuentasCliente1 = new LinkedList<String>();
    static LinkedList<String> listaCuentasCliente2 = new LinkedList<String>();
    static LinkedList<String> listaCuentasCliente3 = new LinkedList<String>();
    static LinkedList<String> listaCuentasCliente4 = new LinkedList<String>();
    static LinkedList<String> listaCuentasCliente5 = new LinkedList<String>();
    static LinkedList<String> listaCuentasCliente6 = new LinkedList<String>();
    static LinkedList<String> listaCuentasCliente7 = new LinkedList<String>();
    static LinkedList<String> listaCuentasCliente8 = new LinkedList<String>();

    static {
        listaCuentasCliente1.add("1");     // Cliente1
        listaCuentasCliente2.add("1");     // Cliente2
        listaCuentasCliente3.add("1");     // Cliente3
        listaCuentasCliente4.add("2");     // Cliente4
        listaCuentasCliente5.add("3");     // Cliente5
        listaCuentasCliente6.add("3");     // Cliente6
        listaCuentasCliente7.add("3");     // Cliente7
        listaCuentasCliente8.add("3");     // Cliente8
    }

    /* Clientes actualizados de cuenta1 */
    static Cliente clienteAct1 = new Cliente(98347298, "Alberto", "Romero", "Ap #741-9479 In St.", 24, 975685329, "alb@aol.com", listaCuentasCliente1);
    static Cliente clienteAct2 = new Cliente(47976294, "Leticia", "Montero", "297-8336 Ut Av.", 18, 968196804, "let@aol.com", listaCuentasCliente2);
    static Cliente clienteAct3 = new Cliente(83571235, "Isabel", "Valer", "P.O. Box 785, 492 Amet St.", 57, 840918908, "isa@aol.com", listaCuentasCliente3);
    /* Cliente actualizados de cuenta2 */
    static Cliente clienteAct4 = new Cliente(97239508, "Ignacio", "Isaar", "7749 Etiam Avenue", 31, 985495409, "ign@aol.com", listaCuentasCliente4);
    /*Clientes actualizados de cuenta3 */
    static Cliente clienteAct5 = new Cliente(23091283, "Rosa", "Sanz", "1404 Turpis Rd.", 31, 654095409, "ros@aol.com", listaCuentasCliente5);
    static Cliente clienteAct6 = new Cliente(11295882, "Alberto", "Redondo", "148-5851 Arcu. St.", 72, 684680468, "alt@aol.com", listaCuentasCliente6);
    static Cliente clienteAct7 = new Cliente(48320958, "Ana", "Garcia", "1428 Erat, Rd.", 19, 941685401, "ana@aol.com", listaCuentasCliente7);
    static Cliente clienteAct8 = new Cliente(21349012, "Mayra", "Sainz", "P.O. Box 481, 964 Street", 19, 681980646, "may@aol.com", listaCuentasCliente8);

    static void agregarCuentas() throws CuentaException {
        CuentaCRUD.agregarCAhorro(cuenta1);
        CuentaCRUD.agregarCCorriente(cuenta2);
        CuentaCRUD.agregarCCorriente(cuenta3);
    }

    static void agregarClientes() throws ClienteException {
        ClienteCRUD.agregarCliente(cliente1);
        ClienteCRUD.agregarCliente(cliente2);
        ClienteCRUD.agregarCliente(cliente3);
        ClienteCRUD.agregarCliente(cliente4);
        ClienteCRUD.agregarCliente(cliente5);
        ClienteCRUD.agregarCliente(cliente6);
        ClienteCRUD.agregarCliente(cliente7);
        ClienteCRUD.agregarCliente(cliente8);
    }

    static void eliminarCuentas() throws CuentaException {
        CuentaCRUD.eliminarCuenta(cuenta1);
        CuentaCRUD.eliminarCuenta(cuenta2);
        CuentaCRUD.eliminarCuenta(cuenta3);
    }

    static void eliminarClientes() throws ClienteException {
        ClienteCRUD.eliminarCliente(cliente1);
        ClienteCRUD.eliminarCliente(cliente2);
        ClienteCRUD.eliminarCliente(cliente3);
        ClienteCRUD.eliminarCliente(cliente4);
        ClienteCRUD.eliminarCliente(cliente5);
        ClienteCRUD.eliminarCliente(cliente6);
        ClienteCRUD.eliminarCliente(cliente7);
        ClienteCRUD.eliminarCliente(cliente8);
    }

    static void actualizarClientes() throws ClienteException {
        ClienteCRUD.actualizarCliente(clienteAct1);
        ClienteCRUD.actualizarCliente(clienteAct2);
        ClienteCRUD.actualizarCliente(clienteAct3);
        ClienteCRUD.actualizarCliente(clienteAct4);
        ClienteCRUD.actualizarCliente(clienteAct5);
        ClienteCRUD.actualizarCliente(clienteAct6);
        ClienteCRUD.actualizarCliente(clienteAct7);
        ClienteCRUD.actualizarCliente(clienteAct8);
    }

    static void mostrarClientes() {
        System.out.printf(ClienteCRUD.encontrarCliente(cliente1.getDNI()).toString());
        System.out.printf(ClienteCRUD.encontrarCliente(cliente2.getDNI()).toString());
        System.out.printf(ClienteCRUD.encontrarCliente(cliente3.getDNI()).toString());
        System.out.printf(ClienteCRUD.encontrarCliente(cliente4.getDNI()).toString());
        System.out.printf(ClienteCRUD.encontrarCliente(cliente5.getDNI()).toString());
        System.out.printf(ClienteCRUD.encontrarCliente(cliente6.getDNI()).toString());
        System.out.printf(ClienteCRUD.encontrarCliente(cliente7.getDNI()).toString());
        System.out.printf(ClienteCRUD.encontrarCliente(cliente8.getDNI()).toString());
    }
}
