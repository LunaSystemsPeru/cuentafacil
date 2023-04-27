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
public class CuentaContable {

    FormatUtil Util;

    private int id;
    private int codigo_cuenta;
    private String nombre;
    private boolean es_titulo;
    private int cuenta_cargo;
    private int cuenta_abono;
    private int empresa_id;
    
    private final ControllerConectar Conectar;

    public CuentaContable() {
        Conectar = new ControllerConectar();
        Util = new FormatUtil();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo_cuenta() {
        return codigo_cuenta;
    }

    public void setCodigo_cuenta(int codigo_cuenta) {
        this.codigo_cuenta = codigo_cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEs_titulo() {
        return es_titulo;
    }

    public void setEs_titulo(boolean es_titulo) {
        this.es_titulo = es_titulo;
    }

    public int getCuenta_cargo() {
        return cuenta_cargo;
    }

    public void setCuenta_cargo(int cuenta_cargo) {
        this.cuenta_cargo = cuenta_cargo;
    }

    public int getCuenta_abono() {
        return cuenta_abono;
    }

    public void setCuenta_abono(int cuenta_abono) {
        this.cuenta_abono = cuenta_abono;
    }

    public int getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(int empresa_id) {
        this.empresa_id = empresa_id;
    }

    public void verCuentas(JTable tabla, String SQL) {
        DefaultTableModel mostrar = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        mostrar.addColumn("Cod Cuenta");
        mostrar.addColumn("Descripcion");

        try {
            ResultSet rs = Conectar.consulta(SQL);
            while (rs.next()) {
                Object fila[] = new Object[2];

                String codcuenta = rs.getString("codcuenta");
                int largocuenta = codcuenta.length();
                String cuentafinal = Util.espacios_izquieda_letras((largocuenta + largocuenta - 1), codcuenta);
                fila[0] = cuentafinal;
                fila[1] = rs.getString("nombre");
                mostrar.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }

        tabla.setModel(mostrar);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(400);

        DBUtil.closeConn();

    }
}
