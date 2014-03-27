package bbdd2.p2.beans;

/**
 * Author: Cristofer Sanz Blasco (584191)
 * Project: bbdd2p2
 * File: .java
 * Modified: 26/03/14
 * Description:
 */

public class Oficina {

    /**
     * CREATE TYPE tipo_oficina AS OBJECT(
     * codigo        NUMBER(20),
     * direccion        VARCHAR(30),
     * telefono        NUMBER(9))
     * REF IS SYSTEM GENERATED;
     */

    /* PRIMARY KEY */
    private String codigo;

    private String direccion;
    private int telefono;

    public String getCodigo() {
        return codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getTelefono() {
        return telefono;
    }
}
