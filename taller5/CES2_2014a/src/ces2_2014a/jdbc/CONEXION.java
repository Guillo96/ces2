package ces2_2014a.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author thomas
 */
public class CONEXION {

    public static Connection getConexion(String url, String usuario, String clave, String driver) {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, clave);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }

    public static Connection getConexion() {
        String url = "jdbc:postgresql://10.126.13.4:5432/ces2";
        String usuario = "ces2";
        String clave = "ces2";
        String driver = "org.postgresql.Driver";
        return getConexion(url, usuario, clave, driver);
    }
}
