
package com.MercadoSaludable.Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Anyelith
 */
public class Conexion {
     //método estatico   
    public static Connection getConexionBD(){
        try {
            //inicializa contexto que es donde esta alogada la base de datos
            Context ctx = new InitialContext();
            //El objeto de tipo de DataSource:recibe los datos de la base de datos o sea hace la conexion a la base de datos
            DataSource ds = (DataSource) ctx.lookup("jdbc/mercadosaludable");
            Connection cnn =ds.getConnection();//recibe la conexión
            cnn.setAutoCommit(false);//setAutoCommit:Activa o desactiva el modo 'auto-commit' en consultas para la conexión a la base de datos.verifica la base de datos 
            return cnn;
        }catch (NamingException ex){
            ex.getMessage();
            return null;
        }catch (SQLException ex){
            ex.getMessage();
            return null;
        }
    }
    
    
    
    public static void desconectarBD(Connection cnn){
        if (cnn !=null){
            try{
                cnn.commit();
                cnn.close();
            }catch (SQLException ex){
                ex.getMessage();
            }
        }
    }
    
    public static void revesarCambioBD(Connection cnn){
        if(cnn != null){
            try {
                cnn.rollback();
                cnn.close();
                
            }catch (SQLException ex){
                ex.getMessage();
            }
        }
    }
}
