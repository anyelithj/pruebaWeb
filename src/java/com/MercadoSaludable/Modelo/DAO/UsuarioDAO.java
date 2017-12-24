
package com.MercadoSaludable.Modelo.DAO;

import com.MercadoSaludable.Modelo.VO.UsuarioVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Anyelith
 */
public class UsuarioDAO {
    
    Connection cnn;
    //Constructor para inicializar la conexión 
    public UsuarioDAO(Connection cnn){
        this.cnn = cnn;
    }
    //méttodo que lo llamo insertar en este caso y le pongo un nombre un objeto de tipo UsuarioVO
    public UsuarioVO insertar (UsuarioVO vo)throws SQLException{
        //PreparedStatement:nos permite definir una sentencia SQL base, que nos sirve para modificar/
        //insertar/buscar uno o varios registros con sólo cambiar los valores de los parámetros que especifiquemos.
        //this: hace referencia al objeto. 
        //Para recuperar las claves generadas automáticamente que se generan mediante una sentencia INSERT
        //incluye el parámetro Statement.RETURN_GENERATED_KEYS, el tipo de datos de las claves generadas automáticamente en ResultSet es DECIMAL, 
        //con independencia del tipo de datos de la columna correspondiente.
        String resultado = null;
        PreparedStatement sentencia = cnn.prepareStatement("INSERT INTO usuario (nombre_usuario ,fecha_hora_creacion_usuario, password_usuario, estado_usuario) VALUES (?,?,?,?)");
        sentencia.setString(1, vo.getNombre_usuario());
        sentencia.setDate(2, vo.getFecha_hora_creacion_usuario());
        sentencia.setString(3, vo.getPassword_usuario());
        sentencia.setString(4, vo.getEstado_usuario());     
        //se ejecuta la sentencia sentencia.executeUpdate();
        //cada sentencia ejecuta una llave         
        int result = sentencia.executeUpdate();
        if(result > 0){
            resultado ="registro exitoso"; 
        }
        return null;
    }
    //creo el método modificar que recibe como parametro un objeto de tipo UsuarioVO
    public UsuarioVO modificar(UsuarioVO vo) throws SQLException{
        String resultado = null;
        PreparedStatement sentencia = cnn.prepareStatement("UPDATE usuario SET nombre_usuario = ? , password_usuario = ? ,estado_usuario = ? WHERE id_usuario = ? ");    
        sentencia.setString( 1, vo.getNombre_usuario());
        sentencia.setString ( 2, vo.getPassword_usuario());
        sentencia.setString(3, vo.getEstado_usuario()); 
        sentencia.setInt( 4 ,vo.getId_usuario());
        
        int resul = sentencia.executeUpdate();
        if(resul > 0){
            resultado ="Actualizacion exitoso"; 
        }
        return  null;
    }
    

     //otra forma de realizar el método que traer los resultados de el usuario 
    //
    public UsuarioVO consultar(String nombre_usuario,String clave) throws SQLException {
        PreparedStatement sentencia = this.cnn.prepareStatement("SELECT*FROM usuario where nombre_usuario=? AND password_usuario=?");
        sentencia.setString(1, nombre_usuario);
        sentencia.setString(2, clave);
        ResultSet resul = sentencia.executeQuery();
        if (resul.next()) {
            return getUsuarioResult(resul);
        }
        return null;
    }
    private UsuarioVO getUsuarioResult(ResultSet resultado)throws SQLException{
        UsuarioVO vo = new  UsuarioVO();//creo objeto de tipo UsuarioVO que se llama vo
        vo.setId_usuario(resultado.getInt("id_usuario"));
        vo.setNombre_usuario(resultado.getString("nombre_usuario"));
        vo.setPassword_usuario(resultado.getString("password_usuario"));
        vo.setFecha_hora_creacion_usuario(resultado.getDate("fecha_hora_creacion_usuario"));
        vo.setEstado_usuario(resultado.getString("estado_usuario"));
        return vo;   
    }
// creo el método eliminar 
    public void eliminar(UsuarioVO vo) throws SQLException{
        PreparedStatement sentencia = this.cnn.prepareStatement("DELETE * FROM usuario WHERE idusuario=?");
        sentencia.setInt(0,vo.getId_usuario());
        sentencia.executeUpdate();
    }

}
