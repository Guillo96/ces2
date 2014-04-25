package co.edu.poli.ces2.taller4;

import java.sql.Timestamp;

public class tbl_facturas{

    @Columna(ClavePrimaria = true, AutoNumerico = true)
    private Integer Id_factura;
    @Columna
    private Integer id_cliente; 
    @Columna
    private Timestamp Fecha; 
    @Columna
    private String Observaciones;

    public tbl_facturas() {
        
    }

    public Timestamp getFecha() {
        return Fecha;
    }

    public void setFecha(Timestamp Fecha) {
        this.Fecha = Fecha;
    }

    public Integer getId_factura() {
        return Id_factura;
    }

    public void setId_factura(Integer Id_factura) {
        this.Id_factura = Id_factura;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }
}
