package co.edu.poli.ces2.crud;

import java.sql.Timestamp;

/**
 *
 * @author thomas
 */
public class tbl_usuarios extends Crud{

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

    public tbl_usuarios() {
    }

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

}
