package bbdd2.p2.crud;

import bbdd2.p2.beans.*;
import bbdd2.p2.persistencia.Contenedor;
import com.db4o.query.Predicate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Implementa las operaciones CRUD (Create, Read, Update, Delete)
 * de la entidad Operacion, así como, OperacionTR y OperacionIR,
 * sobre una base de datos db4o.
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
public class OperacionCRUD {

    public static void agregarOperacionIR(OperacionIR operacion) throws OperacionException {
        comprobarNoExistenciaOperacion(operacion);
        comprobarExistenciaCuenta(operacion);
        comprobarExistenciaOficina(operacion);

        Contenedor.getInstancia().store(operacion);
    }

    public static void agregarOperacionTR(OperacionTR operacion) throws OperacionException {
        comprobarNoExistenciaOperacion(operacion);
        comprobarExistenciaCuenta(operacion);
        comprobarExistenciaCuentaDestino(operacion);

        Contenedor.getInstancia().store(operacion);
    }

    public static Operacion encontrarOperacion(final HashMap<String, String> pkOperacion) {
        List<Operacion> operaciones = Contenedor.getInstancia().query(new Predicate<Operacion>() {
            @Override
            public boolean match(Operacion operacion) {
                return pkOperacion.get("codigo").equals(operacion.getCodigo()) &&
                        pkOperacion.get("numero").equals(operacion.getNumero());
            }
        });

        if (operaciones.size() == 0) {
            return null;
        } else {
            return operaciones.get(0);
        }
    }

    public static void actualizarOperacion(Operacion operacion) throws OperacionException {
        Operacion nuevaOperacion;

        if (operacion.getClass() == OperacionIR.class) {
            nuevaOperacion = actualizarParametrosOperacionIR((OperacionIR) operacion);
            comprobarExistenciaOficina((OperacionIR) operacion);

        } else { /* operacion.getClass() == OperacionTR.class */
            nuevaOperacion = actualizarParametrosOperacionTR((OperacionTR) operacion);
            comprobarExistenciaCuentaDestino((OperacionTR) operacion);
        }

        comprobarExistenciaCuenta(operacion);

        Contenedor.getInstancia().store(nuevaOperacion);
    }

    private static Operacion actualizarParametrosOperacionIR(OperacionIR operacion) throws OperacionException {
        OperacionIR operacionNueva = (OperacionIR) comprobarExistenciaOperacion(operacion);

        operacionNueva.setDescripcion(operacion.getDescripcion());
        operacionNueva.setTipo(operacion.getTipo());
        operacionNueva.setCantidad(operacion.getCantidad());
        operacionNueva.setFecha(operacion.getFecha());
        operacionNueva.setOficinaIR(operacion.getOficinaIR());

        return operacionNueva;
    }

    private static Operacion actualizarParametrosOperacionTR(OperacionTR operacion) throws OperacionException {
        OperacionTR operacionNueva = (OperacionTR) comprobarExistenciaOperacion(operacion);

        operacionNueva.setDescripcion(operacion.getDescripcion());
        operacionNueva.setTipo(operacion.getTipo());
        operacionNueva.setCantidad(operacion.getCantidad());
        operacionNueva.setFecha(operacion.getFecha());
        operacionNueva.setCuentaTR(operacion.getCuentaTR());

        return operacionNueva;
    }

    public static void eliminarOperacion(Operacion operacion) throws OperacionException {
        comprobarExistenciaOperacion(operacion);
        Contenedor.getInstancia().delete(operacion);
        eliminarReferenciaDeCuenta(operacion);

        if (operacion.getClass() == OperacionTR.class) {
            eliminarReferenciaDeCuentaDestino((OperacionTR) operacion);
        } else { /* operacion.getClass() == OpertacionIR.class */
            eliminarReferenciaDeOficina((OperacionIR) operacion);
        }
    }

    private static void eliminarReferenciaDeOficina(final OperacionIR operacion) {
        List<Oficina> oficinas = Contenedor.getInstancia().query(new Predicate<Oficina>() {
            @Override
            public boolean match(Oficina oficina) {
                return oficina.getCodigo().equals(operacion.getOficinaIR());
            }
        });

        if (oficinas.size() != 0) {
            for (Iterator<HashMap<String, String>> iterator = oficinas.get(0).getOperacionesIR().iterator(); iterator.hasNext(); ) {
                HashMap<String, String> pkOperacion = iterator.next();
                if (pkOperacion.get("numero").equals(operacion.getNumero()) &&
                        pkOperacion.get("codigo").equals(operacion.getCodigo())) {
                    iterator.remove();
                }
            }
        }
    }

