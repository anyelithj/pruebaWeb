/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Modelo.DAO;

import com.MercadoSaludable.Modelo.VO.PersonaVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anyelith
 */
public class PersonaDAO {

    Connection cnn;

    public PersonaDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public PersonaVO insertar(PersonaVO vo) throws SQLException {

        PreparedStatement sentencia = cnn.prepareStatement("INSERT INTO persona(numero_documento,telefono_persona,celular_persona,direccion_persona,email_persona,pagina_web_persona,descripcion_persona,estado_persona) VALUES(?,?,?,?,?,?,?,?)");
        sentencia.setInt(1, vo.getNumero_documento());
        sentencia.setString(2, vo.getTelefono_persona());
        sentencia.setString(3, vo.getCelular_persona());
        sentencia.setString(4, vo.getDireccion_persona());
        sentencia.setString(5, vo.getEmail_persona());
        sentencia.setString(6, vo.getPagina_web_persona());
        sentencia.setString(7, vo.getDescripcion_persona());
        sentencia.setString(8, vo.getEstado_persona());
        int result = sentencia.executeUpdate();
        if (result < 0) {
            throw new SQLException("No se pudo ingresar datos de usuario");
        }
        return null;
    }

    public PersonaVO modificar(PersonaVO vo) throws SQLException {
        PreparedStatement sentencia = cnn.prepareStatement("UPDATE persona SET telefono_persona = ?,celular_persona = ?,direccion_persona = ?,email_persona = ?,pagina_web_persona = ? ,descripcion_persona = ? ,estado_persona = ? WHERE id_persona = ?");
        sentencia.setInt(0, vo.getId_persona());
        sentencia.setString(1, vo.getTelefono_persona());
        sentencia.setString(2, vo.getCelular_persona());
        sentencia.setString(3, vo.getDireccion_persona());
        sentencia.setString(4, vo.getEmail_persona());
        sentencia.setString(5, vo.getPagina_web_persona());
        sentencia.setString(5, vo.getDescripcion_persona());
        sentencia.setString(7, vo.getEstado_persona());
        int result = sentencia.executeUpdate();
        if (result < 0) {
            throw new SQLException("No se pudo actualizar datos de la persona");
        }
        return null;
    }

    public List<PersonaVO> consulta() throws SQLException {
        List Lista = new ArrayList();
        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM persona");
        ResultSet result = sentencia.executeQuery();
        PersonaVO personaVO;

        while (result.next()) {
            personaVO = new PersonaVO();
            personaVO.setId_persona(result.getInt(0));
            personaVO.setNumero_documento(result.getInt(1));
            personaVO.setTelefono_persona(result.getString(2));
            personaVO.setCelular_persona(result.getString(3));
            personaVO.setDireccion_persona(result.getString(4));
            personaVO.setEmail_persona(result.getString(5));
            personaVO.setPagina_web_persona(result.getString(6));
            personaVO.setDescripcion_persona(result.getString(7));
            Lista.add(personaVO);
        }
        return Lista;
    }

    public PersonaVO consultar(PersonaVO vo) throws SQLException {
        PreparedStatement sentencia = this.cnn.prepareStatement("SELECT * FROM persona WHERE numero_documento = ?");
        sentencia.setInt(1, vo.getNumero_documento());
        ResultSet resul = sentencia.executeQuery();
        if (resul.next()) {
            return getPersonaResult(resul);
        }
        return null;
    }

    private PersonaVO getPersonaResult(ResultSet resultado) throws SQLException {
        PersonaVO vo = new PersonaVO();
        vo.setId_persona(resultado.getInt("id_persona"));
        vo.setNumero_documento(resultado.getInt("numero_documento"));
        vo.setTelefono_persona(resultado.getString("telefono_persona"));
        vo.setCelular_persona(resultado.getString("celular_persona"));
        vo.setDireccion_persona(resultado.getString("direccion_persona"));
        vo.setEmail_persona(resultado.getString("email_persona"));
        vo.setPagina_web_persona(resultado.getString("pagina_web_persona"));
        vo.setDescripcion_persona(resultado.getString("descripcion_persona"));
        vo.setEstado_persona(resultado.getString("estado_persona"));
        return vo;
    }

}
