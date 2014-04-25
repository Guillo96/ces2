package co.edu.poli.ces2.crud;

import java.sql.Timestamp;

/**
 *
 * @author thomas
 */
public class tbl_perfiles extends Crud {

    @Columna(AutoNumerico = true, ClavePrimaria = true)
    private Integer id_perfil;
    @Columna
    private String nombre;
    @Columna
    private String descripcion;
    @Columna
    private String mod_usuario;
    @Columna
    private Timestamp mod_fecha;

    public tbl_perfiles() {
    }

    
    public Integer getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(Integer id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMod_usuario() {
        return mod_usuario;
    }

    public void setMod_usuario(String mod_usuario) {
        this.mod_usuario = mod_usuario;
    }

    public Timestamp getMod_fecha() {
        return mod_fecha;
    }

    public void setMod_fecha(Timestamp mod_fecha) {
        this.mod_fecha = mod_fecha;
    }

}
