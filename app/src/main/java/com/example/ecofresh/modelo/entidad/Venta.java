package com.example.ecofresh.modelo.entidad;

import com.example.ecofresh.VentaAguardar;

import java.util.HashMap;
import java.util.Map;

public class Venta {

    Map<String, Object> venta = new HashMap<>();

    public Venta(String cantidad, Producto producto, String emailUsuario) {
        venta.put("cantidad", cantidad);
        venta.put("producto", producto);
        venta.put("usuario", emailUsuario);
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

    public String getEmailUsuario() {
        return (String) venta.get("emailUsuario");
    }

    public void setEmailUsuario(String emailUsuario) {

        venta.put("usuario", emailUsuario);
    }
}
