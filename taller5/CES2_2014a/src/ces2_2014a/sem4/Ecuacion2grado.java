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
public abstract  class Ecuacion2grado {
    private Double A;
    private Double B;
    private Double C;

    public Ecuacion2grado() {
    }
    
    public abstract Double resolver();
        

    public Double getA() {
        return A;
    }

    public void setA(Double A) {
        this.A = A;
    }

    public Double getB() {
        return B;
    }

    public void setB(Double B) {
        this.B = B;
    }

    public Double getC() {
        return C;
    }

    public void setC(Double C) {
        this.C = C;
    }
    
}
