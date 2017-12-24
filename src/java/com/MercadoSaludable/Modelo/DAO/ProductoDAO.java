/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Modelo.DAO;

import com.MercadoSaludable.Modelo.VO.ProductoVO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anyelith
 */
public class ProductoDAO {

    Connection cnn;

    public ProductoDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public ProductoVO insertar(ProductoVO vo) throws SQLException {

        PreparedStatement sentencia = cnn.prepareStatement("INSERT INTO producto (codigo_producto,nombre_producto,precio_producto,stock_producto,fecha_vencimiento_producto,descripcion_producto,estado_producto ) VALUES(?,?,?,?,?,?,?)");
        sentencia.setInt(0, vo.getCodigo_producto());
        sentencia.setString(1, vo.getNombre_producto());
        sentencia.setDouble(2, vo.getPrecio_producto());
        sentencia.setInt(3, vo.getStock_producto());
        sentencia.setDate(4, vo.getFecha_vencimiento_producto());
        sentencia.setString(5, vo.getDescripcion_producto());
        sentencia.setString(6, vo.getEstado_producto());
        int result = sentencia.executeUpdate();

        if (result < 0) {
            throw new SQLException("No se pudo ingresar datos del producto");
        }
        return null;
    }

    public ProductoVO modificar(ProductoVO vo) throws SQLException {

        PreparedStatement sentencia = cnn.prepareStatement("UPDATE producto SET codigo_producto =?,nombre_producto = ?,precio_producto =?,stock_producto =?,fecha_vencimiento_producto =?,descripcion_producto =?,estado_producto =? WHERE id_producto = ?");
        sentencia.setInt(1, vo.getCodigo_producto());
        sentencia.setString(2, vo.getNombre_producto());
        sentencia.setDouble(3, vo.getPrecio_producto());
        sentencia.setInt(4, vo.getStock_producto());
        sentencia.setDate(5, vo.getFecha_vencimiento_producto());
        sentencia.setString(6, vo.getDescripcion_producto());
        sentencia.setString(7, vo.getEstado_producto());
        int result = sentencia.executeUpdate();

        if (result < 0) {
            throw new SQLException("No se pudo actualizar los datos del producto");
        }
        return null;
    }

    public List<ProductoVO> consulta() throws SQLException {
        List Lista = new ArrayList();
        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM producto");
        ResultSet result = sentencia.executeQuery();
        ProductoVO productoVO;

        while (result.next()) {
            productoVO = new ProductoVO();
            productoVO.setId_producto(result.getInt(0));
            productoVO.setCodigo_producto(result.getInt(1));
            productoVO.setNombre_producto(result.getString(2));
            productoVO.setPrecio_producto(result.getDouble(3));
            productoVO.setStock_producto(result.getInt(4));
            productoVO.setFecha_vencimiento_producto(result.getDate(5));
            productoVO.setDescripcion_producto(result.getString(6));
            Lista.add(productoVO);

        }
        return Lista;
    }

    public ProductoVO consultar(ProductoVO vo) throws SQLException {
        PreparedStatement sentencia = this.cnn.prepareStatement("SELECT * FROM producto WHERE codigo_producto= ? AND nombre_producto= ?");
        sentencia.setInt(1, vo.getCodigo_producto());
        sentencia.setString(2, vo.getNombre_producto());
        ResultSet resul = sentencia.executeQuery();
        if (resul.next()) {
            return getProductoResult(resul);
        }
        return null;
    }

    private ProductoVO getProductoResult(ResultSet resultado) throws SQLException {
        ProductoVO vo = new ProductoVO();
        vo.setId_producto(resultado.getInt("id_producto"));
        vo.setCodigo_producto(resultado.getInt("codigo_producto"));
        vo.setNombre_producto(resultado.getString("nombre_producto"));
        vo.setPrecio_producto(resultado.getDouble("precio_producto"));
        vo.setStock_producto(resultado.getInt("stock_producto"));
        vo.setFecha_vencimiento_producto(Date.valueOf(resultado.getString("fecha_vencimiento_producto")));
        vo.setDescripcion_producto(resultado.getString("descripcion_producto"));
        vo.setEstado_producto(resultado.getString("estado_producto"));
        return vo;
    }
}
