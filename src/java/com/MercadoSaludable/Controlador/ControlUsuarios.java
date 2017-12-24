/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Controlador;

import com.MercadoSaludable.Modelo.DAO.UsuarioDAO;
import com.MercadoSaludable.Modelo.VO.UsuarioVO;
import com.MercadoSaludable.Utils.MovilesException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Anyelith
 */
public class ControlUsuarios {
    //declaro los objetos de tipo conexion  y tipo UsuarioDAO
    Connection cnn;
    UsuarioDAO dao;
    //escribo método constructor y recibe los parametros de tipo conexión y tipo dao
    public ControlUsuarios(Connection cnn){
        this.cnn = cnn;
        this.dao = new UsuarioDAO(cnn);//this identifica los objetos
    }
    //se crea un método de tipo UsuarioVO que es para insertar usuarioVO que devuelve la exception MovilesException
    //método que registra el usuario
    public UsuarioVO insertarUsuario(UsuarioVO vo)throws MovilesException{
        try {
            UsuarioVO voinsertaUs=dao.insertar(vo);//permite el acceso a la clase dao o los metodos y clase vo
            return voinsertaUs;
        } catch (SQLException ex) {
            throw new MovilesException("No se puede ingresar usuario",ex);
        }
    
    }
    public UsuarioVO modificarUsuario(UsuarioVO vo) throws MovilesException{
        try {
            UsuarioVO vomodificaUS = dao.modificar(vo);
            return vomodificaUS;
        } catch (Exception ex) {
            throw new MovilesException("No se actualizo el usuario", ex);
        }
    
    }
    // se crea el método validar que valida los datos del usuario nombre y contraseña
    //para iniciar sesión ,
    public UsuarioVO validarUsuario(UsuarioVO vo) throws MovilesException{
        try{
            if(vo.getNombre_usuario()!= null && vo.getPassword_usuario()!= null){
                
                UsuarioVO voVerificado = dao.consultar(vo.getNombre_usuario(),vo.getPassword_usuario());  
                
                if (voVerificado != null && voVerificado.getPassword_usuario().equals(vo.getPassword_usuario())){
                    return voVerificado;
                }
            }
            throw new MovilesException("Datos de Usuario invalidos", null);   
        }catch(SQLException ex){
            throw new MovilesException("No se puede validar el usuario",ex);
        }
    }
    
    
}
