/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Vista;

import com.MercadoSaludable.Controlador.ControlProducto;
import com.MercadoSaludable.Modelo.VO.ProductoVO;
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
@WebServlet(name = "ServiciosProducto", urlPatterns = {"/ServiciosProducto/*"})
public class ServiciosProducto extends GenericoServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>si
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
                ControlProducto controlconsulta = new ControlProducto(cnn);
                ProductoVO consultavo = new ProductoVO();
                consultavo.setCodigo_producto(Integer.parseInt(request.getParameter("codigo_producto")));
                consultavo.setNombre_producto(request.getParameter("nombre_producto"));
                consultavo=controlconsulta.consultaProducto(consultavo);
                respuesta.setCodigo(1);
                respuesta.setMensaje("Consulta exitosa");
                respuesta.setDatos(consultavo);
                break;
            case "Registro":
                ControlProducto controlRegistrar = new ControlProducto(cnn);
                ProductoVO registrarvo = new ProductoVO();;
                registrarvo.setCodigo_producto(Integer.parseInt(request.getParameter("codigo_producto")));
                registrarvo.setNombre_producto(request.getParameter("nombre_producto"));
                registrarvo.setPrecio_producto(Integer.parseInt(request.getParameter("precio_producto")));
                registrarvo.setStock_producto(Integer.parseInt(request.getParameter("stock_producto")));
                registrarvo.setFecha_vencimiento_producto(Date.valueOf(request.getParameter("fecha_vencimiento_producto")));
                registrarvo.setDescripcion_producto(request.getParameter("descripcion_producto"));
                registrarvo.setEstado_producto(request.getParameter("estado_producto"));
                registrarvo = controlRegistrar.insertarProducto(registrarvo);
                respuesta.setCodigo(1);
                respuesta.setMensaje("Registro Exitoso");
                respuesta.setDatos(registrarvo);
                break;
            case "Modificar":
                ControlProducto controlModifica = new ControlProducto(cnn);
                ProductoVO actualizavo = new ProductoVO();
                actualizavo.setId_producto(Integer.parseInt(request.getParameter("id_producto")));
                actualizavo.setCodigo_producto(Integer.parseInt(request.getParameter("codigo_producto")));
                actualizavo.setNombre_producto(request.getParameter("nombre_producto"));
                actualizavo.setPrecio_producto(Integer.parseInt(request.getParameter("precio_producto")));
                actualizavo.setStock_producto(Integer.parseInt(request.getParameter("stock_producto")));
                actualizavo.setFecha_vencimiento_producto(Date.valueOf(request.getParameter("fecha_vencimiento_producto")));
                actualizavo.setDescripcion_producto(request.getParameter("descripcion_producto"));
                actualizavo.setEstado_producto(request.getParameter("estado_producto"));
                actualizavo = controlModifica.modificarProducto(actualizavo);
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
