package com.example.ecofresh.modelo.entidad;

import java.util.List;

public class Producto {

    private String nombre = "";
    private String precio = "";
    private String categoria = "";

    private String localidad= "";

    private String photoUrls;


    public Producto(String nombre, String precio, String categoria, String localidad, String photoUrls) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.localidad = localidad;
        this.photoUrls = photoUrls;
    }
    public Producto() {
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {

        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {

        this.categoria = categoria;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(String photoUrls) {
        this.photoUrls = photoUrls;
    }


}
