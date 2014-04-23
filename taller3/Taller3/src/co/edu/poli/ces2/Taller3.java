package co.edu.poli.ces2;
/**
 *
 * @author guillo
 */
public class Taller3 {
    private static LecturaArchivo ejecutar;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String archivo = null;
        try {
            //BufferedReader parametro = new BufferedReader(new InputStreamReader(System.in));
            //archivo = parametro.readLine();
            archivo = args[0];
            System.out.println("Importando " + archivo);
            ejecutar = new LecturaArchivo();
            ejecutar.lectura(archivo);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
