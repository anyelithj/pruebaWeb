package com.MercadoSaludable.Modelo.DAO;

import com.MercadoSaludable.Modelo.VO.DetalleFacturaVO;
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
public class DetalleFacturaDAO {

    Connection cnn;

    public DetalleFacturaDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public DetalleFacturaVO insertar(DetalleFacturaVO vo) throws SQLException {
        PreparedStatement sentencia = cnn.prepareStatement("INSERT INTO detalle_factura(descripcion,cantidad,valor_unitario) VALUES(?,?,?)");
        sentencia.setString(1, vo.getDescripcion());
        sentencia.setInt(2, vo.getCantidad());
        sentencia.setDouble(3, vo.getValor_unitario());

        int result = sentencia.executeUpdate();
        if (result < 0) {
            throw new SQLException("No se puede ingresar datos de Usuario");
        }
        return null;
    }

    public DetalleFacturaVO modificar(DetalleFacturaVO vo) throws SQLException {
        PreparedStatement sentencia = cnn.prepareStatement("UPDATE detalle_factura SET descripcion = ?,cantidad = ?,valor_unitario = ? WHERE id_detalle_factura = ?");
        sentencia.setInt(0, vo.getId_detalle_factura());
        sentencia.setString(1, vo.getDescripcion());
        sentencia.setInt(2, vo.getCantidad());
        sentencia.setDouble(3, vo.getValor_unitario());

        int result = sentencia.executeUpdate();
        if (result < 0) {
            throw new SQLException("No se actualizaron los datos");
        }
        return null;
    }

    //consulta para listar una tabla completa

    public List<DetalleFacturaVO> consulta() throws SQLException {
        List Lista = new ArrayList();
        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM detalle_factura");
        ResultSet result = sentencia.executeQuery();
        DetalleFacturaVO detalleFacturaVO;

        while (result.next()) {
            detalleFacturaVO = new DetalleFacturaVO();
            detalleFacturaVO.setId_detalle_factura(result.getInt(0));
            detalleFacturaVO.setDescripcion(result.getString(1));
            detalleFacturaVO.setCantidad(result.getInt(2));
            detalleFacturaVO.setValor_unitario(result.getDouble(3));
            Lista.add(detalleFacturaVO);
        }
        return Lista;

    }
    //consulta para un solo registro

    public DetalleFacturaVO consultar(DetalleFacturaVO vo) throws SQLException {
        PreparedStatement sentencia = this.cnn.prepareStatement("SELECT*FROM detalle_factura where id_detalle_factura=?");
        sentencia.setInt(0, vo.getId_detalle_factura());
        ResultSet resul = sentencia.executeQuery();
        if (resul.next()) {
            return getDetalleFacturaResult(resul);
        }
        return null;
    }

    private DetalleFacturaVO getDetalleFacturaResult(ResultSet resultado) throws SQLException {
        DetalleFacturaVO vo = new DetalleFacturaVO();//creo objeto de tipo UsuarioVO que se llama vo
        vo.setDescripcion(resultado.getString("descripcion"));
        vo.setCantidad(resultado.getInt("cantidad"));
        vo.setValor_unitario(resultado.getDouble("valor_unitario"));
        return vo;
    }
}
