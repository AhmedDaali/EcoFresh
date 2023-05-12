package com.example.ecofresh.modelo.entidad;
/*
 * Con esta anotación podemos decirle a JPA que esta clase será
 * una tabla de base de datos, la tabla se llamará como la clase
 * en LowerCase.
 * LA CLASE DEBE SEGUIR LA CONVENCIÓN JABABEAN (atributos privados y
 * getter y setter)
 */


//Cambiamos el nombre de la tabla "Productor" por "Productores".

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
