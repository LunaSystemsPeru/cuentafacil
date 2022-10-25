/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.lunasystems.cuentafacil;

import Class.Usuario;
import Main.frm_principal;

/**
 *
 * @author Luis
 */
public class CuentaFacil {
    
    static Usuario usuario = new Usuario();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        frm_principal formulario = new frm_principal();
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }
   
}
