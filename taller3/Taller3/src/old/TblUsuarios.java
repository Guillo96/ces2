
package co.edu.poli.ces2;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guillo
 */
public class TblUsuarios {
    
    @Columna(clavePrimaria=true)
    private String Id_Usuario;
    @Columna
    private String Nombre;
    @Columna
    private String Apellido;
    @Columna
    private String Clave;
    @Columna
    private String Correo;
    @Columna
    private String Mod_Usuario;
    
    public String get_Tabla(){
        return this.getClass().getSimpleName();
    }

    public String getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(String Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
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

    public String getMod_Usuario() {
        return Mod_Usuario;
    }

    public void setMod_Usuario(String Mod_Usuario) {
        this.Mod_Usuario = Mod_Usuario;
    }
    
    
    public List<String> get_Columnas(){
        ArrayList<String> columnas = new ArrayList<String>();
        for (Field atributo : this.getClass().getDeclaredFields()){
            columnas.add(atributo.getName());
        }
        return columnas;
    }
    
    public List get_Valores(){
        ArrayList valores = new ArrayList();
        for (Field atributo: this.getClass().getDeclaredFields()){
            try{
                atributo.setAccessible(true);
                valores.add(atributo.get(this));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return valores;
    }
    
    public List<String> get_AutoNumericas(){
        ArrayList<String> columnas = new ArrayList<String>();
        Columna col;
        for (Field atributo : this.getClass().getDeclaredFields()){
            col = atributo.getAnnotation(Columna.class);
            if(col==null || !col.autoNumerico())continue;
            columnas.add(atributo.getName());
        }
        return columnas;
    }
    
    public List<String> get_ClavePrimarias(){
        ArrayList<String> columnas = new ArrayList<String>();
        Columna col;
        for (Field atributo : this.getClass().getDeclaredFields()){
            col = atributo.getAnnotation(Columna.class);
            if(col==null || !col.clavePrimaria())continue;
            columnas.add(atributo.getName());
        }
        return columnas;
    }
    
    
}

