package ces2_2014a.sem3;

import java.util.ArrayList;

/**
 *
 * @author thomas
 */
public class Estudiante extends Persona {

    private ArrayList<Materia> Materias;

    public Estudiante() {
//        Materias = new ArrayList<>();
        Materias = new ArrayList<Materia>();
    }

    public void addMateria(Materia mat) {
        this.Materias.add(mat);
    }

    public void mostrarMaerias() {
        for (Materia m : Materias) {
            System.out.println(m);
        }
    }

    public ArrayList<Materia> getMaterias() {
        return Materias;
    }

    public void setMaterias(ArrayList<Materia> Materias) {
        this.Materias = Materias;
    }

}
