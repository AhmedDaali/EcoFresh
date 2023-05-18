package com.example.ecofresh.modelo.entidad;

public class Venta {

    private float gastos = 0;
    private String categoria ="";
    private String Producto ="";



    public Venta(float gastos, String categoria, String Producto) {

        this.gastos = gastos;
        this.categoria = categoria;
    }

    public float getGastos() {

        return gastos;
    }

    public void setGastos(float gastos) {

        this.gastos = gastos;
    }


}
