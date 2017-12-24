/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Modelo.VO;

/**
 *
 * @author Anyelith
 */
public class TipoPersonaVO {

    private int id_tipo_persona;
    private String tipo_persona;
    private String entidad;
    private String descripcion;
    private String estadoTipopersona;

    /**
     * @return the id_tipo_persona
     */
    public int getId_tipo_persona() {
        return id_tipo_persona;
    }

    /**
     * @param id_tipo_persona the id_tipo_persona to set
     */
    public void setId_tipo_persona(int id_tipo_persona) {
        this.id_tipo_persona = id_tipo_persona;
    }

    /**
     * @return the tipo_persona
     */
    public String getTipo_persona() {
        return tipo_persona;
    }

    /**
     * @param tipo_persona the tipo_persona to set
     */
    public void setTipo_persona(String tipo_persona) {
        this.tipo_persona = tipo_persona;
    }

    /**
     * @return the entidad
     */
    public String getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstadoTipopersona() {
        return estadoTipopersona;
    }

    public void setEstadoTipopersona(String estadoTipopersona) {
        this.estadoTipopersona = estadoTipopersona;
    }

}
