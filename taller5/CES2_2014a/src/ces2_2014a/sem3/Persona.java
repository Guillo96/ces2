package ces2_2014a.sem3;

import java.util.Date;

/**
 *
 * @author thomas
 */
public class Persona {

    private Integer Cedula;
    private String Nombre;
    private String Apellido;
    private Date Nacimiento;
    private Double Peso;
    private Double Estatura;

    public final static int EDAD_MAX = 18;
    
    public Persona() {
    }

    public Integer getCedula() {
        return Cedula;
    }

    public void setCedula(Integer Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public Date getNacimiento() {
        return Nacimiento;
    }

    public void setNacimiento(Date Nacimiento) {
        this.Nacimiento = Nacimiento;
    }

    public Double getPeso() {
        return Peso;
    }

    public void setPeso(Double Peso) {
        this.Peso = Peso;
    }

    public Double getEstatura() {
        return Estatura;
    }

    public void setEstatura(Double Estatura) {
        this.Estatura = Estatura;
    }
    
    
    
    
}
