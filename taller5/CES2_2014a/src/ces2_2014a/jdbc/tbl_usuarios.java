package ces2_2014a.jdbc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thomas
 */
public class tbl_usuarios {

    @Columna(PK = true, AI = true)
    private Integer Id_usuario;
    @Columna
    private Integer Identificacion;
    @Columna
    private String Nombre;
    @Columna
    private String Apellido;
    @Columna
    private String Usuario;
    @Columna
    private String Clave;
    @Columna
    private java.sql.Date Nacimiento;
    @Columna
    private Double Estatura;

    public tbl_usuarios() {
    }

    public Integer getId_usuario() {
        return Id_usuario;
    }

    public void setId_usuario(Integer Id_usuario) {
        this.Id_usuario = Id_usuario;
    }

    public Integer getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(Integer Identificacion) {
        this.Identificacion = Identificacion;
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

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public Date getNacimiento() {
        return Nacimiento;
    }

    public void setNacimiento(Date Nacimiento) {
        this.Nacimiento = Nacimiento;
    }

    public Double getEstatura() {
        return Estatura;
    }

    public void setEstatura(Double Estatura) {
        this.Estatura = Estatura;
    }

    public int eliminar() {
        String sql = "delete from " + get_Tabla();
        String condiciones = "";
        ArrayList valores = new ArrayList();
        Columna col;
        for (Field attr : this.getClass().getDeclaredFields()) {
            col = attr.getAnnotation(Columna.class);
            if (col == null || !col.PK()) {
                continue;
            }
            condiciones += "and " + attr.getName() + "= ? ";
            try {
                valores.add(attr.get(this));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        sql = sql + (condiciones.isEmpty() ? "" : " where " + condiciones.substring(4));
        return ejecutar(sql, valores.toArray());
    }

    private int ejecutar(String sql, Object... valores) {
        int res = 0;
        Connection con;
        PreparedStatement cmd;
        try {
            con = CONEXION.getConexion();
            cmd = con.prepareStatement(sql);
            for (int i = 0; i < valores.length; i++) {
                cmd.setObject(i + 1, valores[i]);
            }
            res = cmd.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public int insertar() {
        return ejecutar("INSERT INTO tbl_usuarios (identificacion, nombre, apellido, usuario, clave, nacimiento, estatura) \n"
                + " VALUES ( ?, ?, ?, ?, ?, ?,?) ", this.getIdentificacion(), this.getNombre(), this.getApellido(), this.getUsuario(), this.getClave(), this.getNacimiento(), this.getEstatura());
//                + " VALUES (" + this.getIdentificacion() + ", '" + getNombre() + "', '" + getApellido() + "', 'dthomas', 'dthomas1234', '1994-04-04', 1.73)");
    }

    public static void main(String[] args) {
        tbl_usuarios usuario = new tbl_usuarios();
        usuario.setId_usuario(35);
        System.out.println("Registros eliminados "+usuario.eliminar());
        
        
//        usuario.setNombre("Juan");
//        usuario.setApellido("Perez");
//        System.out.println("Nombre tabla = " + usuario.get_Tabla());
//        System.out.println("---Campos---");
//        for (String camp : usuario.get_Campos()) {
//            System.out.println(camp);
//        }
//        System.out.println("---Valores----");
//        for (Object val : usuario.get_Valores()) {
//            System.out.println(val);
//        }
//        System.out.println("---PKs----");
//        for (Object val : usuario.get_PKs()) {
//            System.out.println(val);
//        }
    }

    public String get_Tabla() {
        return this.getClass().getSimpleName();
    }

    public String[] get_Campos() {
        Field[] atributos = this.getClass().getDeclaredFields();
        ArrayList<String> Campos = new ArrayList<String>();
        Columna col;
        for (int i = 0; i < atributos.length; i++) {
            col = atributos[i].getAnnotation(Columna.class);
            if (col == null) {
                continue;
            }
            Campos.add(atributos[i].getName());
        }
        return Campos.toArray(new String[]{});
    }

    public String[] get_PKs() {
        Field[] atributos = this.getClass().getDeclaredFields();
        ArrayList<String> Campos = new ArrayList<String>();
        Columna col;
        for (int i = 0; i < atributos.length; i++) {
            col = atributos[i].getAnnotation(Columna.class);
            if (col == null || !col.PK()) {
                continue;
            }
            Campos.add(atributos[i].getName());
        }
        return Campos.toArray(new String[]{});
    }

    public Object[] get_Valores() {
        Field[] atributos = this.getClass().getDeclaredFields();
        Object[] Valores = new Object[atributos.length];
        for (int i = 0; i < Valores.length; i++) {
            try {
                Valores[i] = atributos[i].get(this);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return Valores;
    }

}
