/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Vista;

import com.MercadoSaludable.Controlador.ControlCategoria;
import com.MercadoSaludable.Modelo.VO.CategoriaVO;
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
@WebServlet(name = "ServiciosCategoria", urlPatterns = {"/ServiciosCategoria"})
public class ServiciosCategoria extends GenericoServlet {

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
                ControlCategoria controlconsulta = new ControlCategoria(cnn);
                CategoriaVO consultavo = new CategoriaVO();
                consultavo.setNombre_categoria(request.getParameter("nombre_categoria"));
                consultavo=controlconsulta.consultarCategoria(consultavo); 
                respuesta.setCodigo(1);
                respuesta.setMensaje("Validacion OK");
                respuesta.setDatos(consultavo);
                break;
            case "Registro":
                ControlCategoria controlRegistrar = new ControlCategoria(cnn);
                CategoriaVO registrarvo = new CategoriaVO();
                registrarvo.setNombre_categoria(request.getParameter("nombre_categoria"));
                registrarvo.setDescripcion_categoria(request.getParameter("descripcion_categoria"));
                registrarvo.setEstado_categoria(request.getParameter("estado_categoria"));
                registrarvo=controlRegistrar.insertarCategoria(registrarvo);
                respuesta.setCodigo(1);
                respuesta.setMensaje("Registro Exitoso");
                respuesta.setDatos(registrarvo);
                break;
            case "Modificar":
                ControlCategoria controlModifica = new ControlCategoria(cnn);
                CategoriaVO actualizavo = new CategoriaVO();
                actualizavo.setId_categoria(Integer.parseInt(request.getParameter("id_categoria")));
                actualizavo.setNombre_categoria(request.getParameter("nombre_categoria"));
                actualizavo.setDescripcion_categoria(request.getParameter("descripcion_categoria"));
                actualizavo.setEstado_categoria(request.getParameter("estado_categoria"));     
                actualizavo = controlModifica.modificarCategoria(actualizavo);
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
