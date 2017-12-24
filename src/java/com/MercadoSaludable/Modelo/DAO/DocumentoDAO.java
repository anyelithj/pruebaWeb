package com.MercadoSaludable.Modelo.DAO;

import com.MercadoSaludable.Modelo.VO.DocumentoVO;
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
public class DocumentoDAO {

    Connection cnn;

    public DocumentoDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public DocumentoVO insertar(DocumentoVO vo) throws SQLException {

        PreparedStatement sentencia = cnn.prepareStatement("INSERT INTO documento(descripcion_documento) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
        sentencia.setString(1, vo.getDescripcion_documento());
        int result = sentencia.executeUpdate();
        if (result < 0) {
            throw new SQLException("No se pudo ingresar datos de usuario");
        }
        return null;
    }

    public DocumentoVO modificar(DocumentoVO vo) throws SQLException {
        PreparedStatement sentencia = cnn.prepareStatement("UPDATE documento SET descripcion_documento = ? WHERE id_documento = ?");
        sentencia.setInt(0, vo.getId_documento());
        sentencia.setString(1, vo.getDescripcion_documento());
        int result = sentencia.executeUpdate();
        if (result < 0) {
            throw new SQLException("No se actualizaron los datos");
        }
        return null;
    }

    public List<DocumentoVO> consulta() throws SQLException {
        List Lista = new ArrayList();
        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM documento");
        ResultSet result = sentencia.executeQuery();
        DocumentoVO documentoVO;

        while (result.next()) {
            documentoVO = new DocumentoVO();
            documentoVO.setId_documento(result.getInt(0));
            documentoVO.setDescripcion_documento(result.getString(2));
            Lista.add(documentoVO);
        }
        return Lista;
    }

    public DocumentoVO consultar(DocumentoVO vo) throws SQLException {
        PreparedStatement sentencia = this.cnn.prepareStatement("SELECT * FROM  documento  WHERE  id_documento= ?");
        sentencia.setInt(1, vo.getId_documento());
        ResultSet resul = sentencia.executeQuery();
        if (resul.next()) {
            return getDocumentoResult(resul);
        }
        return null;
    }

    private DocumentoVO getDocumentoResult(ResultSet resultado) throws SQLException {
        DocumentoVO vo = new DocumentoVO();
        vo.setId_documento(resultado.getInt("Id_Documento"));
        vo.setDescripcion_documento(resultado.getString("descripcion_documento"));
        return vo;
    }
}
