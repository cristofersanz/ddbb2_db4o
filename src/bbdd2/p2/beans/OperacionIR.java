package bbdd2.p2.beans;

import java.util.Date;

/**
 * Bean que implementa la entidad OperacionIR, subtipo de Operacion.
 * El esquema objeto/relacional es:
 *  CREATE TYPE tipo_OperacionIngresoRetiro UNDER tipo_Operacion(
 *  oficinaIR REFERENCES Oficina(codigo))
 *  INSTANTIABLE NOT FINAL
 *  REF IS SYSTEM GENERATED;
 *
 *  @author Cristofer Sanz
 */
public class OperacionIR extends Operacion {

    private String oficinaIR;                    // REFERENCES bbdd2.p2.beans.Oficina(codigo)

    public String getOficinaIR() {
        return oficinaIR;
    }

    public void setOficinaIR(String oficinaIR) {
        this.oficinaIR = oficinaIR;
    }

    public OperacionIR(String codigo, String numero, String descripcion,
                       String tipo, int cantidad, Date fecha, String oficinaIR) {
        super(codigo, numero, descripcion, tipo, cantidad, fecha);
        this.oficinaIR = oficinaIR;
    }

    public String toString() {
        return super.toString() + " / " + getOficinaIR() + "\n";
    }
}