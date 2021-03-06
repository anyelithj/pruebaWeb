/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Vista;

import com.MercadoSaludable.Modelo.Conexion;
import com.MercadoSaludable.Utils.RespuestaMoviles;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import com.MercadoSaludable.Utils.MovilesException;
import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author FRAK
 */
@WebServlet(name = "GenericoServlet", urlPatterns = {"/GenericoServlet/*"})
public abstract class GenericoServlet extends HttpServlet {
    protected  Connection cnn;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            
            try {
                cnn = Conexion.getConexionBD();
                String url=request.getRequestURI();
                String partes[]=url.split("/");
                String accion=partes[partes.length-1];
                RespuestaMoviles respuesta=procesapeticion(accion, request, response);
                out.println(new Gson().toJson(respuesta));
                Conexion.desconectarBD(cnn);
            }catch (MovilesException exce){
                RespuestaMoviles respuesta=new RespuestaMoviles();
                respuesta.setCodigo(-1);
                respuesta.setMensaje(exce.getMessage());
                out.println(new Gson().toJson(respuesta));
            }catch(Exception ex){
                ex.printStackTrace();
                Conexion.revesarCambioBD(cnn);
                RespuestaMoviles respuesta =new RespuestaMoviles();
                respuesta.setCodigo(-1);
                respuesta.setMensaje("Ocurrio un error Inesperado");
                out.println(new Gson().toJson(respuesta));
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *    }

     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    public abstract RespuestaMoviles procesapeticion(String accion ,HttpServletRequest request,HttpServletResponse response)throws MovilesException;
}
