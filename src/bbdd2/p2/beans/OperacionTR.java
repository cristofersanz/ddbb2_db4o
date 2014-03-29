package bbdd2.p2.beans;

import java.util.Date;

/**
 * Bean que implementa la entidad OperacionTR, subtipo de Operacion.
 * El esquema objeto/relacional es:
 *  CREATE TYPE tipo_OperacionTransferencia UNDER tipo_Operacion(
 *  cuentaTR REFERENCES Cuenta(numero))
 *  INSTANTIABLE NOT FINAL
 *  REF IS SYSTEM GENERATED;
 *
 * @author Cristofer Sanz
 * @author David Enjuanes
 * @author Victor Arellano
 * @author Alejandro Bean
 * @author Guillermo Sese
 */
public class OperacionTR extends Operacion {

    private String cuentaTR;            // REFERENCES bbdd2.p2.beans.Cuenta(numero)

    public String getCuentaTR() {
        return cuentaTR;
    }

    public void setCuentaTR(String cuentaTR) {
        this.cuentaTR = cuentaTR;
    }

    public OperacionTR(String codigo, String numero, String descripcion,
                       String tipo, int cantidad, Date fecha, String cuentaTR) {
        super(codigo, numero, descripcion, tipo, cantidad, fecha);
        this.cuentaTR = cuentaTR;
    }

    public String toString() {
        return super.toString() + " / " + getCuentaTR() + "\n";
    }
}
