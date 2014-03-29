package bbdd2.p2.crud;

import bbdd2.p2.beans.Cliente;
import bbdd2.p2.beans.Cuenta;
import bbdd2.p2.persistencia.Contenedor;
import com.db4o.query.Predicate;

import java.util.Iterator;
import java.util.List;

/**
 * Implementa las operaciones CRUD (Create, Read, Update, Delete)
 * de la entidad Cliente sobre una base de datos db4o.
 * Todas las operaciones que realiza aseguran la coherencia en
 * la base de datos generando excepción si se hace referencia a
 * una instancia de una entidad no existente.
 *
 * @author Cristofer Sanz
 * @author David Enjuanes
 * @author Victor Arellano
 * @author Alejandro Bean
 * @author Guillermo Sese
 */
public class ClienteCRUD {

    public static void agregarCliente(Cliente cliente) throws ClienteException {
        comprobarNoExistenciaCliente(cliente);
        comprobarExistenciaCuentas(cliente);
        Contenedor.getInstancia().store(cliente);
    }

    public static Cliente encontrarCliente(final int DNI) {
        List<Cliente> clientes = Contenedor.getInstancia().query(new Predicate<Cliente>() {
            @Override
            public boolean match(Cliente cliente) {
                return cliente.getDNI() == DNI;
            }
        });

        if (clientes.size() == 0) {
            return null;
        } else {
            return clientes.get(0);
        }
    }

    public static void actualizarCliente(final Cliente cliente) throws ClienteException {
        Cliente clienteNuevo = actualizarParametrosCliente(cliente);
        comprobarExistenciaCuentas(cliente);
        Contenedor.getInstancia().store(clienteNuevo);
    }

    public static void eliminarCliente(final Cliente cliente) throws ClienteException {
        comprobarExistenciaCliente(cliente);
        Contenedor.getInstancia().delete(cliente);
        eliminarReferenciaDeCuenta(cliente);
    }

    private static void eliminarReferenciaDeCuenta(Cliente cliente) {
        if (cliente.getCuentas() != null) {
            for (final String cuenta : cliente.getCuentas()) {
                List<Cuenta> cuentas = Contenedor.getInstancia().query(new Predicate<Cuenta>() {
                    @Override
                    public boolean match(Cuenta cta) {
                        return cuenta.equals(cta.getNumero());
                    }
                });

                if (cuentas.size() != 0) {
                    for (Iterator<Integer> iterator = cuentas.get(0).getClientes().iterator(); iterator.hasNext(); ) {
                        int cl = iterator.next();
                        if (cl == cliente.getDNI()) {
                            iterator.remove();
                        }
                    }
                }
            }
        }
    }

    private static Cliente actualizarParametrosCliente(final Cliente cliente) throws ClienteException {
        Cliente clienteNuevo = comprobarExistenciaCliente(cliente);

        clienteNuevo.setNombre(cliente.getNombre());
        clienteNuevo.setApellidos(cliente.getApellidos());
        clienteNuevo.setDireccion(cliente.getDireccion());
        clienteNuevo.setEdad(cliente.getEdad());
        clienteNuevo.setEmail(cliente.getEmail());
        clienteNuevo.setTelefono(cliente.getTelefono());
        clienteNuevo.setCuentas(cliente.getCuentas());

        return clienteNuevo;
    }

    private static Cliente comprobarExistenciaCliente(final Cliente cliente) throws ClienteException {
        List<Cliente> clientes = Contenedor.getInstancia().query(new Predicate<Cliente>() {
            @Override
            public boolean match(Cliente cl) {
                return cliente.getDNI() == cl.getDNI();
            }
        });

        if (clientes.size() == 0) {
            throw new ClienteException("El cliente no existe.");
        }

        return clientes.get(0);
    }

    private static void comprobarNoExistenciaCliente(final Cliente cliente) throws ClienteException {
        List<Cliente> clientes = Contenedor.getInstancia().query(new Predicate<Cliente>() {
            @Override
            public boolean match(Cliente cl) {
                return cliente.getDNI() == cl.getDNI();
            }
        });

        if (clientes.size() != 0) {
            throw new ClienteException("El cliente ya existe.");
        }
    }

    private static void comprobarExistenciaCuentas(Cliente cliente) throws ClienteException {
        if (cliente.getCuentas() != null) {
            for (final String numeroCuenta : cliente.getCuentas()) {
                List<Cuenta> cuentas = Contenedor.getInstancia().query(new Predicate<Cuenta>() {
                    @Override
                    public boolean match(Cuenta cuenta) {
                        return cuenta.getNumero().equals(numeroCuenta);
                    }
                });

                if (cuentas.size() == 0) {
                    throw new ClienteException("Cuentas de cliente no existen.");
                }
            }
        }
    }
}
