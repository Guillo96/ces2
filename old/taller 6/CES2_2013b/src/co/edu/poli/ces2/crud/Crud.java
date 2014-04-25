package co.edu.poli.ces2.crud;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static sem8.SQL.getConexion;

/**
 *
 * @author thomas
 */
public class Crud {

    public int insertar() {
        Connection con = null;
        PreparedStatement cmd;
        String campos = "";
        String interroga = "";
        ArrayList valores = new ArrayList();
        Object valor;
        Columna col;
        for (Field atributo : this.getClass().getDeclaredFields()) {
            col = atributo.getAnnotation(Columna.class);
            if (col == null || col.AutoNumerico()) {
                continue;
            }
            campos += "," + atributo.getName();
            interroga += ",?";
            valor = null;
            try {
                atributo.setAccessible(true);
                valor = atributo.get(this);
            } catch (Exception ex) {
            }
            valores.add(valor);
        }
        campos = campos.substring(1);
        interroga = interroga.substring(1);
        String sql = "insert into  " + get_Tabla()
                + " (" + campos + ") "
                + " values (" + interroga + ")";
        int res = 0;
        try {
            con = getConexion();
            cmd = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < valores.size(); i++) {
                cmd.setObject(i + 1, valores.get(i));
            }
            res = cmd.executeUpdate();
            ResultSet rs = cmd.getGeneratedKeys();
            Integer auto;
            while (rs.next()) {
                auto = (int) rs.getLong(1);
                for (Field atributo : this.getClass().getDeclaredFields()) {
                    col = atributo.getAnnotation(Columna.class);
                    if (col.AutoNumerico()) {
                        atributo.setAccessible(true);
                        atributo.set(this, auto);
                    }
                }

            }
            cmd.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return res;
        }
    }

    public String get_Tabla() {
        return this.getClass().getSimpleName();
    }

    public List<String> get_Columnas() {
        ArrayList<String> columnas = new ArrayList<String>();
        Columna col;
        for (Field atributo : this.getClass().getDeclaredFields()) {
            col = atributo.getAnnotation(Columna.class);
            if (col == null) {
                continue;
            }
            columnas.add(atributo.getName());
        }
        return columnas;
    }

    public List<String> get_AutoNumericas() {
        ArrayList<String> columnas = new ArrayList<String>();
        Columna col;
        Field[] Campos = this.getClass().getDeclaredFields();
        Field atributo;
        for (int i = 0; i < Campos.length; i++) {
            atributo = Campos[i];
            col = atributo.getAnnotation(Columna.class);
            if (col == null || !col.AutoNumerico()) {
                continue;
            }
            columnas.add(atributo.getName());
        }
        return columnas;
    }

    public List<String> get_ClavesPrimarias() {
        ArrayList<String> columnas = new ArrayList<String>();
        Columna col;


        for (Field atributo : this.getClass().getDeclaredFields()) {
            col = atributo.getAnnotation(Columna.class);
            if (col
                    == null || !col.ClavePrimaria()) {
                continue;
            }
            columnas.add(atributo.getName());
        }
        return columnas;
    }

    public List get_Valores() {
        ArrayList valores = new ArrayList();
        for (Field atributo : this.getClass().getDeclaredFields()) {
            try {
                atributo.setAccessible(true);
                valores.add(atributo.get(this));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return valores;
    }

    public static List<String> get_DB_tablas() {
        ArrayList<String> tablas = new ArrayList<String>();
        try {
            Connection con = getConexion();
            ResultSet filas;
            filas = con.getMetaData().getTables("ces2", "public", null, new String[]{"TABLE"});
            while (filas.next()) {
                tablas.add(filas.getString("TABLE_NAME"));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return tablas;
        }
    }

    public static List<String> get_DB_Pks(String tabla) {
        ArrayList<String> tablas = new ArrayList<String>();
        try {
            Connection con = getConexion();
            ResultSet filas;
            filas = con.getMetaData().getPrimaryKeys("ces2", "public", tabla);
            while (filas.next()) {
                tablas.add(filas.getString("COLUMN_NAME"));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return tablas;
        }
    }

    public static List<String> get_DB_columnas(String tabla) {
        ArrayList<String> tablas = new ArrayList<String>();
        try {
            Connection con = getConexion();
            PreparedStatement cmd = con.prepareStatement("select * from " + tabla);
            ResultSetMetaData filas;
            filas = cmd.executeQuery().getMetaData();
            for (int i = 1; i <= filas.getColumnCount(); i++) {
                System.out.println("Nombre=" + filas.getColumnName(i));
                System.out.println("Clase=" + filas.getColumnClassName(i));
                System.out.println("AI=" + filas.isAutoIncrement(i));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return tablas;
        }
    }
}
