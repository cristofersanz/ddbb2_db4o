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
    private LinkedList<Integer> clientes;            // Referencia al PK de cada Cliente: DNI
    private LinkedList<HashMap<String, String>> operaciones;      // Referencia al PK de cada Operación: {codigo,numero}
    private double saldo;

    public String getNumero() {
        return numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public LinkedList<Integer> getClientes() {
        return clientes;
    }

    public LinkedList<HashMap<String, String>> getOperaciones() {
        return operaciones;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setClientes(LinkedList<Integer> clientes) {
        this.clientes = clientes;
    }

    public void setOperaciones(LinkedList<HashMap<String, String>> operaciones) {
        this.operaciones = operaciones;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cuenta(String numero, Date fecha, LinkedList<Integer> clientes,
                  LinkedList<HashMap<String, String>> operaciones, double saldo) {
        this.numero = numero;
        this.fecha = fecha;
        this.clientes = clientes;
        this.operaciones = operaciones;
        this.saldo = saldo;
    }
}
