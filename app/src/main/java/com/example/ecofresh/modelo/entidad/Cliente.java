package com.example.ecofresh.modelo.entidad;




//Cambiamos el nombre de la tabla "cliente" por "clientes".


public class Cliente extends Usuario{

    private String formaPago = "";

    public Cliente(int id, String nombre, String apillidos, String email, String password, String direccion,
                   String ciudad, String codigoPostal, String telefono, String dni, String formaPago) {
        super(id, nombre, apillidos, email, password, direccion, ciudad, codigoPostal, telefono, dni);

        this.formaPago = formaPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

}