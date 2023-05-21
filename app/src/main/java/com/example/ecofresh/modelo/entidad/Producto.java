package com.example.ecofresh.modelo.entidad;

import android.graphics.Bitmap;

public class Producto {

    private String nombre = "";
    private float precio = 0;
    private String categoria = "";
    private Bitmap photo;

    public Producto(String nombre, float precio, String categoria, Bitmap photo) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.photo = photo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }
}
