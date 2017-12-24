/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoSaludable.Modelo.DAO;

import com.MercadoSaludable.Modelo.VO.CategoriaVO;
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
public class CategoriaDAO {
     Connection cnn;
    //contructor que inicializa nuestra conexión
    public CategoriaDAO(Connection cnn){
        this.cnn = cnn;
    }
    public CategoriaVO insertar(CategoriaVO vo) throws SQLException{
    
      PreparedStatement sentencia = cnn.prepareStatement("INSERT INTO categoria (nombre_categoria ,descripcion_categoria,estado_categoria) VALUES(?,?,?)");
      sentencia.setString(1, vo.getNombre_categoria());
      sentencia.setString(2, vo.getDescripcion_categoria());
      sentencia.setString(3, vo.getEstado_categoria());
      //sentencia es el nombre del objeto
      //result variable 

      int result = sentencia.executeUpdate();
      
        if (result < 0) {
            throw new SQLException("No se pudo ingresar datos de usuario");
        }
          return null;
    }
    //se crea el método modificar 
    public CategoriaVO modificar(CategoriaVO vo) throws SQLException{
        
    PreparedStatement sentencia = cnn.prepareStatement ("UPDATE categoria SET nombre_categoria = ?,descripcion_categoria = ? ,estado_categoria = ? WHERE id_categoria = ?");
    sentencia.setInt (0 , vo.getId_categoria());
    sentencia.setString(1, vo.getNombre_categoria());
    sentencia.setString(2, vo.getDescripcion_categoria());
    
   
    int result = sentencia.executeUpdate();
    
    if( result < 0){
        throw new SQLException("No se actualizaron los datos");
     }
    return null;
   }
    //creo el método de consulta.
    public List<CategoriaVO> consulta()throws SQLException{
    List Lista = new ArrayList();
    PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM categoria");
    ResultSet result = sentencia.executeQuery();// result es el nombre del objeto ResultSet
    CategoriaVO categoriaVO;//objeto de la clase  CategoriaVO para acceder a los atributos de esa claser 
    //con los métodos de retorno.
    
        while (result.next()) { 
            categoriaVO = new CategoriaVO();
            categoriaVO.setId_categoria(result.getInt(0));
            categoriaVO.setNombre_categoria(result.getString(1));
            categoriaVO.setDescripcion_categoria(result.getString(2));
            Lista.add(categoriaVO);//agrega los datos a lista llamada Lista 
            
        }
         return Lista;   
    }
     public CategoriaVO consultar(CategoriaVO vo) throws SQLException {
        PreparedStatement sentencia = this.cnn.prepareStatement("SELECT*FROM categoria where nombre_categoria=? ");
        sentencia.setString(1, vo.getNombre_categoria());    
        ResultSet resul = sentencia.executeQuery();
        if (resul.next()) {
            return getCategoriaResult(resul);
        }
        return null;
    }
    private CategoriaVO getCategoriaResult(ResultSet resultado)throws SQLException{
        CategoriaVO vo = new  CategoriaVO();//creo objeto de tipo UsuarioVO que se llama vo
        vo.setId_categoria(resultado.getInt("id_categoria"));
        vo.setNombre_categoria(resultado.getString("nombre_categoria"));
        vo.setDescripcion_categoria(resultado.getString("descripcion_categoria"));
        vo.setEstado_categoria(resultado.getString("estado_categoria"));
        return vo;   
    }
}
