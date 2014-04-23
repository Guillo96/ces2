package co.edu.poli.ces2.expresiones.taller2;

import co.edu.poli.ces2.expresiones.Operador;

/**
 *
 * @author guillo
 */
public class SumaPoli implements Operador{
    
    private int _precedencia;
    private String _simbolo;
    
    
    @Override
    public String getSimbolo() {
        return this._simbolo;
    }

    @Override
    public void setSimbolo(String string) {
        _simbolo = string;
    }

    @Override
    public Double getValor(Double d, Double d1) throws Exception {
        //int dEntero = d.intValue();
        //int d1Entero = d1.intValue();
        int dEntero = Integer.parseInt(String.valueOf(d),2);
        int d1Entero = Integer.parseInt(String.valueOf(d1),2);
        Integer suma = dEntero + d1Entero;
        //String resultado = Integer.toBinaryString(suma);
        //String x;
        //x = java.lang.Integer.toBinaryString(d.intValue());
        double sum = suma.doubleValue();
        return sum;
    }

    @Override
    public Double getValor(Double d) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isBinario() {
        return true;
    }

    @Override
    public boolean isUnario() {
        return false;
    }

    @Override
    public int getPrecedencia() {
        return this._precedencia;
    }

    @Override
    public void setPrecedencia(int i) {
        _precedencia = i;
    }
    
}