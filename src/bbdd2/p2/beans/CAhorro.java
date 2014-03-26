package bbdd2.p2.beans;

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

    private byte interes;

}
