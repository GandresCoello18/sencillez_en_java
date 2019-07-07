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
public class registro_controller {
    private registro registro;
    private registroDAO registroDAO;
    
    public registro_controller(registro registro){
        this.registro = registro;
        registroDAO = new registroDAO();
        eventos();
    }
    
    public void IniciarVista(){
        registro.setVisible(true);
    }
    
    private void eventos(){
        registro.boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String u = registro.usuario_registro.getText();
                String c = registro.correo_registro.getText();
                String contr = registro.contraseña_registro.getText();
                registro_modelo llamar = new registro_modelo();
                
                llamar.setUsuario(u);
                llamar.setCorreo(c);
                llamar.setContrasena(contr);
                try{
                    registroDAO.insertarUsuario(llamar);
                    JOptionPane.showMessageDialog(registro, "DATOS GUARDADOS "+ " CORRECTAMENTE ", "EXITO", JOptionPane.INFORMATION_MESSAGE);                   
                        login ventana = new login();
                        ventana.setLocationRelativeTo(null);
                        login_controller control = new login_controller(ventana);
                        control.IniciarVista();
                        ventana.setVisible(true);
                        registro.setVisible(false);
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(registro, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        
        });
    }
    
}
