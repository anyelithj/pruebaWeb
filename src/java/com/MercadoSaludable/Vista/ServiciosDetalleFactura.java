/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Vista;

import com.MercadoSaludable.Controlador.ControlDetalleFactura;
import com.MercadoSaludable.Modelo.VO.DetalleFacturaVO;
import com.MercadoSaludable.Utils.MovilesException;
import com.MercadoSaludable.Utils.RespuestaMoviles;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anyelith
 */
@WebServlet(name = "ServiciosDetalleFactura", urlPatterns = {"/ServiciosDetalleFactura"})
public class ServiciosDetalleFactura extends GenericoServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

public RespuestaMoviles procesapeticion(String accion, HttpServletRequest request, HttpServletResponse response) throws MovilesException {
        RespuestaMoviles respuesta = new RespuestaMoviles();
        switch (accion) {
            case "Consulta":
                ControlDetalleFactura controlconsulta = new ControlDetalleFactura(cnn);
                DetalleFacturaVO consultavo = new DetalleFacturaVO();
                consultavo.setId_detalle_factura(Integer.parseInt(request.getParameter("id_detalle_factura")));
                consultavo=controlconsulta.consultarDetalleFactura(consultavo);
                respuesta.setCodigo(1);
                respuesta.setMensaje("Consulta Exitosa");
                respuesta.setDatos(consultavo);
                break;
            case "Registro":
                ControlDetalleFactura controlRegistrar = new ControlDetalleFactura(cnn);
                DetalleFacturaVO registrarvo = new DetalleFacturaVO();
                registrarvo.setDescripcion(request.getParameter("descripcion"));
                registrarvo.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
                registrarvo.setValor_unitario(Double.parseDouble(request.getParameter("valor_unitario")));
                registrarvo= controlRegistrar.insertarDetalleFactura(registrarvo);
                respuesta.setCodigo(1);
                respuesta.setMensaje("Registro Exitoso");
                respuesta.setDatos(registrarvo);
                break;
            case "Modificar":
                ControlDetalleFactura controlModifica = new ControlDetalleFactura(cnn);
                DetalleFacturaVO actualizavo = new DetalleFacturaVO();
                actualizavo.setId_detalle_factura(Integer.parseInt(request.getParameter("id_detalle_factura")));
                actualizavo.setDescripcion(request.getParameter("descripcion"));
                actualizavo.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
                actualizavo.setValor_unitario(Double.parseDouble(request.getParameter("valor_unitario")));
                actualizavo = controlModifica.modificarDetalleFactura(actualizavo);
                respuesta.setCodigo(1);
                respuesta.setMensaje("Modificacion Exitosa");
                respuesta.setDatos(actualizavo);
                break;
            default:
                respuesta.setCodigo(-1);
                respuesta.setMensaje("Accion no valida");
                respuesta.setDatos(null);           
                break;
        }
        return respuesta;
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
}
