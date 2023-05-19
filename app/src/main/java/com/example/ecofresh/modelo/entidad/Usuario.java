package com.example.ecofresh.modelo.entidad;

import com.example.ecofresh.Venta;
import com.example.ecofresh.modelo.entidad.Compra;

import java.util.HashMap;

public class Usuario {

    private HashMap<String, Object> usuarioData = new HashMap<>();

    public Usuario(String nombre, String apellidos, String email, String direccion,
                   String localidad, String telefono, Venta venta, Compra compra) {

        usuarioData.put("nombre", nombre);
        usuarioData.put("apellidos", apellidos);
        usuarioData.put("email", email);
        usuarioData.put("direccion", direccion);
        usuarioData.put("localidad", localidad);
        usuarioData.put("telefono", telefono);
        usuarioData.put("venta", venta);
        usuarioData.put("compra", compra);
    }

    public Usuario() {

    }

    public Usuario(String nombre, String apellidos, String email, String direccion, String localidad, String telefono) {
        usuarioData.put("nombre", nombre);
        usuarioData.put("apellidos", apellidos);
        usuarioData.put("email", email);
        usuarioData.put("direccion", direccion);
        usuarioData.put("localidad", localidad);
        usuarioData.put("telefono", telefono);
    }

    public Usuario(String nombre, String apellidos, String email) {
        usuarioData.put("nombre", nombre);
        usuarioData.put("apellidos", apellidos);
        usuarioData.put("email", email);
    }


    public HashMap<String, Object> getUsuarioData() {
        return usuarioData;
    }

    public void setUsuarioData(HashMap<String, Object> usuarioData) {
        this.usuarioData = usuarioData;
    }

    public String getNombre() {
        return (String) usuarioData.get("nombre");
    }

    public void setNombre(String nombre) {
        usuarioData.put("nombre", nombre);
    }

    public String getApellidos() {
        return (String) usuarioData.get("apellidos");
    }

    public void setApellidos(String apellidos) {
        usuarioData.put("apellidos", apellidos);
    }

    public String getEmail() {
        return (String) usuarioData.get("email");
    }

    public void setEmail(String email) {
        usuarioData.put("email", email);
    }

    public String getDireccion() {
        return (String) usuarioData.get("direccion");
    }

    public void setDireccion(String direccion) {
        usuarioData.put("direccion", direccion);
    }

    public String getLocalidad() {
        return (String) usuarioData.get("localidad");
    }

    public void setLocalidad(String localidad) {
        usuarioData.put("localidad", localidad);
    }

    public Compra getCompra() {
        return (Compra) usuarioData.get("compra");
    }

    public void setCompra(Compra compra) {
        usuarioData.put("compra", compra);
    }

    public String getTelefono() {
        return (String) usuarioData.get("telefono");
    }

    public void setTelefono(String telefono) {
        usuarioData.put("telefono", telefono);
    }

    public Venta getVenta() {
        return (Venta) usuarioData.get("venta");
    }

    public void setVenta(Venta venta) {
        usuarioData.put("venta", venta);
    }
}
