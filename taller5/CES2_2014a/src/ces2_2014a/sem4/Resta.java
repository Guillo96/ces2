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
public class Resta implements Operador{
    @Override
    public double Calculo(Double Operando) {
        return Operando*-1;
    }
    @Override
    public double Calculo(Double Operando1, Double Operando2) {
        return Operando1 - Operando2;
    }
    @Override
    public int Prioridad() {
        return 1;
    }
    @Override
    public String Simbolo() {
        return "-";
    }
    @Override
    public boolean Binario() {
        return true;
    }
    @Override
    public boolean Unario() {
        return true;
    }
}
