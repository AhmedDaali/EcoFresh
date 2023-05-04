package com.example.ecofresh.modelo.entidad;

public class Productor extends Usuario{

    private float gastos = 0;

    public Productor(int id, String nombre, String apillidos, String email, String password, String direccion,
                     String ciudad, String codigoPostal, String telefono, String dni, float gastos) {
        super(id, nombre, apillidos, email, password, direccion, ciudad, codigoPostal, telefono, dni);

        this.gastos= gastos;
    }

    public float getGastos() {
        return gastos;
    }

    public void setGastos(float gastos) {
        this.gastos = gastos;
    }


}
