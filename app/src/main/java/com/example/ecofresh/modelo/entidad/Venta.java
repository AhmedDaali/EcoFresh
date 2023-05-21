package com.example.ecofresh.modelo.entidad;

public class Venta {

    private float cantidad = 0;
    private Producto Producto =null;
    private Usuario usuario =  null;

    public Venta(float cantidad, com.example.ecofresh.modelo.entidad.Producto producto, Usuario usuario) {
        this.cantidad = cantidad;
        Producto = producto;
        this.usuario = usuario;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public com.example.ecofresh.modelo.entidad.Producto getProducto() {
        return Producto;
    }

    public void setProducto(com.example.ecofresh.modelo.entidad.Producto producto) {
        Producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
