package org.example;

public class DescuentoTopePorcentaje implements Descuento{
    private String tipo = "%";
    private Double cantidad;
    private Double tope;
    public DescuentoTopePorcentaje(Double cantidad, Double tope){
        this.cantidad = cantidad;
        this.tope = tope;
    }

    @Override
    public Double calcularElDescuento(Double total) {
        cantidad = total * cantidad / 100;
         Double descuentoTope = total * tope / 100;

        if(cantidad > descuentoTope){
            return descuentoTope;
        }
        else{
            return cantidad;
        }
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

    public Double getTope() {
        return tope;
    }

    public void setTope(Double tope) {
        this.tope = tope;
    }
}
