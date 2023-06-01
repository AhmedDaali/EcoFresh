package com.example.ecofresh.modelo.entidad;

import java.util.HashMap;
import java.util.Map;

public class Compra {


    Map<String, Object> compra = new HashMap<>();

    public Compra(double cantidad, double total, Producto producto, String usuario, String vendedor, DireccionEnvio direccionEnvio ) {
        compra.put("cantidad", cantidad);
        compra.put("producto", producto);
        compra.put("usuario", usuario);
        compra.put("usuario", vendedor);
        compra.put("total", total);
        compra.put("direccion de envio", direccionEnvio);
    }
    public Compra() {
        // Constructor sin argumentos requerido por Firebase Firestore
    }

    public double getCantidad() {
        return (double) compra.get("cantidad");
    }

    public void setCantidad(double cantidad) {

        compra.put("cantidad", cantidad);
    }

    public Producto getProducto() {

        return (Producto)  compra.get("producto");
    }

    public void setProducto(Producto producto) {
        compra.put("producto", producto);
    }

    public String getEmailUsuario() {
        return (String) compra.get("usuario");
    }

    public void setEmailUsuario(String emailUsuario) {

        compra.put("usuario", emailUsuario);
    }
    public String getEmailVendedor() {
        return (String) compra.get("vendedor");
    }

    public void setEmailVendedor(String vendedor) {

        compra.put("usuario", vendedor);
    }

    public double getTotal() {
        return (double) compra.get("total");
    }

    public void setTotal(double total) {

        compra.put("total", total);
    }

}