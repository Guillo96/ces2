package old;

/**
 *
 * @author guillo
 */
import java.io.FileNotFoundException;

public class LecturaArchivoObj {

    private static LlenarArchivo llenar;

    public void lectura(String ruta) throws FileNotFoundException {
        try {
            System.out.println("procesando " + ruta);

            ObjetoSQL objeto;
            objeto = new ObjetoSQL();

            TblUsuarios tbl;
            tbl = new TblUsuarios();

            tbl.setId_Usuario("pepe");
            tbl.setNombre("Pedro");
            tbl.setApellido("Lopez");
            tbl.setCorreo("alguien@si.com");
            tbl.setMod_Usuario("basico");

            String columnas, PK, AI, valores;
            columnas = valores = AI = PK = "";

            /*Nombre de la tabla*/
            objeto.setNombreTabla(tbl.get_Tabla());
            /*Columnas*/
            for (String x : tbl.get_Columnas()) {
                columnas = columnas + "," + x;
            }
            objeto.setColumnas(columnas);
            /*Clave Primaria*/
            objeto.setCantidadPK(tbl.get_ClavePrimarias().size());
            for (String x : tbl.get_ClavePrimarias()) {
                PK = PK + "," + x;
            }
            objeto.setPrimaryKey(PK);
            /*Columnas autoincrementables*/
            objeto.setCantidadColAutoInc(tbl.get_AutoNumericas().size());
            for (String x : tbl.get_AutoNumericas()) {
                AI = AI + "," + x;
            }
            objeto.setColAutoInc(AI);
            /*Valores y
             *Reinicia contador y llama a funcion que guarda el objeto en el archivo
             */
            for (Object x : tbl.get_Valores()){
                valores = valores + "," + x;
            }
            objeto.setValores(valores);

            llenar = new LlenarArchivo();
            llenar.llenarArchivo(objeto, ruta);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
