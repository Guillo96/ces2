package co.edu.poli.ces2.expresiones.taller2;
/**
 *
 * @author guillo
 */
public class Ppal {
    private static LecturaArchivo ejecutar;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String archivo = null;
        /*String u = Double
        String x = Double.toString(5d);
        int dEntero = Integer.parseInt(x);
        String y = Double.toString(12d);
        int d1Entero = Integer.parseInt(y);
        Integer suma = dEntero + d1Entero;
        System.out.println('x'+Long.toBinaryString(Double.doubleToRawLongBits(5d)));*/
        
        try {
            archivo = args[0];
            System.out.println("importando.. " + archivo);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            ejecutar = new LecturaArchivo();
            ejecutar.lectura(archivo);
        } catch (Exception e){
            System.out.println(e);
        }

    }
}
