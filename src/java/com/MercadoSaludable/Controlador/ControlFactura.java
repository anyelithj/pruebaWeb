/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Controlador;

import com.MercadoSaludable.Modelo.DAO.FacturaDAO;
import com.MercadoSaludable.Modelo.VO.FacturaVO;
import com.MercadoSaludable.Utils.MovilesException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Anyelith
 */
public class ControlFactura {
    Connection cnn;
    FacturaDAO dao;
    
    public ControlFactura(Connection cnn){
        this.cnn = cnn;
        this.dao = new FacturaDAO(cnn);
    }
    public FacturaVO insertarFactura(FacturaVO vo)throws MovilesException{
        try {
            FacturaVO voinsertarFactura = dao.insertar(vo);
        } catch (Exception ex) {
            throw new MovilesException("No se puede ingresar la factura", ex);
        } return null;
    }
    public FacturaVO modificarFactura(FacturaVO vo) throws MovilesException{
        try {
            FacturaVO vomodificarFactura = dao.modificar(vo);
            return vomodificarFactura;
        } catch (Exception ex) {
            throw new MovilesException("No se actualizo la factura",ex);
        }
    }
    public FacturaVO consultarFactura(FacturaVO vo) throws MovilesException{
        try {
            FacturaVO voconsultarFactura = dao.consultar(vo);
            return voconsultarFactura;
        } catch (Exception ex) {
            throw new MovilesException("Factura no registrada", ex);
        }
    }
}
