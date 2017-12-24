package com.MercadoSaludable.Modelo.DAO;

import com.MercadoSaludable.Modelo.VO.PagoVO;
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
public class PagoDAO {

    Connection cnn;
    private Object Lista;

    public PagoDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public PagoVO insertar(PagoVO vo) throws SQLException {
        PreparedStatement sentencia = cnn.prepareStatement("INSERT INTO pago(fecha_de_pago, tipo_de_pago, novedades) VALUES(? , ? , ?)");
        sentencia.setDate(1, vo.getFecha_de_pago());
        sentencia.setString(2, vo.getTipo_de_pago());
        sentencia.setString(3, vo.getNovedades());

        int result = sentencia.executeUpdate();

        if (result < 0) {
            throw new SQLException("No se pudo ingresar datos de usuario");
        }
        return null;
    }

    public PagoVO modificar(PagoVO vo) throws SQLException {
        PreparedStatement sentencia = cnn.prepareStatement("UPDATE pago SET fecha_de_pago = ? , tipo_de_pago = ?, novedades = ? WHERE id_pago = ?");
        sentencia.setInt(0, vo.getId_pago());
        sentencia.setDate(1, vo.getFecha_de_pago());
        sentencia.setString(2, vo.getTipo_de_pago());
        sentencia.setString(3, vo.getNovedades());

        int result = sentencia.executeUpdate();
        if (result < 0) {
            throw new SQLException("No se actualizaron los datos");
        }
        return null;
    }

    public List<PagoVO> consulta() throws SQLException {
        List Lista = new ArrayList();
        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM Pago");
        ResultSet result = sentencia.executeQuery();
        PagoVO pagoVO;

        while (result.next()) {
            pagoVO = new PagoVO();
            pagoVO.setId_pago(result.getInt(0));
            pagoVO.setFecha_de_pago(result.getDate(1));
            pagoVO.setTipo_de_pago(result.getString(2));
            pagoVO.setNovedades(result.getString(3));
            Lista.add(pagoVO);
        }
        return Lista;
    }

    public PagoVO consutar(PagoVO vo) throws SQLException {
        PreparedStatement sentencia = this.cnn.prepareStatement("SELECT * FROM pago WHERE fecha_de_pago = ?");
        sentencia.setDate(1, vo.getFecha_de_pago());
        ResultSet resul = sentencia.executeQuery();
        if (resul.next()) {
            return getPagoResult(resul);
        }
        return null;
    }

    private PagoVO getPagoResult(ResultSet resultado) throws SQLException {
        PagoVO vo = new PagoVO();
        vo.setId_pago(resultado.getInt("id_pago"));
        vo.setFecha_de_pago(resultado.getDate("fecha_de_pago"));
        vo.setTipo_de_pago(resultado.getString("tipo_de_pago"));
        vo.setNovedades(resultado.getString("novedades"));
        return vo;

    }
}
