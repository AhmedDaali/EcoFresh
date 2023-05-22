package com.example.ecofresh.modelo.entidad;

import java.util.List;

public class Producto {

    private String nombre = "";
    private String precio = "";
    private String categoria = "";
    //private List<byte[]> photos;

    public Producto(String nombre, String precio, String categoria/*, List<byte[]> photos*/) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        //this.photos = photos;
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

    /*public List<byte[]> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photo) {
        this.photos = photos;
    }*/
}
