
package co.edu.poli.ces2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author guillo
 */
public class ObjetoSQL {
    
    String tabla;
    List<String> columnas;
    Integer cantidadPK;
    List<String> primaryKey;
    Integer cantidadColAutoInc;
    List<String> colAutoInc;
    List<String> valores;

    

    public String getNombreTabla() {
        return tabla;
    }

    public void setNombreTabla(String string) {
        tabla = string;
    }
    
    public List<String> getColumnas() {
        return columnas;
    }

    public void setColumnas(String string) {
        try{
            String[] columna = string.split("\\s+");
            columnas = Arrays.asList(columna);
        }catch(Exception e){
            System.out.println("error cols " + e);
        }
    }
    
    public int getCantidadPK(){
        return cantidadPK;
    }

    public void setCantidadPK(Integer cantidad){
        cantidadPK = cantidad;
    }
    
    public List<String> getPrimaryKey(){
        return primaryKey;
    }

    public void setPrimaryKey(String string) {
        try{
            String[] columna = string.split("\\s+");
            primaryKey = Arrays.asList(columna);
        }catch(Exception e){
            System.out.println(" error PK " + e);
        }
    }

    public int getCantidadColAutoInc(){
        return cantidadColAutoInc;
    }

    public void setCantidadColAutoInc(Integer cantidad){
        cantidadColAutoInc = cantidad;
    }
    
    public List<String> getColAutoInc(){
        return colAutoInc;
    }

    public void setColAutoInc(String string) {
        try{
            String [] columna = string.split("\\s+");
            colAutoInc = Arrays.asList(columna);
        }catch(Exception e){
            System.out.println("error colsinc " + e);
        }
    }

    public List<String> getValores() {
        return valores;
    }

    public void setValores(String string) {
        String [] columna = string.split(",");
        valores = Arrays.asList(columna);
    }
    

}
