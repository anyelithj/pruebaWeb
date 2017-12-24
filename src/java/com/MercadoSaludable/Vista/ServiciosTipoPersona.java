/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Vista;

import com.MercadoSaludable.Controlador.ControlTipoPersona;
import com.MercadoSaludable.Modelo.VO.TipoPersonaVO;
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
@WebServlet(name = "ServiciosTipoPersona", urlPatterns = {"/ServiciosTipoPersona"})
public class ServiciosTipoPersona extends GenericoServlet {

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
                ControlTipoPersona controlconsulta = new ControlTipoPersona(cnn);
                TipoPersonaVO consultavo = new TipoPersonaVO();
                consultavo.setTipo_persona(request.getParameter(""));
                consultavo.setEntidad(request.getParameter(""));
                consultavo=controlconsulta.consultarTipopersona(consultavo); 
                respuesta.setCodigo(1);
                respuesta.setMensaje("Consulta Exitosa");
                respuesta.setDatos(consultavo);
                break;
            case "Registro":
                ControlTipoPersona controlRegistrar = new ControlTipoPersona(cnn);
                TipoPersonaVO registrarvo = new TipoPersonaVO();
                registrarvo.setTipo_persona(request.getParameter("tipo_persona"));
                registrarvo.setEntidad(request.getParameter("entidad"));
                registrarvo.setDescripcion(request.getParameter("descripcion"));
                registrarvo.setEstadoTipopersona(request.getParameter("estado_tipo_persona"));
                registrarvo=controlRegistrar.registroTipopersona(registrarvo);
                respuesta.setCodigo(1);
                respuesta.setMensaje("Registro Exitoso");
                respuesta.setDatos(registrarvo);
                break;
            case "Modificar":
                ControlTipoPersona controlModifica = new ControlTipoPersona(cnn);
                TipoPersonaVO actualizavo = new TipoPersonaVO();
                actualizavo.setId_tipo_persona(Integer.parseInt(request.getParameter("id_tipo_persona")));
                actualizavo.setTipo_persona(request.getParameter("tipo_persona"));
                actualizavo.setEntidad(request.getParameter("entidad"));
                actualizavo.setDescripcion(request.getParameter("descripcion"));
                actualizavo.setEstadoTipopersona(request.getParameter("estado_tipo_persona"));
                actualizavo = controlModifica.modificaTipopersona(actualizavo);
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
