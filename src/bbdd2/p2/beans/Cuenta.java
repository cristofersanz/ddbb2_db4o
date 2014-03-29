package bbdd2.p2.beans;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Bean que implementa la entidad Cuenta.
 * El esquema objet/relacional es:
 *  CREATE TYPE tipo_cuenta AS OBJECT(
 *  numero        NUMBER(20),
 *  fecha            DATE,
 *  clientes        listaClientes,
 *  operaciones    listaOperaciones,
 *  saldo            NUMBER(20))
 *  NOT FINAL REF IS SYSTEM GENERATED;
 *
 *  @author Cristofer Sanz
 */
public class Cuenta {

    /* PRIMARY KEY */
    private String numero;

    private Date fecha;
    private LinkedList<Integer> clientes;            // Referencia al PK de cada Cliente: DNI
    private LinkedList<HashMap<String, String>> operaciones;      // Referencia al PK de cada Operación: {codigo,numero}
    private LinkedList<HashMap<String, String>> destinoTransferencias;
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

    public LinkedList<HashMap<String, String>> getDestinoTransferencias() {
        return destinoTransferencias;
    }

    public void setDestinoTransferencias(LinkedList<HashMap<String, String>> destinoTransferencias) {
        this.destinoTransferencias = destinoTransferencias;
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
                  LinkedList<HashMap<String, String>> operaciones,
                  LinkedList<HashMap<String, String>> destinoTransferencias, double saldo) {
        this.numero = numero;
        this.fecha = fecha;
        this.clientes = clientes;
        this.operaciones = operaciones;
        this.saldo = saldo;
        this.destinoTransferencias = destinoTransferencias;
    }

    public String toString() {

        /* Según el esquema de la BD nunca será llamado, por ello, las subclases acabarán de
        implementar el método toString() añadiendo los parámetros especiales de cada una y \n.
         */
        return getNumero() + " / " + getFecha() + " / " + getClientes() + " / " +
                getOperaciones() + " / " + getDestinoTransferencias() + " / " + getSaldo();
    }
}
