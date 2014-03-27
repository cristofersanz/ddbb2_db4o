package bbdd2.p2.beans;

import java.util.Date;

/**
 * Author: Cristofer Sanz Blasco (584191)
 * Project: bbdd2p2
 * File: .java
 * Modified: 26/03/14
 * Description:
 */

public class OperacionTR extends Operacion {

    /**
     * CREATE TYPE tipo_OperacionTransferencia UNDER tipo_Operacion(
     * cuentaTR REFERENCES Cuenta(numero))
     * INSTANTIABLE NOT FINAL
     * REF IS SYSTEM GENERATED;
     */

    private String cuentaTR;            // REFERENCES bbdd2.p2.beans.Cuenta(numero)

    public String getCuentaTR() {
        return cuentaTR;
    }

    public void setCuentaTR(String cuentaTR) {
        this.cuentaTR = cuentaTR;
    }

    public OperacionTR(String codigo, String numero, String descripcion,
                       String tipo, int cantidad, Date fecha, String cuentaTR) {
        super(codigo, numero, descripcion, tipo, cantidad, fecha);
        this.cuentaTR = cuentaTR;
    }
}
