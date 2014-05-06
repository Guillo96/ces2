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
public interface Operador {
    public double Calculo(Double Operando);
    public double Calculo (Double Operando1,Double Operando2);
    public int Prioridad();
    public String Simbolo();
    public boolean Binario();
    public boolean Unario();
}
