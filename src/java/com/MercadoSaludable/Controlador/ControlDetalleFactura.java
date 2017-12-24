/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Controlador;

import com.MercadoSaludable.Modelo.DAO.DetalleFacturaDAO;
import com.MercadoSaludable.Modelo.VO.DetalleFacturaVO;
import com.MercadoSaludable.Utils.MovilesException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Anyelith
 */
public class ControlDetalleFactura {
 Connection cnn;
 DetalleFacturaDAO dao;
 
 public ControlDetalleFactura(Connection cnn){
     this.cnn = cnn;
     this.dao = new DetalleFacturaDAO(cnn);
 }
 public DetalleFacturaVO insertarDetalleFactura(DetalleFacturaVO vo)throws MovilesException{
     try {
         DetalleFacturaVO voinsertarDetalleFactura = dao.insertar(vo);
         return voinsertarDetalleFactura;
     } catch (Exception ex) {
         throw new MovilesException("No se puede ingresar el detalle de la factura", ex);
     }
 }
 public DetalleFacturaVO modificarDetalleFactura(DetalleFacturaVO vo)throws MovilesException{
     try {
         DetalleFacturaVO vomodificaDetalleFactura = dao.modificar(vo);
         return vomodificaDetalleFactura;
     } catch (Exception ex) {
         throw new MovilesException("No se actualizo el detalle de la factura",ex);
     }
 }
 public DetalleFacturaVO consultarDetalleFactura(DetalleFacturaVO vo)throws MovilesException{
        try {
            DetalleFacturaVO voconsultaDetalleFactura = dao.consultar(vo);
            return voconsultaDetalleFactura;
        } 
        catch (Exception ex) {
            throw new MovilesException("Categoria no registrada", ex);
        }
    }
}
