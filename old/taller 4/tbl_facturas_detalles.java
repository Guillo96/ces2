package co.edu.poli.ces2.taller4;

public class tbl_facturas_detalles{

    @Columna(ClavePrimaria = true)
    private Integer Id_factura;
    @Columna(ClavePrimaria = true)
    private Integer Item;
    @Columna
    private Integer Id_producto;
    @Columna
    private Double Cantidad;
    @Columna
    private Double Costo_unitario;
    @Columna
    private String Observaciones;
	
    public tbl_facturas_detalles(){

    }

    public Double getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Double Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Double getCosto_unitario() {
        return Costo_unitario;
    }

    public void setCosto_unitario(Double Costo_unitario) {
        this.Costo_unitario = Costo_unitario;
    }

    public Integer getId_factura() {
        return Id_factura;
    }

    public void setId_factura(Integer Id_factura) {
        this.Id_factura = Id_factura;
    }

    public Integer getId_producto() {
        return Id_producto;
    }

    public void setId_producto(Integer Id_producto) {
        this.Id_producto = Id_producto;
    }

    public Integer getItem() {
        return Item;
    }

    public void setItem(Integer Item) {
        this.Item = Item;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }
}
