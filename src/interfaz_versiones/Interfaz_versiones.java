/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz_versiones;

import controlador.registro_controller;
import vista.registro;


/**
 *
 * @author ANDRES COELLO
 */
public class Interfaz_versiones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        registro ventana = new registro();
        ventana.setLocationRelativeTo(null);
        registro_controller control = new registro_controller(ventana);
        control.IniciarVista();
        ventana.setVisible(true);
    }
    
}
