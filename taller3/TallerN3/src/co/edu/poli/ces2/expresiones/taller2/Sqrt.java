package co.edu.poli.ces2.expresiones.taller2;

import co.edu.poli.ces2.expresiones.Operador;
/**
 *
 * @author guillo
 */
public class Sqrt implements Operador{
    
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Double getValor(Double d) throws Exception {
        return Math.sqrt(d);
    }

    @Override
    public boolean isBinario() {
        return false;
    }
    /**
     * 
     * @return true
     * Retorna raiz cuadrada
     */
    @Override
    public boolean isUnario() {
        return true;
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