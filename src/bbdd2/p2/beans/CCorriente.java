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

public class CCorriente extends Cuenta {

    /**
     * CREATE TYPE tipo_cCorriente UNDER tipo_cuenta(
     * cuentaOficina REFERENCES Oficina(codigo))
     * INSTANTIABLE NOT FINAL
     * REF IS SYSTEM GENERATED;
     */

    private String cuentaOficina;           // REFERENCES bbdd2.p2.beans.Oficina(codigo)

    public String getCuentaOficina() {
        return cuentaOficina;
    }

    public void setCuentaOficina(String cuentaOficina) {
        this.cuentaOficina = cuentaOficina;
    }

    public CCorriente(String numero, Date fecha, LinkedList<Integer> clientes,
                      LinkedList<HashMap<String, String>> operaciones, double saldo, String cuentaOficina) {
        super(numero, fecha, clientes, operaciones, saldo);
        this.cuentaOficina = cuentaOficina;
    }
}
