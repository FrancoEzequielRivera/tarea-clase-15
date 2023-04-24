package org.example;

public class DescuentoFijo implements Descuento {
    private String tipo = "fijo";
    private Double cantidad;


    public DescuentoFijo(Double valorFijo){
        this.cantidad = valorFijo;
    }

    @Override
    public Double calcularElDescuento(Double total) {
        return cantidad - total;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
}
