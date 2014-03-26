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

public class Cuenta {

    /**
     * CREATE TYPE tipo_cuenta AS OBJECT(
     * numero        NUMBER(20),
     * fecha            DATE,
     * clientes        listaClientes,
     * operaciones    listaOperaciones,
     * saldo            NUMBER(20))
     * NOT FINAL REF IS SYSTEM GENERATED;
     */

    /* PRIMARY KEY */
    private String numero;

    private Date fecha;
    private LinkedList<String> clientes;            // Referencia al PK de cada Cliente: DNI
    private LinkedList<HashMap<String,String>> operaciones;      // Referencia al PK de cada Operación: {codigo,numero}
    private double saldo;

}
