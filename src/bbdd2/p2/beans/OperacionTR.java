package bbdd2.p2.beans;

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

}
