package com.example.ecofresh.modelo.entidad;

import com.example.ecofresh.VentaAguardar;

import java.util.HashMap;
import java.util.Map;

public class Venta {

    Map<String, Object> venta = new HashMap<>();

    public Venta(float cantidad, Producto producto, String email, String vendedor) {
        venta.put("cantidad", cantidad);
        venta.put("producto", producto);
        venta.put("email", email);
        venta.put("vendedor", vendedor);
    }
    public Venta() {
        // Constructor sin argumentos requerido por Firebase Firestore
    }

    public float getCantidad() {
        return (float) venta.get("cantidad");
    }

    public void setCantidad(float cantidad) {

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

    public String getVendedor() {
        return (String) venta.get("vendedor");
    }

    public void setVendedor(String vendedor) {

        venta.put("vendedor", vendedor);
    }
}
