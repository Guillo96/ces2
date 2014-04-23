package co.edu.poli.ces2.expresiones.taller2;

import co.edu.poli.ces2.expresiones.Operador;
/**
 *
 * @author guillo
 */
public class Division implements Operador{
    
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
    /**
     * 
     * @param d dividendo
     * @param d1 divisor
     * @return d divido d1
     * @throws Exception 
     */
    @Override
    public Double getValor(Double d, Double d1) throws Exception {
        try{
            return d / d1;
        }catch(Exception e){
            System.out.println(e);
            System.out.println("La aplicación generara un error en la salida"+
                    "por favor compruebe la información de entrada y vuelva a ejecutarlo");
        }
        return d / d1;
    }

    @Override
    public Double getValor(Double d) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isBinario() {
        return false;
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