package bbdd2.p2.beans;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Bean que implementa la entidad Cuenta corriente, subtipo
 * de cuenta.
 * El esquema objeto/relacional es:
 *  CREATE TYPE tipo_cCorriente UNDER tipo_cuenta(
 *  cuentaOficina REFERENCES Oficina(codigo))
 *  INSTANTIABLE NOT FINAL
 *  REF IS SYSTEM GENERATED;
 *
 * @author Cristofer Sanz
 * @author David Enjuanes
 * @author Victor Arellano
 * @author Alejandro Bean
 * @author Guillermo Sese
 * @author David Enjuanes
 * @author Victor Arellano
 * @author Alejandro Bean
 * @author Guillermo Sese
 */
public class CCorriente extends Cuenta {

    private String cuentaOficina;           // REFERENCES bbdd2.p2.beans.Oficina(codigo)

    public String getCuentaOficina() {
        return cuentaOficina;
    }

    public void setCuentaOficina(String cuentaOficina) {
        this.cuentaOficina = cuentaOficina;
    }

    public CCorriente(String numero, Date fecha, LinkedList<Integer> clientes,
                      LinkedList<HashMap<String, String>> operaciones,
                      LinkedList<HashMap<String, String>> destinoTransferencias,
                      double saldo, String cuentaOficina) {
        super(numero, fecha, clientes, operaciones, destinoTransferencias, saldo);
        this.cuentaOficina = cuentaOficina;
    }

    public String toString() {
        return super.toString() + " / " + getCuentaOficina() + "\n";
    }
}
