/**
 * Author: Cristofer Sanz Blasco (584191)
 * Project: bbdd2p2
 * File: .java
 * Modified: 28/03/14
 * Description: 
 */
package bbdd2.p2.crud;

import bbdd2.p2.beans.CCorriente;
import bbdd2.p2.beans.Oficina;
import bbdd2.p2.beans.OperacionIR;
import bbdd2.p2.persistencia.Contenedor;
import com.db4o.query.Predicate;

import java.util.HashMap;
import java.util.List;

public class OficinaCRUD {

    public static void agregarOficina(Oficina oficina) throws OficinaException {
        comprobarNoExistenciaOficina(oficina);
        comprobarExistenciaCCorrientes(oficina);
        comprobarExistenciaOperacionesIR(oficina);
        Contenedor.getInstancia().store(oficina);
    }

    public static Oficina encontrarOficina(final String codigo) {
        List<Oficina> oficinas = Contenedor.getInstancia().query(new Predicate<Oficina>() {
            @Override
            public boolean match(Oficina of) {
                return of.getCodigo().equals(codigo);
            }
        });

        if (oficinas.size() == 0) {
            return null;
        } else {
            return oficinas.get(0);
        }
    }

    public static void actualizarOficina(Oficina oficina) throws OficinaException {
        Oficina oficinaNueva = actualizarParametrosOficina(oficina);
        comprobarExistenciaCCorrientes(oficina);
        comprobarExistenciaOperacionesIR(oficina);
        Contenedor.getInstancia().store(oficinaNueva);
    }

    private static Oficina actualizarParametrosOficina(Oficina oficina) throws OficinaException {
        Oficina oficinaNueva = comprobarExistenciaOficina(oficina);

        oficinaNueva.setDireccion(oficina.getDireccion());
        oficinaNueva.setTelefono(oficina.getTelefono());

        return oficinaNueva;
    }

    public static void eliminarOficina(Oficina oficina) throws OficinaException {
        comprobarExistenciaOficina(oficina);
        Contenedor.getInstancia().delete(oficina);
        eliminarReferenciaDeOperacionIR(oficina);
        eliminarReferenciaDeCCorriente(oficina);
    }

    private static void eliminarReferenciaDeCCorriente(Oficina oficina) {
        for (final String cCorriente : oficina.getcCorrientes()) {
            List<CCorriente> cCorrientes = Contenedor.getInstancia().query(new Predicate<CCorriente>() {
                @Override
                public boolean match(CCorriente cta) {
                    return cta.getNumero().equals(cCorriente);
                }
            });

            cCorrientes.get(0).setCuentaOficina(null);

        }
    }

    private static void eliminarReferenciaDeOperacionIR(Oficina oficina) {
        for (final HashMap<String, String> operacionIR : oficina.getOperacionesIR()) {
            List<OperacionIR> operacionesIR = Contenedor.getInstancia().query(new Predicate<OperacionIR>() {
                @Override
                public boolean match(OperacionIR opIR) {
                    return operacionIR.get("numero").equals(opIR.getNumero()) &&
                            operacionIR.get("codigo").equals(opIR.getCodigo());
                }
            });

            operacionesIR.get(0).setOficinaIR(null);

        }
    }

    private static void comprobarExistenciaOperacionesIR(Oficina oficina) throws OficinaException {
        if (oficina.getOperacionesIR() != null) {
            for (final HashMap<String, String> operacionIR : oficina.getOperacionesIR()) {
                List<OperacionIR> operacionesIR = Contenedor.getInstancia().query(new Predicate<OperacionIR>() {
                    @Override
                    public boolean match(OperacionIR opIR) {
                        return opIR.getCodigo().equals(operacionIR.get("codigo")) &&
                                opIR.getNumero().equals(operacionIR.get("numero"));
                    }
                });

                if (operacionesIR.size() == 0) {
                    throw new OficinaException("No existe la operacionIR.");
                }
            }
        }

    }

    private static void comprobarExistenciaCCorrientes(final Oficina oficina) throws OficinaException {
        if (oficina.getcCorrientes() != null) {
            for (final String cCorriente : oficina.getcCorrientes()) {
                List<CCorriente> cCorrientes = Contenedor.getInstancia().query(new Predicate<CCorriente>() {
                    @Override
                    public boolean match(CCorriente cC) {
                        return cC.getNumero().equals(cCorriente);
                    }
                });

                if (cCorrientes.size() == 0) {
                    throw new OficinaException("No existe la cuenta corriente.");
                }
            }
        }
    }

    public static Oficina comprobarExistenciaOficina(final Oficina oficina) throws OficinaException {
        List<Oficina> oficinas = Contenedor.getInstancia().query(new Predicate<Oficina>() {
            @Override
            public boolean match(Oficina of) {
                return of.getCodigo().equals(oficina.getCodigo());
            }
        });

        if (oficinas.size() == 0) {
            throw new OficinaException("La oficina no existe.");
        }

        return oficinas.get(0);
    }

    public static void comprobarNoExistenciaOficina(final Oficina oficina) throws OficinaException {
        List<Oficina> oficinas = Contenedor.getInstancia().query(new Predicate<Oficina>() {
            @Override
            public boolean match(Oficina of) {
                return of.getCodigo().equals(oficina.getCodigo());
            }
        });

        if (oficinas.size() > 0) {
            throw new OficinaException("Ya existe la oficina.");
        }
    }
}
