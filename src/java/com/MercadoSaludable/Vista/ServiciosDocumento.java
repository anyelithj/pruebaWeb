/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Vista;

import com.MercadoSaludable.Controlador.ControlDocumento;
import com.MercadoSaludable.Modelo.VO.DocumentoVO;
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
@WebServlet(name = "ServiciosDocumento", urlPatterns = {"/ServiciosDocumento"})
public class ServiciosDocumento extends GenericoServlet {

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
                ControlDocumento controlconsulta = new ControlDocumento(cnn);
                DocumentoVO consultavo = new DocumentoVO();
                consultavo.setId_documento(Integer.parseInt(request.getParameter("id_documento")));
                consultavo=controlconsulta.consultarDocumento(consultavo); 
                respuesta.setCodigo(1);
                respuesta.setMensaje("Validacion OK");
                respuesta.setDatos(consultavo);
                break;
            case "Registro":
                ControlDocumento controlRegistrar = new ControlDocumento(cnn);
                DocumentoVO registrarvo = new DocumentoVO();
                registrarvo.setDescripcion_documento(request.getParameter("descripcion_documento"));
                registrarvo=controlRegistrar.insertarDocumento(registrarvo);
                respuesta.setCodigo(1);
                respuesta.setMensaje("Registro Exitoso");
                respuesta.setDatos(registrarvo);
                break;
            case "Modificar":
                ControlDocumento controlModifica = new ControlDocumento(cnn);
                DocumentoVO actualizavo = new DocumentoVO();
                actualizavo.setId_documento(Integer.parseInt(request.getParameter("id_documento")));
                actualizavo.setDescripcion_documento(request.getParameter("descripcion_documento"));
                actualizavo = controlModifica.modificarDocumento(actualizavo);
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
