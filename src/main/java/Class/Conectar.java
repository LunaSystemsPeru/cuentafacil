/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class Conectar {

    private static Connection _CONNECTION = null;
        private static final String _BD = "brunoasc_new_sonomusic"; // Nombre de BD.
    private static final String _USER = "brunoasc_luis_bd"; // Usuario de BD.
    private static final String _PASSWORD = "C]6&TN4Bt@&I"; // Password de BD.
    private static final String _URL = "artemisa.servidoresph.com";
    private static final String _DRIVER = "com.mysql.cj.jdbc.Driver";
    String _SERVER = "jdbc:mysql://" + _URL + ":3306/" + _BD;

    private Conectar() {
        try {

            Class.forName(_DRIVER);
            _CONNECTION = DriverManager.getConnection(_SERVER, _USER, _PASSWORD);
            System.out.println("Conectando al Servidor: " + _SERVER);

        } catch (ClassNotFoundException | SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error: Imposible realizar la conexion a BD." + server + "," + user + "," + password);
            JOptionPane.showMessageDialog(null, "Error al conectar \n" + e.getLocalizedMessage());
            System.out.print(e);
            e.printStackTrace();
            //System.exit(0);
        }
    }
    
   public static Connection getConnection() {

        if (_CONNECTION == null) {
            new Conectar();
        }
        return _CONNECTION;
    } // Fin getConnection
}
