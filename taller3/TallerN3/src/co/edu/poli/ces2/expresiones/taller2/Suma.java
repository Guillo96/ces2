package co.edu.poli.ces2.expresiones.taller2;

import co.edu.poli.ces2.expresiones.Operador;

/**
 *
 * @author guillo
 */
public class Suma implements Operador{

    private String _simbolo;
    private Double valor;
    private int _precedencia;
    
    
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
        return d + d1;
    }

    @Override
    public Double getValor(Double d) throws Exception {
        return d;
    }

    @Override
    public boolean isBinario() {
        return false;
    }
    /**
     * 
     * @return true
     * Si unario retorna mismo valor
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
