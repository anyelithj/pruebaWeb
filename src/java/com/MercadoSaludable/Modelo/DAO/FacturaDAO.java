/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Modelo.DAO;

import com.MercadoSaludable.Modelo.VO.FacturaVO;
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
public class FacturaDAO {

    Connection cnn;

    public FacturaDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public FacturaVO insertar(FacturaVO vo) throws SQLException {
        PreparedStatement sentencia = cnn.prepareStatement("INSERT INTO factura(tipo_comprobante,num_comprobante,fecha_hora,fecha_hora_entrega,fecha_hora_recogida,subtotal,iva,total_apagar) VALUES(?,?,?,?,?,?,?,?)");
        sentencia.setString(1, vo.getTipo_comprobante());
        sentencia.setInt(2, vo.getNum_comprobante());
        sentencia.setDate(3, vo.getFecha_hora());
        sentencia.setDate(4, vo.getFecha_hora_entrega());
        sentencia.setDate(5, vo.getFecha_hora_recogida());
        sentencia.setDouble(6, vo.getSubtotal());
        sentencia.setDouble(7, vo.getIva());
        sentencia.setDouble(8, vo.getTotal_apagar());
        int result = sentencia.executeUpdate();
        if (result < 0) {
            throw new SQLException("No se pudo ingresar datos de usuario");
        }
        return null;
    }

    public FacturaVO modificar(FacturaVO vo) throws SQLException {
        PreparedStatement sentencia = cnn.prepareStatement("UPDATE factura SET tipo_comprobante = ?,subtotal = ?,iva = ?,total_apagar = ? WHERE id_factura = ? ");
        sentencia.setInt(0, vo.getId_factura());
        sentencia.setString(1, vo.getTipo_comprobante());
        sentencia.setDouble(2, vo.getSubtotal());
        sentencia.setDouble(3, vo.getIva());
        sentencia.setDouble(4, vo.getTotal_apagar());
        int result = sentencia.executeUpdate();
        if (result < 0) {
            throw new SQLException("No se pudo actualizar datos de la factura");
        }
        return null;
    }

    public List<FacturaVO> consulta() throws SQLException {
        List Lista = new ArrayList();
        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM factura");
        ResultSet result = sentencia.executeQuery();
        FacturaVO facturaVO;

        while (result.next()) {
            facturaVO = new FacturaVO();
            facturaVO.setId_factura(result.getInt(0));
            facturaVO.setTipo_comprobante(result.getString(1));
            facturaVO.setNum_comprobante(result.getInt(2));
            facturaVO.setFecha_hora(result.getDate(3));
            facturaVO.setFecha_hora_entrega(result.getDate(4));
            facturaVO.setFecha_hora_recogida(result.getDate(5));
            facturaVO.setSubtotal(result.getDouble(6));
            facturaVO.setIva(result.getDouble(7));
            facturaVO.setTotal_apagar(result.getDouble(8));
            Lista.add(facturaVO);
        }
        return Lista;
    }

    public FacturaVO consultar(FacturaVO vo) throws SQLException {
        PreparedStatement sentencia = this.cnn.prepareStatement("SELECT * FROM factura WHERE num_comprobante = ?");
        sentencia.setInt(1, vo.getNum_comprobante());
        ResultSet resul = sentencia.executeQuery();
        if (resul.next()) {
            return getFacturaResult(resul);
        }
        return null;
    }

    private FacturaVO getFacturaResult(ResultSet resultado) throws SQLException {
        FacturaVO vo = new FacturaVO();
        vo.setId_factura(resultado.getInt("id_factura"));
        vo.setTipo_comprobante(resultado.getString("tipo_comprobante"));
        vo.setNum_comprobante(resultado.getInt("num_comprobante"));
        vo.setFecha_hora(resultado.getDate("fecha_hora"));
        vo.setFecha_hora_entrega(resultado.getDate("fecha_hora_entrega"));
        vo.setFecha_hora_recogida(resultado.getDate("fecha_hora_recogida"));
        vo.setSubtotal(resultado.getDouble("subtotal"));
        vo.setIva(resultado.getDouble("iva"));
        vo.setTotal_apagar(resultado.getDouble("total_apagar"));
        return vo;
    }
}
