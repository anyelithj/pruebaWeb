/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Modelo.DAO;

import com.MercadoSaludable.Modelo.VO.TipoPersonaVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anyelith
 */
public class TipoPersonaDAO {

    Connection cnn;

    public TipoPersonaDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public TipoPersonaVO insertar(TipoPersonaVO vo) throws SQLException {
        PreparedStatement sentencia = cnn.prepareStatement("INSERT INTO tipo_persona(tipo_persona,entidad,descripcion,estado_tipo_persona) VALUES(?,?,?,?)");
        sentencia.setString(1, vo.getTipo_persona());
        sentencia.setString(2, vo.getEntidad());
        sentencia.setString(3, vo.getDescripcion());
        sentencia.setString(4, vo.getEstadoTipopersona());
        int result = sentencia.executeUpdate();

        if (result < 0) {
            throw new SQLException("No se pudo ingresar el tipo de persona");
        }
        return null;
    }

    public TipoPersonaVO modificar(TipoPersonaVO vo) throws SQLException {

        PreparedStatement sentencia = cnn.prepareStatement("UPDATE  tipo_persona SET tipo_persona = ? ,entidad = ?,descripcion = ?,estado_tipo_persona =? WHERE id_tipo_persona = ?");
        sentencia.setInt(0, vo.getId_tipo_persona());
        sentencia.setString(1, vo.getTipo_persona());
        sentencia.setString(2, vo.getEntidad());
        sentencia.setString(3, vo.getDescripcion());
        sentencia.setString(4, vo.getEstadoTipopersona());
        int result = sentencia.executeUpdate();

        if (result < 0) {
            throw new SQLException("No se actualizaron los datos");
        }
        return null;
    }

    public List<TipoPersonaVO> consulta() throws SQLException {
        List Lista = new ArrayList();
        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM tipo_persona");
        ResultSet result = sentencia.executeQuery();
        TipoPersonaVO tipoPersonaVO;

        while (result.next()) {
            tipoPersonaVO = new TipoPersonaVO();
            tipoPersonaVO.setId_tipo_persona(result.getInt(0));
            tipoPersonaVO.setTipo_persona(result.getString(1));
            tipoPersonaVO.setEntidad(result.getString(2));
            tipoPersonaVO.setDescripcion(result.getString(3));
            tipoPersonaVO.setEstadoTipopersona(result.getString(4));
            Lista.add(tipoPersonaVO);
        }
        return Lista;
    }

    public TipoPersonaVO consultar(TipoPersonaVO vo) throws SQLException {
        PreparedStatement sentencia = this.cnn.prepareStatement("SELECT * FROM tipo_persona= ? AND entidad=?");
        sentencia.setString(1, vo.getTipo_persona());
        sentencia.setString(2, vo.getEntidad());
        ResultSet resul = sentencia.executeQuery();
        if (resul.next()) {
            return getTipoPersonaResult(resul);
        }
        return null;
    }

    private TipoPersonaVO getTipoPersonaResult(ResultSet resultado) throws SQLException {
        TipoPersonaVO vo = new TipoPersonaVO();
        vo.setId_tipo_persona(resultado.getInt("id_tipo_persona"));
        vo.setTipo_persona(resultado.getString("tipo_persona"));
        vo.setEntidad(resultado.getString("entidad"));
        vo.setDescripcion(resultado.getString("descripcion"));
        vo.setEstadoTipopersona(resultado.getString(""));
        return vo;
    }
}
