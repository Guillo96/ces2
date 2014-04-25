package co.edu.poli.ces2.crud;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import static sem8.SQL.getConexion;

/**
 *
 * @author thomas
 */
public class tbl_usuarios {

    @Columna(ClavePrimaria = true)
    private String Id_usuario;
    @Columna
    private String Nombre;
    @Columna
    private String Apellido;
    @Columna
    private String Clave;
    @Columna
    private String Correo;
    @Columna
    private String Mod_usuario;
    @Columna
    private String Identificacion;
    @Columna
    private Timestamp mod_fecha;

    public String getId_usuario() {
        return Id_usuario;
    }

    public String getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(String Identificacion) {
        this.Identificacion = Identificacion;
    }

    public void setId_usuario(String Id_usuario) {
        this.Id_usuario = Id_usuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getMod_usuario() {
        return Mod_usuario;
    }

    public void setMod_usuario(String Mod_usuario) {
        this.Mod_usuario = Mod_usuario;
    }

    public Timestamp getMod_fecha() {
        return mod_fecha;
    }

    public void setMod_fecha(Timestamp mod_fecha) {
        this.mod_fecha = mod_fecha;
    }

    public int eliminar() {
        Connection con = null;
        PreparedStatement cmd;
        String sql = "delete from tbl_usuarios where id_usuario = ?";

        int res = 0;
        try {
            con = getConexion();
            cmd = con.prepareStatement(sql);
            cmd.setString(1, getId_usuario());
            res = cmd.executeUpdate();
            cmd.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return res;
        }
    }

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
            cmd = con.prepareStatement(sql);
            for (int i = 0; i < valores.size(); i++) {
                cmd.setObject(i + 1, valores.get(i));
            }
            res = cmd.executeUpdate();
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
            if (col == null || !col.ClavePrimaria()) {
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

    public static void main(String[] args) {
        get_DB_columnas("tbl_perfiles_usuarios");
        System.out.println("-----------");

        for (String tabla : get_DB_Pks("tbl_perfiles_usuarios")) {
            System.out.println(tabla);
        }
//        for (String tabla : get_DB_tablas()) {
//            System.out.println(tabla);
//            break;
//        }
    }
}
