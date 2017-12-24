package com.MercadoSaludable.Modelo.DAO;

import com.MercadoSaludable.Modelo.VO.PermisoVO;
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
public class PermisoDAO {

    Connection cnn;

    public PermisoDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public PermisoVO insertar(PermisoVO vo) throws SQLException {
        PreparedStatement sentencia = cnn.prepareStatement("INSERT INTO permiso (permiso,estado_permiso,rol) VALUES (?,?,?)");
        sentencia.setString(1, vo.getPermiso());
        sentencia.setString(2, vo.getRol());
        sentencia.setString(3, vo.getEstado_permiso());
        sentencia.executeUpdate();
        ResultSet llaves = sentencia.getGeneratedKeys();
        if (llaves.next()) {
            vo.setId_permiso(llaves.getInt(1));
        }
        return null;
    }

    public PermisoVO modificar(PermisoVO vo) throws SQLException {
        PreparedStatement sentencia = cnn.prepareStatement("UPDATE permiso SET permiso = ?,estado_permiso = ?,rol = ? WHERE id_permiso");
        sentencia.setInt(0, vo.getId_permiso());
        sentencia.setString(1, vo.getPermiso());
        sentencia.setString(2, vo.getRol());
        sentencia.setString(3, vo.getEstado_permiso());
        sentencia.executeUpdate();
        ResultSet llaves = sentencia.getGeneratedKeys();
        if (llaves.next()) {
            vo.setId_permiso(llaves.getInt(1));
        }
        return null;
    }

    public List<PermisoVO> consultar() throws SQLException {
        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM permiso");
        List<PermisoVO> lista = new ArrayList<>();
        ResultSet result = sentencia.executeQuery();
        while (result.next()) {
            lista.add(getPermisoResult(result));
        }
        return lista;
    }

    public PermisoVO consultar(PermisoVO vo) throws SQLException {
        PreparedStatement sentencia = this.cnn.prepareStatement("SEECT * FROM permiso WHERE id_permiso= ?");
        sentencia.setInt(0, vo.getId_permiso());
        ResultSet result = sentencia.executeQuery();
        if (result.next()) {
            return getPermisoResult(result);
        }
        return null;
    }

    private PermisoVO getPermisoResult(ResultSet resultado) throws SQLException {
        PermisoVO vo = new PermisoVO();
        vo.setId_permiso(resultado.getInt("id_permiso"));
        vo.setPermiso(resultado.getString("permiso"));
        vo.setEstado_permiso(resultado.getString("estado_permiso"));
        vo.setRol(resultado.getString("rol"));
        return vo;
    }

}
