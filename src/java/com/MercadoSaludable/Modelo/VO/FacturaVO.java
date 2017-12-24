/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Modelo.VO;

import java.sql.Date;

/**
 *
 * @author Anyelith
 */
public class FacturaVO {
    private int id_factura;
    private String tipo_comprobante;
    private int num_comprobante;
    private Date fecha_hora;
    private Date fecha_hora_entrega;
    private Date fecha_hora_recogida;
    private double subtotal;
    private double iva;
    private double total_apagar;


    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public String getTipo_comprobante() {
        return tipo_comprobante;
    }

    public void setTipo_comprobante(String tipo_comprobante) {
        this.tipo_comprobante = tipo_comprobante;
    }

    public int getNum_comprobante() {
        return num_comprobante;
    }

    public void setNum_comprobante(int num_comprobante) {
        this.num_comprobante = num_comprobante;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public Date getFecha_hora_entrega() {
        return fecha_hora_entrega;
    }

    public void setFecha_hora_entrega(Date fecha_hora_entrega) {
        this.fecha_hora_entrega = fecha_hora_entrega;
    }

    public Date getFecha_hora_recogida() {
        return fecha_hora_recogida;
    }

    public void setFecha_hora_recogida(Date fecha_hora_recogida) {
        this.fecha_hora_recogida = fecha_hora_recogida;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal_apagar() {
        return total_apagar;
    }

    public void setTotal_apagar(double total_apagar) {
        this.total_apagar = total_apagar;
    }


    
}
