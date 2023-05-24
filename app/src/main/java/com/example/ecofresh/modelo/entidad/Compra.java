package com.example.ecofresh.modelo.entidad;

import java.util.HashMap;
import java.util.Map;

public class Compra {


    Map<String, Object> compra = new HashMap<>();

    public Compra(String cantidad, Producto producto, String emailUsuario, String emailVendedor) {
        compra.put("cantidad", cantidad);
        compra.put("producto", producto);
        compra.put("usuario", emailUsuario);
        compra.put("usuario", emailVendedor);
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
        return (String) compra.get("emailUsuario");
    }

    public void setEmailUsuario(String emailUsuario) {

        compra.put("usuario", emailUsuario);
    }
    public String getEmailVendedor() {
        return (String) compra.get("emailVendedor");
    }

    public void setEmailVendedor(String emailVendedor) {

        compra.put("usuario", emailVendedor);
    }

}