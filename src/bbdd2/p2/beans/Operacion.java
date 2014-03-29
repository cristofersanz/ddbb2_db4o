package bbdd2.p2.beans;

import java.util.Date;

/**
 * Bean que implementa la entidad Operación.
 * El esquema objeto/relacional es:
 *  CREATE TYPE tipo_Operacion AS OBJECT(
 *  codigo        NUMBER(9),
 *  descripcion    VARCHAR(20),
 *  tipo            VARCHAR(20),
 *  cantidad        NUMBER(9),
 *  fecha            DATE,
 *  numero        REFERENCES Cuenta(numero));
 *  INSTANTIABLE NOT FINAL
 *  REF IS SYSTEM GENERATED;
 *
 *  @author Cristofer Sanz
 */
public class Operacion {

    /* PRIMARY KEY */
    private String codigo;
    private String numero;              // REFERENCES bbdd2.p2.beans.Cuenta(numero)

    private String descripcion;
    private String tipo;
    private int cantidad;
    private Date fecha;

    public String getCodigo() {
        return codigo;
    }

    public String getNumero() {
        return numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCantidad(int cantidad) {

        this.cantidad = cantidad;
    }

    public Operacion(String codigo, String numero, String descripcion,
                     String tipo, int cantidad, Date fecha) {
        this.codigo = codigo;
        this.numero = numero;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public String toString() {
        return getCodigo() + " / " + getNumero() + " / " + getDescripcion() + " / " +
                getTipo() + " / " + getCantidad() + " / " + getFecha();
    }
}
