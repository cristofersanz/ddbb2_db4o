package bbdd2.p2.beans;

/**
 * Author: Cristofer Sanz Blasco (584191)
 * Project: bbdd2p2
 * File: .java
 * Modified: 26/03/14
 * Description:
 */

public class OperacionIR extends Operacion {

    /**
     * CREATE TYPE tipo_OperacionIngresoRetiro UNDER tipo_Operacion(
     * oficinaIR REFERENCES Oficina(codigo))
     * INSTANTIABLE NOT FINAL
     * REF IS SYSTEM GENERATED;
     */

    private String oficinaIR;                    // REFERENCES bbdd2.p2.beans.Oficina(codigo)

}
