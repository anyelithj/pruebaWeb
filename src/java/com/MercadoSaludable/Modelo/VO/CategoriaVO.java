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
public class CategoriaVO {

    private int id_categoria;
    private String nombre_categoria;
    private String descripcion_categoria;
    private String estado_categoria;

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }


    public String getDescripcion_categoria() {
        return descripcion_categoria;
    }

    public void setDescripcion_categoria(String descripcion_categoria) {
        this.descripcion_categoria = descripcion_categoria;
    }

    public String getEstado_categoria() {
        return estado_categoria;
    }

    public void setEstado_categoria(String estado_categoria) {
        this.estado_categoria = estado_categoria;
    }

    /**
     * @return the id_categoria
     */
}
