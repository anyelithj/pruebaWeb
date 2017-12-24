/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Controlador;

import com.MercadoSaludable.Modelo.DAO.CategoriaDAO;
import com.MercadoSaludable.Modelo.VO.CategoriaVO;
import com.MercadoSaludable.Utils.MovilesException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author ANA ISABEL CARRILLO
 */
public class ControlCategoria {
  
    Connection cnn;
    CategoriaDAO dao;
    
    public ControlCategoria(Connection cnn){
        this.cnn = cnn;
        this.dao = new CategoriaDAO(cnn);
    }
    public CategoriaVO insertarCategoria(CategoriaVO vo)throws MovilesException{
        try {
            CategoriaVO voinsertaCategoria = dao.insertar(vo);
            return voinsertaCategoria;
        } catch (SQLException ex) {
            throw new MovilesException("No se puede ingresar la categoria", ex);       
        }
    }
    public CategoriaVO modificarCategoria(CategoriaVO vo) throws MovilesException{
        try {
            CategoriaVO vomodificaCategoria = dao.modificar(vo);
            return vomodificaCategoria;
        } catch (Exception ex) {
            throw new MovilesException("No se actualizo la categoria", ex);
        }
    }
    public CategoriaVO consultarCategoria(CategoriaVO vo)throws MovilesException{
        try {
            CategoriaVO voconsultarCategoria = dao.consultar(vo);
            return voconsultarCategoria;
        } 
        catch (Exception ex) {
            throw new MovilesException("Categoria no registrada", ex);
        }
    }
}
