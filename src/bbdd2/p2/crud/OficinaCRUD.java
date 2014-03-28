/**
 * Author: Cristofer Sanz Blasco (584191)
 * Project: bbdd2p2
 * File: .java
 * Modified: 28/03/14
 * Description: 
 */
package bbdd2.p2.crud;

import bbdd2.p2.beans.Oficina;
import bbdd2.p2.persistencia.Contenedor;
import com.db4o.query.Predicate;

import java.util.List;

public class OficinaCRUD {

    public static void agregarOficina(Oficina oficina) throws OficinaException {
        comprobarNoExistenciaOficina(oficina);
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
