package org.example;

public class Oferta {
    private Producto producto;
    private Descuento descuento;
    private String fechaDesde;
    private String fechaHasta;
    public Oferta(Producto producto, Descuento descuento, String fechaDesde, String fechaHasta) {
        this.producto = producto;
        this.descuento = descuento;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }

    public String getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }
}
