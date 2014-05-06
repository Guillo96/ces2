/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ces2_2014a.sem3;

/**
 *
 * @author thomas
 */
public class Ppal {

    public static void main(String[] args) {
        
        Persona p = new Estudiante();
        p.setNombre("Camilo");
        p.setApellido("Guererro");
        
        Estudiante est = (Estudiante) p;
        
        Materia mate;
        mate = new Materia();
        mate.setCodigo(est.getNombre().length()>5?"M01":"M05");
        mate.setNombre("CES2");
        est.addMateria(mate);
        mate = new Materia();
        mate.setCodigo("M02");
        mate.setNombre("Sistemico 2");
        est.addMateria(mate);
        est.mostrarMaerias();
        
    }
    
    
    public static double calcular(String exp) {
        return 2;
    }















//    public static void main(String[] args) {
//        final Integer x = 9;
//
//        
//        final Persona p1 = new Persona();
//        p1.setNombre("Juan");
//        p1.setApellido("Lopez");
//
//        Persona p2 = new Persona();
//
//        p2.setNombre("Camilo");
//        p2.setApellido("Ramirez");
//
//        System.out.println(p1.getNombre() + " edad Max " + p1.EDAD_MAX);
//        System.out.println(p2.getNombre() + " edad Max " + p2.EDAD_MAX);
//
//    }
}
