/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.lunasystems.cuentafacil;

import Main.frm_principal;
import javax.swing.JFrame;

/**
 *
 * @author Luis
 */
public class CuentaFacil {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        frm_principal formulario = new frm_principal();
        formulario.setLocationRelativeTo(null);
        formulario.setExtendedState(JFrame.MAXIMIZED_BOTH);
        formulario.setVisible(true);
    }
   
}
