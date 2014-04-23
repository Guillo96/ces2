
package co.edu.poli.ces2;

//import java.lang.reflect.Method;
import java.util.List;

/**
 *
 * @author guillo
 */
public class CrearSentencias {
    
    /**
     * Objeto publico para que se pueda llamar de todas las funciones sin necesidad de pasarlo a cada una
     */
    private static ObjetoSQL objetoX;

    
    public String crearSentencias(short sentencia, ObjetoSQL objeto){
        
        CrearSentencias.objetoX = objeto;
        /**
         * String clase;
         * clase = "sentencia" + sentencia;
         * Object objetos;
         * Method metodo = objetos.getClass().getMethod(clase, null);
         * 
        */
        String cadena;
        cadena = "";
        switch(sentencia){
            case 1:
                cadena = insertar();
                break;
            case 2:
                cadena = valoresInsertar();
                break;
            case 3:
                cadena = seleccionar();
                break;
            case 4:
                cadena = valoresSeleccionar();
                break;
            case 5:
                cadena = actualizar();
                break;
            case 6:
                cadena = valoresActualizar();
                break;
            case 7:
                cadena = eliminar();
                break;
            case 8:
                cadena = valoresEliminar();
                break;
            default:
                break;
        }
        return cadena;
    }
    
    private String insertar(){
        String sentencia, columnas, valores;
        columnas = concatenar(objetoX.getColumnas(), ",", "", false);
        valores = concatenar(objetoX.getValores(), ",", false);
        sentencia = "INSERT INTO " + objetoX.getNombreTabla() + " (";
        sentencia = sentencia + columnas + ") VALUES (" + valores + ")";
        return sentencia;
    }
    
    private String valoresInsertar(){
        String sentencia;
        sentencia = concatenar(objetoX.getValores(), ",", "", false);
        return sentencia;
    }
    
    private String seleccionar(){
        String sentencia, columnas, valores;
        columnas = concatenar(objetoX.getColumnas(), ",", "", true);
        valores = concatenar(objetoX.getColumnas(), "= ? AND ", "=?", true);
        sentencia = "SELECT " + columnas + " FROM " + objetoX.getNombreTabla() + " WHERE " + valores;
        return sentencia;
    }
    
    private String valoresSeleccionar(){
        String sentencia;
        sentencia = concatenar(objetoX.getValores(), ",", "", true);
        return sentencia;
    }
    
    private String actualizar(){
        String sentencia, columnas, valores;
        columnas = concatenar(objetoX.getColumnas(), "= ?,", "= ?", false);
        valores = concatenar(objetoX.getPrimaryKey(), "= ? AND ", " = ?", true);
        sentencia = "UPDATE " + objetoX.getNombreTabla() + " SET " + columnas + " WHERE " + valores;
        return sentencia;
    }
    
    private String valoresActualizar(){
        String sentencia, PK;
        PK = concatenar(objetoX.getValores(), true, ",", "");
        sentencia = concatenar(objetoX.getValores(), ",", "", false);
        sentencia = sentencia + "," + PK;
        return sentencia;
    }
    
    private String eliminar(){
        String sentencia, valores;
        valores = concatenar(objetoX.getPrimaryKey(), "= ? AND ", "= ?", true);
        sentencia = "DELETE FROM " + objetoX.getNombreTabla() + " WHERE " + valores;
        return sentencia;
    }
    
    private String valoresEliminar(){
        String sentencia;
        sentencia = concatenar(objetoX.getValores(), true, ",", "");
        return sentencia;
    }
    
    /**
     * cadena con las columnas armadas con para el string de SQL
     * recibe el separador como string
     * recibe cantidad de PK para no concatenar
     * recibe lista con objetos a concatenar
     * @return 
     */
    private String concatenar(List<String> lista, String separador, boolean PK){
        String cadena, string;
        int y, cantidadPK;
        cadena = "?";
        string = "";
        if(PK){
            cantidadPK = 0;
        }else{
            cantidadPK = objetoX.getCantidadPK();
        }
        y = lista.size();
        for (int i=0; i<y-cantidadPK; i++){
            if(i == 0){
                string = string + cadena;
            }else{
                string = string + separador + cadena;
            }
        }
        return string;
    }
    
    
    /**
     * cadena con las columnas armadas con para el string de SQL
     * recibe el separador inicial y final como string
     * recibe PK como true para concatenar Primary keys
     * recibe lista con objetos a concatenar
     * @return 
     */
    private String concatenar(List<String> lista, String separadorI, String separadorF, boolean PK){
        String cadena;
        int cantidadPK;
        int cont = 0;
        cadena = "";        
        if(PK){
            cantidadPK = 0;
        }else{
            cantidadPK = objetoX.getCantidadPK();
        }
        if (lista.size() < 2){
           for (String x : lista){
                switch (separadorI) {
                    case ",":
                        cadena = x;
                        break;
                    case "= ? AND":
                        cadena = x + separadorF;
                        break;
                    case "= ? AND ":
                        cadena = x + separadorF;
                        break;
                    default:
                        cadena = x + separadorI;
                        break;
                }
            } 
        }else{
            for (String x : lista){
                if (cont >= cantidadPK){
                    if (cont == lista.size() - 1){
                        cadena = cadena + x+ separadorF;
                    }else{
                        cadena = cadena + x + separadorI;
                    }
                }
                cont += 1;
            }
        }
        return cadena;
    }
    
    /**
     * cadena con las columnas armadas con para el string de SQL
     * recibe el separador inicial y final como string
     * recibe PK como true para concatenar Primary keys
     * recibe lista con objetos a concatenar
     * @return 
     */
    private String concatenar(List<String> lista, boolean PK, String separadorI, String separadorF){
        String cadena;
        int cantidadPK;
        int cont = 0;
        cadena = "";        
        if(PK){
            cantidadPK = 0;
        }else{
            cantidadPK = objetoX.getCantidadPK();
        }
        if (cantidadPK < 2) {
           for (String x : lista){
                switch (separadorI) {
                    case ",":
                        cadena = x;
                        break;
                    case "= ? AND":
                        cadena = x + separadorF;
                        break;
                    case "= ? AND ":
                        cadena = x + separadorF;
                        break;
                    default:
                        cadena = x + separadorI;
                        break;
                }
                break;
            } 
        }else{
            for (String x : lista){
                if (cont < cantidadPK){
                    if (cont == cantidadPK - 1){
                        cadena = cadena + x+ separadorF;
                    }else{
                        cadena = cadena + x + separadorI;
                    }
                }
                cont += 1;
            }
        }
        return cadena;
    }
}
