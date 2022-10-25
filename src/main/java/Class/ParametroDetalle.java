/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

/**
 *
 * @author Luis
 */
public class ParametroDetalle {

    private int id;
    private int parametroid;
    private String nombre;
    private String valor1;
    private String valor2;
    private final ControllerConectar Conectar;

    public ParametroDetalle() {
        Conectar = new ControllerConectar();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParametroid() {
        return parametroid;
    }

    public void setParametroid(int parametroid) {
        this.parametroid = parametroid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor1() {
        return valor1;
    }

    public void setValor1(String valor1) {
        this.valor1 = valor1;
    }

    public String getValor2() {
        return valor2;
    }

    public void setValor2(String valor2) {
        this.valor2 = valor2;
    }

    public void ObtenerDatos() {
        String SQL = "select * from parametros_detalles where id = " + this.id;
        try {
            ResultSet rs = Conectar.consulta(SQL);
            while (rs.first()) {
                this.nombre = rs.getString("nombre");
                this.valor1 = rs.getString("valor1");
                this.valor2 = rs.getString("valor2");
                this.parametroid = rs.getInt("parametroid");
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

}
