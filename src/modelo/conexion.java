/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Instituto
 */
public class conexion {
    protected Connection conexion;
    protected PreparedStatement consultas;
    protected ResultSet registro;
    
    
    protected void conectar() throws SQLException{
        try{
        String host = "localhost";
        String puerto = "3306";
        String baseDatos = "versiones";
        String usuario = "root";
        String clave = "";
        String url = "jdbc:mysql://"+ host + ":" + puerto + "/" + baseDatos;
        Class.forName("com.mysql.jdbc.Driver");
        conexion=DriverManager.getConnection(url, usuario, clave);
        }catch(ClassNotFoundException ex){
        System.out.println(ex.getMessage());
        }
    }
    
    protected void desconectar() throws SQLException {
        conexion.close();
    }
    
    
    
}
