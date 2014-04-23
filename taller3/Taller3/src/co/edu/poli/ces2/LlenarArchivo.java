package co.edu.poli.ces2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author guillo
 */
public class LlenarArchivo {

    public void llenarArchivo(ObjetoSQL objeto, String archivo) {

        String[] archivoSalida;
        String nombreArchivo = "";

        String sentencia;

        try {
            if (!"2".equals(archivo)) {
                archivoSalida = archivo.split("\\.");
                nombreArchivo = archivoSalida[0] + ".out";
            } else {
                nombreArchivo = "salida.out";
            }
            
            FileWriter escritor = new FileWriter(nombreArchivo, true);
            BufferedWriter bufferEscritura = new BufferedWriter(escritor);

            /**
             * Creamos las 9 sentencias que nos pidieron en la tarea
             */
            for (short i = 1; i < 9; i++) {
                CrearSentencias crear = new CrearSentencias();
                sentencia = crear.crearSentencias(i, objeto);
                bufferEscritura.append(sentencia);
                bufferEscritura.append(System.getProperty("line.separator"));
            }

            System.out.println("Guardando sentencias de tabla " + objeto.getNombreTabla());
            bufferEscritura.close();
            escritor.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
