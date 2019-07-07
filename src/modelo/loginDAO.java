/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import vista.login;

/**
 *
 * @author ANDRES COELLO
 */
public class loginDAO extends conexion{

    private Component login;
    public void consultarUsuario(login_modelo login_modelo) throws SQLException{
        conectar();
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contrasena = ?";
        PreparedStatement statement  = conexion.prepareStatement(sql);
        statement.setString(1, login_modelo.getUsuario());
        statement.setString(2, login_modelo.getClave());
        ResultSet result = statement.executeQuery();
        while(result.next()){
            String obt = result.getString(2);
            String obt_2 = result.getString(4);
            System.out.println(obt); 
            System.out.println(obt_2);
            if(obt.length() > 0 && obt_2.length() > 0){
                JOptionPane.showMessageDialog(login, "ACCESO CONCEDIDO "+ " Bienvenido.. ", "", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(result.next() == false){
            JOptionPane.showMessageDialog(login, "DATOS INVALIDOS", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
}
