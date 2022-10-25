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
public class ObjetoComboBox {

    private int id;
    private String nombre;
    private final ControllerConectar Conectar;

    public ObjetoComboBox() {
        Conectar = new ControllerConectar();
    }

    public ObjetoComboBox(int id, String nombre) {
        Conectar = new ControllerConectar();
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void llenarComboParametros(JComboBox jcombo, int parametroid) {
        jcombo.removeAllItems();

        String SQL = "select * "
                + "from parametros_detalles "
                + "where parametroid = " + parametroid;
        try {
            ResultSet rs = Conectar.consulta(SQL);
            while (rs.next()) {
                jcombo.addItem(new ObjetoComboBox(rs.getInt("id"), rs.getString("nombre")));
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Override
    public String toString() {
        return nombre;
    }

}
