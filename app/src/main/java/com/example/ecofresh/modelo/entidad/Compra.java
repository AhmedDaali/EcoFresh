package com.example.ecofresh.modelo.entidad;

public class Compra {

    private String formaPago = "";

    public Compra(String formaPago) {

        this.formaPago = formaPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

}