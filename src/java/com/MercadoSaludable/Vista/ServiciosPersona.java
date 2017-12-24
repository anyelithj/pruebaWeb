/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Vista;

import com.MercadoSaludable.Controlador.ControlPersona;
import com.MercadoSaludable.Modelo.VO.PersonaVO;
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
@WebServlet(name = "ServiciosPersona", urlPatterns = {"/ServiciosPersona/*"})
public class ServiciosPersona extends GenericoServlet {

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
                ControlPersona controlconsulta = new ControlPersona(cnn);
                PersonaVO consultavo = new PersonaVO();
                consultavo.setNumero_documento(Integer.parseInt(request.getParameter("numero_documento")));
                consultavo= controlconsulta.consultarPersona(consultavo);
                respuesta.setCodigo(1);
                respuesta.setMensaje("Validacion OK");
                respuesta.setDatos(consultavo);
                break;
            case "Registro":
                ControlPersona controlRegistrar = new ControlPersona(cnn);
                PersonaVO registrarvo = new PersonaVO();
                registrarvo.setNumero_documento(Integer.parseInt(request.getParameter("numero_documento")));
                registrarvo.setTelefono_persona(request.getParameter("telefono_persona"));
                registrarvo.setCelular_persona(request.getParameter("celular_persona"));
                registrarvo.setDireccion_persona(request.getParameter("direccion_persona"));
                registrarvo.setEmail_persona(request.getParameter("direccion_persona"));
                registrarvo.setPagina_web_persona(request.getParameter("pagina_web_persona"));
                registrarvo.setDescripcion_persona(request.getParameter("descripcion_persona"));
                registrarvo = controlRegistrar.insertarPersona(registrarvo);
                respuesta.setCodigo(1);
                respuesta.setMensaje("Registro Exitoso");
                respuesta.setDatos(registrarvo);
                break;
            case "Modificar":
                ControlPersona controlModifica = new ControlPersona(cnn);
                PersonaVO actualizavo = new PersonaVO();
                actualizavo.setId_persona(Integer.parseInt(request.getParameter("id_persona")));
                actualizavo.setTelefono_persona(request.getParameter("telefono_persona"));
                actualizavo.setCelular_persona(request.getParameter("celular_persona"));
                actualizavo.setDireccion_persona(request.getParameter("direccion_persona"));
                actualizavo.setEmail_persona(request.getParameter("direccion_persona"));
                actualizavo.setPagina_web_persona(request.getParameter("pagina_web_persona"));
                actualizavo.setDescripcion_persona(request.getParameter("descripcion_persona"));
   
                actualizavo = controlModifica.modificarPersona(actualizavo);
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
