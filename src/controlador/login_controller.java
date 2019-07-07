/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import vista. *;
import modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Instituto
 */
public class login_controller {
    private login login;
    private loginDAO loginDAO;
    
    public login_controller(login login){
        this.login = login;
        loginDAO = new loginDAO();
        eventos();
    }
    
    public void IniciarVista(){
        login.setVisible(true);
    }
    
    private void eventos(){
        login.boton_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = login.usuario_login.getText();
                String contrasena = login.contraseña_login.getText();
                login_modelo llamar = new login_modelo();
                
                llamar.setUsuario(usuario);
                llamar.setClave(contrasena);
                try{
                    loginDAO.consultarUsuario(llamar);
                    //JOptionPane.showMessageDialog(login, "ACCESO CONCEDIDO "+ " Bienvenido.. ", "", JOptionPane.INFORMATION_MESSAGE);
                    
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(login, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        
        });
    }
    
}