    private static void eliminarReferenciaDeCuentaDestino(final OperacionTR operacion) {
        List<Cuenta> cuentas = Contenedor.getInstancia().query(new Predicate<Cuenta>() {
            @Override
            public boolean match(Cuenta cuenta) {
                return cuenta.getNumero().equals(operacion.getCuentaTR());
            }
        });

        if (cuentas.size() != 0) {
            for (Iterator<HashMap<String, String>> iterator = cuentas.get(0).getDestinoTransferencias().iterator(); iterator.hasNext(); ) {
                HashMap<String, String> pkOperacion = iterator.next();
                if (pkOperacion.get("numero").equals(operacion.getNumero()) &&
                        pkOperacion.get("codigo").equals(operacion.getCodigo())) {
                    iterator.remove();
                }
            }
        }
    }

    private static void eliminarReferenciaDeCuenta(final Operacion operacion) {
        List<Cuenta> cuentas = Contenedor.getInstancia().query(new Predicate<Cuenta>() {
            @Override
            public boolean match(Cuenta cuenta) {
                return cuenta.getNumero().equals(operacion.getNumero());
            }
        });

        if (cuentas.size() != 0) {
            for (Iterator<HashMap<String, String>> iterator = cuentas.get(0).getOperaciones().iterator(); iterator.hasNext(); ) {
                HashMap<String, String> pkOperacion = iterator.next();
                if (pkOperacion.get("numero").equals(operacion.getNumero()) &&
                        pkOperacion.get("codigo").equals(operacion.getCodigo())) {
                    iterator.remove();
                }
            }
        }
    }

    private static Operacion comprobarExistenciaOperacion(final Operacion operacion) throws OperacionException {
        List<Operacion> operaciones = Contenedor.getInstancia().query(new Predicate<Operacion>() {
            @Override
            public boolean match(Operacion op) {
                return op.getCodigo().equals(operacion.getCodigo()) &&
                        op.getNumero().equals(operacion.getNumero());
            }
        });

        if (operaciones.size() == 0) {
            throw new OperacionException("No existe la operacion.");
        }

        return operaciones.get(0);
    }

    private static void comprobarNoExistenciaOperacion(final Operacion operacion) throws OperacionException {
        List<Operacion> operaciones = Contenedor.getInstancia().query(new Predicate<Operacion>() {
            @Override
            public boolean match(Operacion op) {
                return op.getCodigo().equals(operacion.getCodigo()) &&
                        op.getNumero().equals(operacion.getNumero());
            }
        });

        if (operaciones.size() > 0) {
            throw new OperacionException("Ya existe la operacion.");
        }
    }

    private static void comprobarExistenciaCuenta(final Operacion operacion) throws OperacionException {
        List<Cuenta> cuentas = Contenedor.getInstancia().query(new Predicate<Cuenta>() {
            @Override
            public boolean match(Cuenta cuenta) {
                return cuenta.getNumero().equals(operacion.getNumero());
            }
        });

        if (cuentas.size() == 0) {
            throw new OperacionException("No existe la cuenta.");
        }
    }

    private static void comprobarExistenciaOficina(final OperacionIR operacion) throws OperacionException {
        List<Oficina> oficinas = Contenedor.getInstancia().query(new Predicate<Oficina>() {
            @Override
            public boolean match(Oficina oficina) {
                return oficina.getCodigo().equals(operacion.getOficinaIR());
            }
        });

        if (oficinas.size() == 0) {
            throw new OperacionException("No existe la oficina.");
        }
    }

    private static void comprobarExistenciaCuentaDestino(final OperacionTR operacion) throws OperacionException {
        List<Cuenta> cuentas = Contenedor.getInstancia().query(new Predicate<Cuenta>() {
            @Override
            public boolean match(Cuenta cuenta) {
                return cuenta.getNumero().equals(operacion.getCuentaTR());
            }
        });

        if (cuentas.size() == 0) {
            throw new OperacionException("No existe la cuenta destino.");
        }
    }
}
