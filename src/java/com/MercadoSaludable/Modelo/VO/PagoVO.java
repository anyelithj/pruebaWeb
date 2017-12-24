
package com.MercadoSaludable.Modelo.VO;

import java.sql.Date;

/**
 *
 * @author Anyelith
 */
public class PagoVO {
    
    private int id_pago;
    private Date fecha_de_pago;
    private String tipo_de_pago;
    private String novedades;
    

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public Date getFecha_de_pago() {
        return fecha_de_pago;
    }

    public void setFecha_de_pago(Date fecha_de_pago) {
        this.fecha_de_pago = fecha_de_pago;
    }

    public String getTipo_de_pago() {
        return tipo_de_pago;
    }

    public void setTipo_de_pago(String tipo_de_pago) {
        this.tipo_de_pago = tipo_de_pago;
    }

    public String getNovedades() {
        return novedades;
    }

    public void setNovedades(String novedades) {
        this.novedades = novedades;
    }
    
}
