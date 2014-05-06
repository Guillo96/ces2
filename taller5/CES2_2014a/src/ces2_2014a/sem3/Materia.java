package ces2_2014a.sem3;

/**
 *
 * @author thomas
 */
public class Materia {
    private String Codigo;
    private String Nombre;

    public Materia() {
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String toString() {
        return Codigo + " " + Nombre;
    }
    
    
}
