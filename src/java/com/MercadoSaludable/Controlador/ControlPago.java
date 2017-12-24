/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Controlador;

import com.MercadoSaludable.Modelo.DAO.PagoDAO;
import com.MercadoSaludable.Modelo.VO.PagoVO;
import com.MercadoSaludable.Utils.MovilesException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Anyelith
 */
public class ControlPago {
    Connection cnn;
    PagoDAO dao;
    
    public ControlPago(Connection cnn){
        this.cnn = cnn;
        this.dao = new PagoDAO(cnn);
    }
    public PagoVO insertarPago(PagoVO vo) throws MovilesException{
        try {
            PagoVO voinsertarPago = dao.insertar(vo);
            return voinsertarPago;
        } catch (Exception ex) {
            throw new MovilesException("No se puede Ingresar el pago",ex);
        }
    }
    public PagoVO modificarPago(PagoVO vo) throws MovilesException{
        try {
            PagoVO vomodificaPago = dao.modificar(vo);
            return vomodificaPago;
        } catch (Exception ex) {
            throw new MovilesException("No se actualizo el pago",ex);
        }
    }
    public PagoVO consultarPago(PagoVO vo) throws MovilesException{
        try {
            PagoVO voconsultarPago = dao.consutar(vo);
            return voconsultarPago;
                    
        } catch (Exception ex) {
            throw new MovilesException("Pago no registrado", ex);
        }
    }
}
