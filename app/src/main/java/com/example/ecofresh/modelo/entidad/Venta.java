package com.example.ecofresh.modelo.entidad;

import com.example.ecofresh.VentaAguardar;

import java.util.HashMap;
import java.util.Map;

public class Venta {

    Map<String, Object> venta = new HashMap<>();

    public Venta(String cantidad, Producto producto, String email) {
        venta.put("cantidad", cantidad);
        venta.put("producto", producto);
        venta.put("email", email);
    }
    public Venta() {
        // Constructor sin argumentos requerido por Firebase Firestore
    }

    public String getCantidad() {
        return (String) venta.get("cantidad");
    }

    public void setCantidad(String cantidad) {

        venta.put("cantidad", cantidad);
    }

    public Producto getProducto() {

        return (Producto)  venta.get("producto");
    }

    public void setProducto(Producto producto) {
        venta.put("producto", producto);
    }

    public String getEmail() {
        return (String) venta.get("email");
    }

    public void setEmail(String email) {

        venta.put("email", email);
    }
}
