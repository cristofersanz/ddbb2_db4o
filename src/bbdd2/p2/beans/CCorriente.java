package bbdd2.p2.beans;

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

}
