/**
 * Author: Cristofer Sanz Blasco (584191)
 * Project: bbdd2p2
 * File: .java
 * Modified: 27/03/14
 * Description: 
 */
package bbdd2.p2.crud;

import bbdd2.p2.beans.*;
import bbdd2.p2.persistencia.Contenedor;
import com.db4o.query.Predicate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CuentaCRUD {

    public static void agregarCAhorro(CAhorro cAhorro) throws CuentaException {
        comprobarNoExistenciaCuenta(cAhorro);
        comprobarExistenciaClientes(cAhorro);
        comprobarExistenciaOperaciones(cAhorro);
        comprobarExistenciaDestinoTransferencias(cAhorro);

        Contenedor.getInstancia().store(cAhorro);
    }

    public static void agregarCCorriente(CCorriente cCorriente) throws CuentaException {
        comprobarNoExistenciaCuenta(cCorriente);
        comprobarExistenciaClientes(cCorriente);
        comprobarExistenciaOperaciones(cCorriente);
        comprobarExistenciaOficina(cCorriente);
        comprobarExistenciaDestinoTransferencias(cCorriente);

        Contenedor.getInstancia().store(cCorriente);
    }

    public static Cuenta encontrarCuenta(final String numero) {
        List<Cuenta> cuentas = Contenedor.getInstancia().query(new Predicate<Cuenta>() {
            @Override
            public boolean match(Cuenta cuenta) {
                return cuenta.getNumero().equals(numero);
            }
        });

        if (cuentas.size() == 0) {
            return null;
        } else {
            return cuentas.get(0);
        }
    }

    public static void actualizarCuenta(Cuenta cuenta) throws CuentaException {
        Cuenta nuevaCuenta;

        if (cuenta.getClass() == CAhorro.class) {
            nuevaCuenta = actualizarParametrosCAhorro((CAhorro) cuenta);
        } else { /* cuenta.getClass() == CCorriente.class */
            nuevaCuenta = actualizarParametrosCCorriente((CCorriente) cuenta);
            comprobarExistenciaOficina((CCorriente) cuenta);                  //TODO Comprobar que no falla el casteo (CCorriente)
        }

        comprobarExistenciaClientes(cuenta);
        comprobarExistenciaOperaciones(cuenta);
        comprobarExistenciaDestinoTransferencias(cuenta);

        Contenedor.getInstancia().store(nuevaCuenta);
    }

    public static void eliminarCuenta(Cuenta cuenta) throws CuentaException {
        comprobarExistenciaCuenta(cuenta);
        Contenedor.getInstancia().delete(cuenta);
        eliminarReferenciaDeCliente(cuenta);
        eliminarReferenciaDeOperacion(cuenta);
        eliminarReferenciaDeDestinoTransferencia(cuenta);
        if (cuenta.getClass() == CCorriente.class) {
            eliminarReferenciaDeCCorriente((CCorriente) cuenta);
        }
    }

    private static void eliminarReferenciaDeCCorriente(final CCorriente cuenta) {
        List<Oficina> oficinas = Contenedor.getInstancia().query(new Predicate<Oficina>() {
            @Override
            public boolean match(Oficina oficina) {
                return cuenta.getCuentaOficina().equals(oficina.getCodigo());
            }
        });

        if (oficinas.size() != 0) {
            for (Iterator<String> iterator = oficinas.get(0).getcCorrientes().iterator(); iterator.hasNext(); ) {
                String cta = iterator.next();
                if (cta.equals(cuenta.getNumero())) {
                    iterator.remove();
                }
            }
        }
    }

    private static void eliminarReferenciaDeDestinoTransferencia(Cuenta cuenta) {
        if (cuenta.getDestinoTransferencias() != null) {
            for (final HashMap<String, String> destinoTransferencia : cuenta.getDestinoTransferencias()) {
                List<OperacionTR> operacionesTR = Contenedor.getInstancia().query(new Predicate<OperacionTR>() {
                    @Override
                    public boolean match(OperacionTR opTR) {
                        return destinoTransferencia.get("numero").equals(opTR.getNumero()) &&
                                destinoTransferencia.get("codigo").equals(opTR.getCodigo());
                    }
                });

                if (operacionesTR.size() != 0) {
                    operacionesTR.get(0).setNumero(null);
                }
            }
        }
    }

    private static void eliminarReferenciaDeOperacion(Cuenta cuenta) {
        if (cuenta.getOperaciones() != null) {
            for (final HashMap<String, String> operacion : cuenta.getOperaciones()) {
                List<Operacion> operaciones = Contenedor.getInstancia().query(new Predicate<Operacion>() {
                    @Override
                    public boolean match(Operacion op) {
                        return operacion.get("numero").equals(op.getNumero()) &&
                                operacion.get("codigo").equals(op.getCodigo());
                    }
                });

                if (operaciones.size() != 0) {
                    operaciones.get(0).setNumero(null);
                }
            }
        }
    }

    private static void eliminarReferenciaDeCliente(Cuenta cuenta) {
        if (cuenta.getClientes() != null) {
            for (final int cliente : cuenta.getClientes()) {
                List<Cliente> clientes = Contenedor.getInstancia().query(new Predicate<Cliente>() {
                    @Override
                    public boolean match(Cliente cl) {
                        return cliente == cl.getDNI();
                    }
                });

                if (clientes.size() != 0) {
                    for (Iterator<String> iterator = clientes.get(0).getCuentas().iterator(); iterator.hasNext(); ) {
                        String cta = iterator.next();
                        if (cta.equals(cuenta.getNumero())) {
                            iterator.remove();
                        }
                    }
                }
            }
        }
    }

    private static Cuenta actualizarParametrosCCorriente(final CCorriente cuenta) throws CuentaException {
        CCorriente cuentaNueva = (CCorriente) comprobarExistenciaCuenta(cuenta);

        cuentaNueva.setFecha(cuenta.getFecha());
        cuentaNueva.setClientes(cuenta.getClientes());
        cuentaNueva.setOperaciones(cuenta.getOperaciones());
        cuentaNueva.setSaldo(cuenta.getSaldo());
        cuentaNueva.setCuentaOficina(cuenta.getCuentaOficina());

        return cuentaNueva;
    }

    private static Cuenta actualizarParametrosCAhorro(final CAhorro cuenta) throws CuentaException {
        CAhorro cuentaNueva = (CAhorro) comprobarExistenciaCuenta(cuenta);

        cuentaNueva.setFecha(cuenta.getFecha());
        cuentaNueva.setClientes(cuenta.getClientes());
        cuentaNueva.setOperaciones(cuenta.getOperaciones());
        cuentaNueva.setSaldo(cuenta.getSaldo());
        cuentaNueva.setInteres(cuenta.getInteres());

        return cuentaNueva;
    }

    private static void comprobarExistenciaOficina(final CCorriente cCorriente) throws CuentaException {
        if (cCorriente.getCuentaOficina() != null) {
            List<Oficina> oficinas = Contenedor.getInstancia().query(new Predicate<Oficina>() {
                @Override
                public boolean match(Oficina oficina) {
                    return oficina.getCodigo().equals(cCorriente.getCuentaOficina());
                }
            });

            if (oficinas.size() == 0) {
                throw new CuentaException("No existe la oficina.");
            }
        }
    }

    private static void comprobarExistenciaDestinoTransferencias(Cuenta cuenta) throws CuentaException {
        if (cuenta.getDestinoTransferencias() != null) {
            for (final HashMap<String, String> destinoTransferencia : cuenta.getOperaciones()) {
                List<Operacion> operaciones = Contenedor.getInstancia().query(new Predicate<Operacion>() {
                    @Override
                    public boolean match(Operacion operacion) {
                        return operacion.getCodigo().equals(destinoTransferencia.get("codigo")) &&
                                operacion.getNumero().equals(destinoTransferencia.get("numero"));
                    }
                });

                if (operaciones.size() == 0) {
                    throw new CuentaException("No existen operaciones.");
                }
            }
        }
    }

    private static void comprobarExistenciaOperaciones(Cuenta cuenta) throws CuentaException {
        if (cuenta.getOperaciones() != null) {
            for (final HashMap<String, String> operacion : cuenta.getOperaciones()) {
                List<Operacion> operaciones = Contenedor.getInstancia().query(new Predicate<Operacion>() {
                    @Override
                    public boolean match(Operacion op) {
                        return op.getCodigo().equals(operacion.get("codigo")) &&
                                op.getNumero().equals(operacion.get("numero"));
                    }
                });

                if (operaciones.size() == 0) {
                    throw new CuentaException("No existen operaciones.");
                }
            }
        }
    }

    private static void comprobarExistenciaClientes(Cuenta cuenta) throws CuentaException {
        if (cuenta.getClientes() != null) {
            for (final int cliente : cuenta.getClientes()) {
                List<Cliente> clientes = Contenedor.getInstancia().query(new Predicate<Cliente>() {
                    @Override
                    public boolean match(Cliente cl) {
                        return cliente == cl.getDNI();
                    }
                });

                if (clientes.size() == 0) {
                    throw new CuentaException("No existen clientes.");
                }
            }
        }
    }

    private static void comprobarNoExistenciaCuenta(final Cuenta cuenta) throws CuentaException {
        List<Cuenta> cuentas = Contenedor.getInstancia().query(new Predicate<Cuenta>() {
            @Override
            public boolean match(Cuenta cta) {
                return cuenta.getNumero().equals(cta.getNumero());
            }
        });

        if (cuentas.size() > 0) {
            throw new CuentaException("La cuenta ya existe.");
        }
    }

    private static Cuenta comprobarExistenciaCuenta(final Cuenta cuenta) throws CuentaException {
        List<Cuenta> cuentas = Contenedor.getInstancia().query(new Predicate<Cuenta>() {
            @Override
            public boolean match(Cuenta cta) {
                return cuenta.getNumero().equals(cta.getNumero());
            }
        });

        if (cuentas.size() == 0) {
            throw new CuentaException("La cuenta no existe.");
        }

        return cuentas.get(0);
    }
}