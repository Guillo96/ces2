package co.edu.poli.ces2;
/**
 *
 * @author guillo
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LecturaArchivo {
    
    private static LlenarArchivo llenar;
    
    public void lectura(String ruta) throws FileNotFoundException{
        try{
            System.out.println("procesando " + ruta);
            String linea;
            Integer contador;
            FileReader lector = new FileReader(ruta);
            BufferedReader lectorBuffer = new BufferedReader(lector);
            contador = 0;

            ObjetoSQL objeto;
            objeto = new ObjetoSQL();
            
            while ((linea = lectorBuffer.readLine()) != null){
             
                /*Numero de expresiones*/
                if (contador == 0){
                    objeto.setNumeroExpresiones(linea);
                /*Columnas*/
                }else if (contador == 1){
                    objeto.setSimbolos(linea);
                /*Clave Primaria*/
                }else if (contador == 2){
                    String [] columna = linea.split("\\s", 2);
                    objeto.setCantidadPK(Integer.parseInt(columna[0]));
                    if (columna.length > 1){
                        objeto.setPrimaryKey(columna[1]);
                    }else{
                        objeto.setPrimaryKey("");
                    }
                /*Columnas autoincrementables*/
                }else if (contador == 3){
                    String [] columna = linea.split("\\s", 2);
                    objeto.setCantidadColAutoInc(Integer.parseInt(columna[0]));
                    if (columna.length > 1){
                        objeto.setColAutoInc(columna[1]);
                    }else{
                        objeto.setColAutoInc("");
                    }
                /*Valores y
                 *Reinicia contador y llama a funcion que guarda el objeto en el archivo
                 */
                }else if (contador == 4){
                    objeto.setValores(linea);
                    contador = -1;
                    llenar = new LlenarArchivo();
                    llenar.llenarArchivo(objeto, ruta);
                    //objeto = null;
                    objeto = new ObjetoSQL();
                }                
                contador ++;
            }
            lectorBuffer.close();
        }catch (IOException | NumberFormatException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}