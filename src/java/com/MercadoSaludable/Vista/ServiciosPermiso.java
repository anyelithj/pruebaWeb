/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Vista;

import com.MercadoSaludable.Controlador.ControlPermiso;
import com.MercadoSaludable.Modelo.VO.PermisoVO;
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
@WebServlet(name = "ServiciosPermiso", urlPatterns = {"/ServiciosPermiso"})
public class ServiciosPermiso extends GenericoServlet {

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
                ControlPermiso controlconsulta = new ControlPermiso(cnn);
                PermisoVO consultavo = new PermisoVO();
                consultavo.setId_permiso(Integer.parseInt(request.getParameter("id_permiso")));
                consultavo=controlconsulta.consultarPermiso(consultavo);
                respuesta.setCodigo(1);
                respuesta.setMensaje("Validación OK");
                respuesta.setDatos(consultavo);
                break;
                
            case "Registro":
                ControlPermiso controlRegistrar = new ControlPermiso(cnn);
                PermisoVO registrarvo = new PermisoVO();
                registrarvo.setPermiso(request.getParameter("permiso"));
                registrarvo.setEstado_permiso(request.getParameter("estado_permiso"));
                registrarvo=controlRegistrar.insertarPermiso(registrarvo);
                respuesta.setCodigo(1);
                respuesta.setMensaje("Registro Exitoso");
                respuesta.setDatos(registrarvo);
                break;
            case "Modificar":
                ControlPermiso controlModifica = new ControlPermiso(cnn);
                PermisoVO actualizavo = new PermisoVO();
                actualizavo.setId_permiso(Integer.parseInt(request.getParameter("id_permiso")));
                actualizavo.setPermiso(request.getParameter("permiso"));
                actualizavo.setEstado_permiso(request.getParameter("estado_permiso"));
                
                actualizavo = controlModifica.modificarPermiso(actualizavo);
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
