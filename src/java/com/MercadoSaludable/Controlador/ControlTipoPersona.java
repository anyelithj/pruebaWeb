/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Controlador;

import com.MercadoSaludable.Modelo.DAO.TipoPersonaDAO;
import com.MercadoSaludable.Modelo.VO.DetalleFacturaVO;
import com.MercadoSaludable.Modelo.VO.TipoPersonaVO;
import com.MercadoSaludable.Utils.MovilesException;
import java.sql.Connection;

/**
 *
 * @author Anyelith
 */
public class ControlTipoPersona {

    Connection cnn;
    TipoPersonaDAO dao;

    public ControlTipoPersona(Connection cnn) {

        this.cnn = cnn;
        this.dao = new TipoPersonaDAO(cnn);
    }

    public TipoPersonaVO registroTipopersona(TipoPersonaVO vo) throws MovilesException {
        try {

            TipoPersonaVO voinsertarTipopersona = dao.insertar(vo);
            return voinsertarTipopersona;

        } catch (Exception ex) {

            throw new MovilesException("No se puede ingresar el detalle de la factura", ex);

        }
    }

    public TipoPersonaVO consultarTipopersona(TipoPersonaVO vo) throws MovilesException {
        try {

            TipoPersonaVO voconsultarTipopersona = dao.consultar(vo);
            return voconsultarTipopersona;

        } catch (Exception ex) {

            throw new MovilesException("No se puede ingresar el detalle de la factura", ex);

        }
    }
    public TipoPersonaVO modificaTipopersona(TipoPersonaVO vo) throws MovilesException {
        try {

            TipoPersonaVO vomodificaTipopersona = dao.modificar(vo);
            return vomodificaTipopersona;

        } catch (Exception ex) {

            throw new MovilesException("No se puede ingresar el detalle de la factura", ex);

        }
    }

}
