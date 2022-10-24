/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Luis
 */
public class ControllerConectar {

    Connection databaseConnection;

    public ControllerConectar() {
        try {
            this.databaseConnection = DBUtil.getConn();
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }

    }

    public Statement getStatement() {
        Statement st = null;
        try {
            databaseConnection = DBUtil.getConn();
            st = databaseConnection.createStatement();
        } catch (SQLException e) {
            System.out.println("Error: Conexión incorrecta.");
            e.printStackTrace();
        }
        return st;
    }

    /**
     * Método para realizar consultas del tipo: SELECT * FROM tabla WHERE..."
     *
     * @param st
     * @param cadena La consulta en concreto
     * @return
     */
    public ResultSet consulta(String cadena) {
        ResultSet rs = null;
        Statement st = this.getStatement();
        try {
            rs = st.executeQuery(cadena);
        } catch (SQLException e) {
            System.out.println("Error con: " + cadena);
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        }
        return rs;
    }
}
