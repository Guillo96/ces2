package ces2_2014a.sem4;

/**
 *
 * @author thomas
 */
public class Ppal {

    public static void main(String[] args) {
        try {
            Operador op;
            Double respuesta;
            op = (Operador) Class.forName("ces2_2014a.sem4.Multiplicacion").newInstance();
            respuesta = op.Calculo(7d, 4d);
            System.out.println("La respuesta es " + respuesta);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
