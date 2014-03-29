package bbdd2.p2.beans;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Bean que implementa la entidad Oficina.
 * El esquema objeto/relacional es:
 *  CREATE TYPE tipo_oficina AS OBJECT(
 *  codigo        NUMBER(20),
 *  direccion        VARCHAR(30),
 *  telefono        NUMBER(9))
 *  REF IS SYSTEM GENERATED;
 *
 *  @author Cristofer Sanz
 */
public class Oficina {

    /* PRIMARY KEY */
    private String codigo;

    private String direccion;
    private int telefono;
    private LinkedList<String> cCorrientes;
    private LinkedList<HashMap<String, String>> operacionesIR;

    public String getCodigo() {
        return codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public LinkedList<String> getcCorrientes() {
        return cCorrientes;
    }

    public LinkedList<HashMap<String, String>> getOperacionesIR() {
        return operacionesIR;
    }

    public void setOperacionesIR(LinkedList<HashMap<String, String>> operacionesIR) {
        this.operacionesIR = operacionesIR;
    }

    public void setcCorrientes(LinkedList<String> cCorrientes) {
        this.cCorrientes = cCorrientes;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Oficina(String codigo, String direccion, int telefono,
                   LinkedList<String> cCorrientes, LinkedList<HashMap<String, String>> operacionesIR) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cCorrientes = cCorrientes;
        this.operacionesIR = operacionesIR;
    }

    public String toString() {
        return getCodigo() + " / " + getDireccion() + " / " + getTelefono() + " / " +
                getcCorrientes() + " / " + getOperacionesIR() + "\n";
    }
}