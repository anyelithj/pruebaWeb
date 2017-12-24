/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Vista;

import com.MercadoSaludable.Controlador.ControlFactura;
import com.MercadoSaludable.Modelo.VO.FacturaVO;
import com.MercadoSaludable.Utils.MovilesException;
import com.MercadoSaludable.Utils.RespuestaMoviles;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anyelith
 */
@WebServlet(name = "ServiciosFactura", urlPatterns = {"/ServiciosFactura"})
public class ServiciosFactura extends GenericoServlet {

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
                ControlFactura controlconsulta = new ControlFactura(cnn);
                FacturaVO consultavo = new FacturaVO();
                consultavo.setNum_comprobante(Integer.parseInt(request.getParameter("num_comprobante")));
                consultavo=controlconsulta.consultarFactura(consultavo); 
                respuesta.setCodigo(1);
                respuesta.setMensaje("Validacion OK");
                respuesta.setDatos(consultavo);
                break;
            case "Registro":
                ControlFactura controlRegistrar = new ControlFactura(cnn);
                FacturaVO registrarvo = new FacturaVO();
                registrarvo.setTipo_comprobante(request.getParameter("tipo_comprobante"));
                registrarvo.setNum_comprobante(Integer.parseInt(request.getParameter("num_comprobante")));
                registrarvo.setFecha_hora(Date.valueOf(request.getParameter("fecha_hora")));
                registrarvo.setFecha_hora_entrega(Date.valueOf(request.getParameter("fecha_hora_entrega")));
                registrarvo.setFecha_hora_recogida(Date.valueOf(request.getParameter("fecha_hora_recogida")));
                registrarvo.setSubtotal(Double.parseDouble(request.getParameter("subtotal")));
                registrarvo.setIva(Double.parseDouble(request.getParameter("iva")));
                registrarvo.setTotal_apagar(Double.parseDouble(request.getParameter("total_apagar")));
                registrarvo=controlRegistrar.insertarFactura(registrarvo);
                respuesta.setCodigo(1);
                respuesta.setMensaje("Registro Exitoso");
                respuesta.setDatos(registrarvo);
                break;
            case "Modificar":
                ControlFactura controlModifica = new ControlFactura(cnn);
                FacturaVO actualizavo = new FacturaVO();
                actualizavo.setId_factura(Integer.parseInt(request.getParameter("id_factura")));
                actualizavo.setTipo_comprobante(request.getParameter("tipo_comprobante"));
                actualizavo.setSubtotal(Double.parseDouble(request.getParameter("subtotal")));
                actualizavo.setIva(Double.parseDouble(request.getParameter("iva")));
                actualizavo.setTotal_apagar(Double.parseDouble(request.getParameter("total_apagar")));
                actualizavo = controlModifica.modificarFactura(actualizavo);
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




}
