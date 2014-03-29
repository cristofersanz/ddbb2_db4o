package bbdd2.p2.beans;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Author: Cristofer Sanz Blasco (584191)
 * Project: bbdd2p2
 * File: .java
 * Modified: 26/03/14
 * Description:
 */

public class CAhorro extends Cuenta {

    /**
     * CREATE TYPE tipo_cAhorro UNDER tipo_cuenta(
     * interes        NUMBER(3))
     * INSTANTIABLE NOT FINAL
     * REF IS SYSTEM GENERATED;
     */

    private int interes;

    public int getInteres() {
        return interes;
    }

    public void setInteres(int interes) {
        this.interes = interes;
    }

    public CAhorro(String numero, Date fecha, LinkedList<Integer> clientes,
                   LinkedList<HashMap<String, String>> operaciones,
                   LinkedList<HashMap<String, String>> destinoTransferencias, double saldo, int interes) {
        super(numero, fecha, clientes, operaciones, destinoTransferencias, saldo);
        this.interes = interes;
    }

    public String toString() {
        return super.toString() + " / " + getInteres() + "\n";
    }
}
