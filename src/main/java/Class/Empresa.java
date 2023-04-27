/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class Empresa {

    private int id;
    private String ruc;
    private String razon;
    private String direccion;
    private int usuario_id;
    private int estado; 
    
    private final ControllerConectar Conectar;

    public Empresa() {
        Conectar = new ControllerConectar();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void verEmpresas(JTable tabla) {
        String SQL = "select id, ruc, razon "
                + "from empresas "
                + "where usuarioid = '" + this.usuario_id + "' and estado = 1 "
                + "order by razon asc";
        
        DefaultTableModel modelo;
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        modelo.addColumn("Item");
        modelo.addColumn("RUC");
        modelo.addColumn("Razon Social");
        modelo.addColumn("");

        try {
            Object fila[] = new Object[4];
            int nrofila = 1;
            ResultSet rs = this.Conectar.consulta(SQL);
            while (rs.next()) {
                fila[0] = nrofila;
                fila[1] = rs.getString("ruc");
                fila[2] = rs.getString("razon");
                fila[3] = rs.getString("id");
                modelo.addRow(fila);
                nrofila++;
            }

            tabla.setModel(modelo);

            tabla.getColumnModel().getColumn(0).setPreferredWidth(35);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(400);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(0);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
            DBUtil.closeConn();
        }

    }

}
