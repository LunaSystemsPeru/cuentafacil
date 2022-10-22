/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Luis
 */
public class Usuario {
     ControllerConectar Conectar = new ControllerConectar();
    
    private int id;

    public Usuario() {
    }
    
    public void ver_ventas() {
        try {
            ResultSet rs = Conectar.consulta("select * from usuarios limit 1");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
