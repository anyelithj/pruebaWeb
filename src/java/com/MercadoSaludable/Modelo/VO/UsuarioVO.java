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
public class UsuarioVO {
    private int  id_usuario;
    private String nombre_usuario;
    private String password_usuario;    
    private Date fecha_hora_creacion_usuario;   
    private String estado_usuario;

    public String getEstado_usuario() {
        return estado_usuario;
    }

    public void setEstado_usuario(String estado_usuario) {
        this.estado_usuario = estado_usuario;
    }

    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the nombre_usuario
     */
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    /**
     * @param nombre_usuario the nombre_usuario to set
     */
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    /**
     * @return the password_usuario
     */
    public String getPassword_usuario() {
        return password_usuario;
    }

    /**
     * @param password_usuario the password_usuario to set
     */
    public void setPassword_usuario(String password_usuario) {
        this.password_usuario = password_usuario;
    }

    /**
     * @return the fecha_hora_creacion_usuario
     */
    public Date getFecha_hora_creacion_usuario() {
        return fecha_hora_creacion_usuario;
    }

    /**
     * @param fecha_hora_creacion_usuario the fecha_hora_creacion_usuario to set
     */
    public void setFecha_hora_creacion_usuario(Date fecha_hora_creacion_usuario) {
        this.fecha_hora_creacion_usuario = fecha_hora_creacion_usuario;
    }
}
