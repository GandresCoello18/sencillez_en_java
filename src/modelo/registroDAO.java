/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.SQLException;

/**
 *
 * @author ANDRES COELLO
 */
public class registroDAO extends conexion{
    public void insertarUsuario(registro_modelo registro_modelo) throws SQLException{
        conectar();
        consultas = conexion.prepareStatement("insert into usuarios (usuario, correo, contrasena) values (?,?,?)");
        consultas.setString(1, registro_modelo.getUsuario());
        consultas.setString(2, registro_modelo.getCorreo());
        consultas.setString(3, registro_modelo.getContrasena());
        consultas.executeUpdate();
        desconectar();
    }
}
