package bbdd2.p2.beans;

import java.util.Date;

/**
 * Author: Cristofer Sanz Blasco (584191)
 * Project: bbdd2p2
 * File: .java
 * Modified: 26/03/14
 * Description: 
 */

public class Operacion {


    /**
     * CREATE TYPE tipo_Operacion AS OBJECT(
     * codigo        NUMBER(9),
     * descripcion    VARCHAR(20),
     * tipo            VARCHAR(20),
     * cantidad        NUMBER(9),
     * fecha            DATE,
     * numero        REFERENCES Cuenta(numero));
     * INSTANTIABLE NOT FINAL
     * REF IS SYSTEM GENERATED;
     */

    /* PRIMARY KEY */
    private String codigo;
    private String numero;              // REFERENCES bbdd2.p2.beans.Cuenta(numero)

    private String descripcion;
    private String tipo;
    private int cantidad;
    private Date fecha;

}
