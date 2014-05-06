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
public class Multiplicacion implements Operador {

    @Override
    public double Calculo(Double Operando) {
        return Operando;
    }

    @Override
    public double Calculo(Double Operando1, Double Operando2) {
        return Operando1 * Operando2;
    }

    @Override
    public int Prioridad() {
        return 2;
    }

    @Override
    public String Simbolo() {
        return "*";
    }

    @Override
    public boolean Binario() {
        return true;
    }

    @Override
    public boolean Unario() {
        return false;
    }
}
