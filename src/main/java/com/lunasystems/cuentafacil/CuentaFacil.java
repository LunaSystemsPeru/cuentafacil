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
        // TODO code application logic here
/*        leerUsuarios();

        System.out.println("inicio espera");
        try {
            //Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(90 * 1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("fin espera");
        leerUsuarios();
         */
        
        frm_principal formulario = new frm_principal();
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }
    
    private static void leerUsuarios() {
        usuario.ver_ventas();
    }
    
}
