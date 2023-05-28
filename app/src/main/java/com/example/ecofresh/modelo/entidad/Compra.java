package com.example.ecofresh.modelo.entidad;

import java.util.HashMap;
import java.util.Map;

public class Compra {


    Map<String, Object> compra = new HashMap<>();

    public Compra(String cantidad, Producto producto, String usuario, String vendedor) {
        compra.put("cantidad", cantidad);
        compra.put("producto", producto);
        compra.put("usuario", usuario);
        compra.put("usuario", vendedor);
    }
    public Compra() {
        // Constructor sin argumentos requerido por Firebase Firestore
    }

    public String getCantidad() {
        return (String) compra.get("cantidad");
    }

    public void setCantidad(String cantidad) {

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
        return (String) compra.get("Vendedor");
    }

    public void setEmailVendedor(String vendedor) {

        compra.put("usuario", vendedor);
    }

}