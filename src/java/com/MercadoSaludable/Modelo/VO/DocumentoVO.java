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
public class DocumentoVO {
    private int id_documento;
    private String descripcion_documento;

    /**
     * @return the id_documento
     */
    public int getId_documento() {
        return id_documento;
    }

    /**
     * @param id_documento the id_documento to set
     */
    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    /**
     * @return the descripcion_documento
     */
    public String getDescripcion_documento() {
        return descripcion_documento;
    }

    /**
     * @param descripcion_documento the descripcion_documento to set
     */
    public void setDescripcion_documento(String descripcion_documento) {
        this.descripcion_documento = descripcion_documento;
    }
}
