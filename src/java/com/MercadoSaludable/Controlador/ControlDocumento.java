/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Controlador;

import com.MercadoSaludable.Modelo.DAO.DocumentoDAO;
import com.MercadoSaludable.Modelo.VO.DocumentoVO;
import com.MercadoSaludable.Utils.MovilesException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Anyelith
 */
public class ControlDocumento {

    Connection cnn;
    DocumentoDAO dao;

    public ControlDocumento(Connection cnn) {
        this.cnn = cnn;
        this.dao = new DocumentoDAO(cnn);
    }

    public DocumentoVO insertarDocumento(DocumentoVO vo) throws MovilesException {
        try {
            DocumentoVO voinsertarDocumento = dao.insertar(vo);
            return voinsertarDocumento;
        } catch (Exception ex) {
            throw new MovilesException("No se puede ingresar el Documento", ex);
        }
    }

    public DocumentoVO modificarDocumento(DocumentoVO vo) throws MovilesException {
        try {
            DocumentoVO vomodificaDocumento = dao.modificar(vo);
            return vomodificaDocumento;
        } catch (Exception ex) {
            throw new MovilesException("No se actualizo el documento", ex);
        }
    }

    public DocumentoVO consultarDocumento(DocumentoVO vo) throws MovilesException {
        try {
            DocumentoVO voconsultarDocumento = dao.consultar(vo);
            return voconsultarDocumento;
        } catch (Exception ex) {
            throw new MovilesException("Documento no resgistrada", ex);
        }
    }
}
