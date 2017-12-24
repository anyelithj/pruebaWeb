/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Vista;
import java.sql.Date;
import com.MercadoSaludable.Controlador.ControlUsuarios;
import com.MercadoSaludable.Modelo.VO.UsuarioVO;
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
@WebServlet(name = "ServiciosUsuario", urlPatterns = {"/ServiciosUsuario/*"})
public class ServiciosUsuario extends GenericoServlet {
    
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
            case "Validar":
                ControlUsuarios controlconsulta = new ControlUsuarios(cnn);
                UsuarioVO consultavo = new UsuarioVO();
                consultavo.setNombre_usuario(request.getParameter("nombre_usuario"));
                consultavo.setPassword_usuario(request.getParameter("password_usuario"));
                consultavo = controlconsulta.validarUsuario(consultavo);
                respuesta.setCodigo(1);
                respuesta.setMensaje("Validacion OK");
                respuesta.setDatos(consultavo);
                break;
            case "Registro":
                ControlUsuarios controlRegistrar = new ControlUsuarios(cnn);
                UsuarioVO registrartvo = new UsuarioVO();
                registrartvo.setNombre_usuario(request.getParameter("nombre_usuario"));
                registrartvo.setFecha_hora_creacion_usuario(Date.valueOf(request.getParameter("fecha_hora_creacion_usuario")));
                registrartvo.setPassword_usuario(request.getParameter("password_usuario"));                
                registrartvo.setEstado_usuario(request.getParameter("estado_usuario"));             
                registrartvo = controlRegistrar.insertarUsuario(registrartvo);
                respuesta.setCodigo(1);
                respuesta.setMensaje("Registro Exitoso");
                respuesta.setDatos(registrartvo);
                break;
            case "Modificar":
                ControlUsuarios controlModifica = new ControlUsuarios(cnn);
                UsuarioVO actualizavo = new UsuarioVO();
                actualizavo.setNombre_usuario(request.getParameter("nombre_usuario"));
                actualizavo.setPassword_usuario(request.getParameter("password_usuario"));
                actualizavo.setEstado_usuario(request.getParameter("estado_usuario"));
                actualizavo.setId_usuario(Integer.parseInt(request.getParameter("id_usuario")));
                actualizavo = controlModifica.modificarUsuario(actualizavo);
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

}
