package Modelos;

public class FacturacionVo {

    private String cantidad, articulo, precio;
    private int subtotal;

    public FacturacionVo(String cantidad, String articulo, String precio, int subtotal) {
        this.cantidad = cantidad;
        this.articulo = articulo;
        this.precio = precio;
        this.subtotal = subtotal;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

}
