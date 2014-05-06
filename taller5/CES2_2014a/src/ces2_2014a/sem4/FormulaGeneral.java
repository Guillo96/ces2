/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ces2_2014a.sem4;

/**
 *
 * @author thomas
 */
public class FormulaGeneral extends Ecuacion2grado{

    @Override
    public Double resolver() {
        return (-getB()+Math.sqrt(getB()*getB() 
                - 4*getA()*getC() ))/2*getA();
    }
    
}
