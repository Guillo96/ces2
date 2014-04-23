package co.edu.poli.ces2.expresiones.taller2;

import co.edu.poli.ces2.expresiones.Operador;
/**
 *
 * @author guillo
 */
public class Nmc implements Operador{

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
        int _parteEntera;
        int _parteDecimal;
        if(d < 1400){
            return 900d;
        }else{
            _parteEntera = (int) (d / 1000);
            _parteDecimal = (int) (d % 1000);
            d = _parteDecimal < 400 ? ((_parteEntera - 1d) * 1000d )+ 900d : (_parteEntera * 1000d) + 900d;
        }
        return d;
    }

    @Override
    public boolean isBinario() {
        return false;
    }
    /**
     * 
     * @return true
     * El 900 mas cercano si es menor que 900 retorna 900
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