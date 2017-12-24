/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Controlador;

import com.MercadoSaludable.Modelo.DAO.ProductoDAO;
import com.MercadoSaludable.Modelo.VO.ProductoVO;
import com.MercadoSaludable.Utils.MovilesException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Anyelith
 */
public class ControlProducto {

    Connection cnn;
    ProductoDAO dao;

    public ControlProducto(Connection cnn) {
        this.cnn = cnn;
        this.dao = new ProductoDAO(cnn);
    }

    public ProductoVO insertarProducto(ProductoVO vo) throws MovilesException {
        try {
            ProductoVO voinsertaProducto = dao.insertar(vo);
            return voinsertaProducto;
        } catch (Exception ex) {
            throw new MovilesException("No se pudo ingresar el producto", ex);
        }
    }

    public ProductoVO modificarProducto(ProductoVO vo) throws MovilesException {
        try {
            ProductoVO voinsertaProducto = dao.modificar(vo);
            return voinsertaProducto;
        } catch (Exception e) {
            throw new MovilesException("No se pudo ingresar el producto", e);
        }

    }

    public ProductoVO consultaProducto(ProductoVO vo) throws MovilesException {
        try {
            ProductoVO voinsertaProducto = dao.consultar(vo);
            return voinsertaProducto;
        } catch (Exception e) {
            throw new MovilesException("No se pudo ingresar el producto", e);
        }

    }

}
