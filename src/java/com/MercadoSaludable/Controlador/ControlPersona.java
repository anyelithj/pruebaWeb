/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Controlador;

import com.MercadoSaludable.Modelo.DAO.PersonaDAO;
import com.MercadoSaludable.Modelo.VO.PersonaVO;
import com.MercadoSaludable.Utils.MovilesException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Anyelith
 */
public class ControlPersona {
    Connection cnn;
    PersonaDAO dao;
    
    public ControlPersona(Connection cnn){
        this.cnn = cnn;
        this.dao = new PersonaDAO(cnn);
    }
    public PersonaVO insertarPersona(PersonaVO vo) throws MovilesException{
        try {
            PersonaVO voinsertaPersona = dao.insertar(vo);
            return voinsertaPersona;
        } catch (Exception ex) {
            throw new MovilesException("No se pudo ingresar la persona", ex);
        }
    }
    public PersonaVO modificarPersona(PersonaVO vo) throws MovilesException{
        try {
            PersonaVO voinsertarPersona = dao.insertar(vo);
            return voinsertarPersona;
        } catch (Exception ex) {
            throw new MovilesException("No sse puede ingresar la persona", ex);
        }
    }
    public PersonaVO consultarPersona(PersonaVO vo)throws MovilesException{
        try {
            PersonaVO voconsultarPersona = dao.consultar(vo);
            return voconsultarPersona;
        } catch (Exception ex) {
            throw new MovilesException("Persona no registrada", ex);
        }
    }
}
