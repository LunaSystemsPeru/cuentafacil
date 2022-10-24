/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.io.InputStream;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DBUtil {

    private static DataSource ds;
    private static Connection conn;

    static {
        try {
            Properties properties = new Properties();
           // System.out.println(DBUtil.class);
            InputStream inStream = DBUtil.class.getResourceAsStream("/properties/mysql.properties");
            properties.load(inStream);
            ds = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtener objeto de conexión de base de datos
     *
     * @return objeto de conexión de base de datos
     * @throws SQLException
     */
    public static Connection getConn() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = ds.getConnection();
        }
        return conn;
    }

    /**
     * Conexión de base de datos cerrada
     */
    public static void closeConn() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
    }
}
