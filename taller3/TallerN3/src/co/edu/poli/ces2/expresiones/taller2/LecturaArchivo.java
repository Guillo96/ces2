package co.edu.poli.ces2.expresiones.taller2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LecturaArchivo {

    public String lectura(String ruta) throws FileNotFoundException{
        try{
            String linea;
            Integer contador, numExpresiones, numSimbolos;
            HashMap variable;
            FileReader lector = new FileReader(ruta);
            BufferedReader lectorBuffer = new BufferedReader(lector);
            contador = numExpresiones = numSimbolos = 0;
            while ((linea = lectorBuffer.readLine()) != null){
                
                /*Numero de expresiones*/
                if (contador == 0){
                    numExpresiones = Integer.parseInt(linea);
                
                /*Numero de variables y simbolos*/
                }else if (contador == 1){
                    numSimbolos = Integer.parseInt(linea);
                
                /*Clase y variables*/
                }else if (contador > 1 && contador <= numSimbolos + 1){
                    String [] columna = linea.split("\\s");
                    String j = null;
                    variable = new HashMap();
                    for (int i=0; i<columna.length; i++){
                        /*Valor Variable*/
                        if (columna.length < 3){
                            if (i == 0){
                                j = columna[i];
                            }else{
                                variable.put(j, columna[i]);
                            }
                        //System.out.println((variable.get(j)));
                        /*Clase y precedencia*/
                        }else{
                            
                        }
                        //System.out.print("__" + columna[i]);
                    }System.out.println();                    
                
                /*Expresiones a evaluar*/
                }else if (contador > numSimbolos + 1){//&& contador <= numExpresiones + numSimbolos + 1
                    //System.out.println(linea);
                }
                contador ++;
            }
            lectorBuffer.close();
        }catch (IOException | NumberFormatException e){
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}