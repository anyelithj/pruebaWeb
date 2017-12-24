/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Vista;

import com.MercadoSaludable.Controlador.ControlPago;
import com.MercadoSaludable.Modelo.VO.PagoVO;
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
@WebServlet(name = "ServiciosPago", urlPatterns = {"/ServiciosPago"})
public class ServiciosPago extends GenericoServlet {

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
                ControlPago controlconsulta = new ControlPago(cnn);
                PagoVO consultavo = new PagoVO();
                consultavo.setFecha_de_pago(Date.valueOf(request.getParameter("fecha_de_pago")));
                consultavo=controlconsulta.consultarPago(consultavo); 
                respuesta.setCodigo(1);
                respuesta.setMensaje("Consulta Exitosa");
                respuesta.setDatos(consultavo);
                break;
            case "Registro":
                ControlPago controlRegistrar = new ControlPago(cnn);
                PagoVO registrarvo = new PagoVO();
                registrarvo.setTipo_de_pago(request.getParameter("tipo_de_pago"));
                registrarvo.setNovedades(request.getParameter("novedades"));
                registrarvo.setFecha_de_pago(Date.valueOf(request.getParameter("fecha_de_pago")));
                registrarvo=controlRegistrar.insertarPago(registrarvo);
                respuesta.setCodigo(1);
                respuesta.setMensaje("Registro Exitoso");
                respuesta.setDatos(registrarvo);
                break;
            case "Modificar":
                ControlPago controlModifica = new ControlPago(cnn);
                PagoVO actualizavo = new PagoVO();
                actualizavo.setId_pago(Integer.parseInt(request.getParameter("id_pago")));
                actualizavo.setTipo_de_pago(request.getParameter("tipo_de_pago"));
                actualizavo.setNovedades(request.getParameter("novedades"));
                actualizavo = controlModifica.modificarPago(actualizavo);
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
