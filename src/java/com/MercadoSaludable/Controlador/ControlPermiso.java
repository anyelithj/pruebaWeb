/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Controlador;

import com.MercadoSaludable.Modelo.DAO.PermisoDAO;
import com.MercadoSaludable.Modelo.VO.PermisoVO;
import com.MercadoSaludable.Utils.MovilesException;
import java.sql.Connection;

/**
 *
 * @author Anyelith
 */
public class ControlPermiso {
    Connection cnn;
    PermisoDAO dao;
    
    public ControlPermiso(Connection cnn){
        this.cnn = cnn;
        this.dao = new PermisoDAO(cnn);
    }
    public PermisoVO modificarPermiso(PermisoVO vo) throws MovilesException {
         //To change body of generated methods, choose Tools | Templates.
        try {
            PermisoVO vomodificarPermiso = dao.modificar(vo);
            return vomodificarPermiso;
        } catch (Exception ex) {
            throw new MovilesException("No se actualizo el permiso", ex);
        }
    }

    public PermisoVO insertarPermiso(PermisoVO vo)throws MovilesException {
        try {
            PermisoVO voinsertarPermiso = dao.insertar(vo);
            return voinsertarPermiso;
        } catch (Exception ex) {
            throw new MovilesException("No se puede ingresar el permiso", ex);
        }
    }

    public PermisoVO consultarPermiso(PermisoVO vo) throws MovilesException{
         try {
            PermisoVO voconsultarPermiso = dao.consultar(vo);
            return voconsultarPermiso;
        } catch (Exception ex) {
            throw new MovilesException("Permiso no registrado", ex);
        }
    }

    
}
