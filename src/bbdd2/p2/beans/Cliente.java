package bbdd2.p2.beans;

import java.util.LinkedList;

/**
 * Author: Cristofer Sanz Blasco (584191)
 * Project: bbdd2p2
 * File: .java
 * Modified: 26/03/14
 * Description:
 */

public class Cliente {

    /**
     * CREATE TYPE tipo_cliente AS OBJECT(
     * DNI            NUMBER(8),
     * nombre        VARCHAR(20),
     * apellidos        VARCHAR(40),
     * direccion        VARCHAR(40),
     * edad            NUMBER(9),
     * telefono        NUMBER(4),
     * email            VARCHAR(20),
     * cuentas        listaCuentas)
     * REF IS SYSTEM GENERATED;
     */

    /* PRIMARY KEY */
    private int DNI;

    private String nombre;
    private String apellidos;
    private String direccion;
    private int edad;
    private int telefono;
    private String email;
    private LinkedList<String> cuentas;         // Referencia al PK de cada cuenta: numero

    public Cliente(int DNI, String nombre, String apellidos, String direccion,
                   int edad, int telefono, String email, LinkedList<String> cuentas) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.edad = edad;
        this.telefono = telefono;
        this.email = email;
        this.cuentas = cuentas;
    }

    public int getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getEdad() {
        return edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public LinkedList<String> getCuentas() {
        return cuentas;
    }
}
