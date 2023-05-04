package com.example.ecofresh.modelo.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Con esta anotación podemos decirle a JPA que esta clase será
 * una tabla de base de datos, la tabla se llamará como la clase
 * en LowerCase.
 * LA CLASE DEBE SEGUIR LA CONVENCIÓN JABABEAN (atributos privados y
 * getter y setter)
 */

@Entity

//Cambiamos el nombre de la tabla "usuario" por "usuarios".

@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id = 0;
    private String nombre = "";
    private String apillidos = "";
    private String email = "";
    private String password = "";
    private String direccion = "";
    private String Ciudad = "";
    private String codigoPostal = "";
    private String telefono = "";
    private String dni = "";


    public Usuario(int id, String nombre, String apillidos, String email, String password, String direccion,
                   String ciudad, String codigoPostal, String telefono, String dni) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apillidos = apillidos;
        this.email = email;
        this.password = password;
        this.direccion = direccion;
        Ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.telefono = telefono;
        this.dni = dni;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApillidos() {
        return apillidos;
    }


    public void setApillidos(String apillidos) {
        this.apillidos = apillidos;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getDireccion() {
        return direccion;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public String getCiudad() {
        return Ciudad;
    }


    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }


    public String getCodigoPostal() {
        return codigoPostal;
    }


    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }


    public String getTelefono() {
        return telefono;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public String getDni() {
        return dni;
    }


    public void setDni(String dni) {
        this.dni = dni;
    }


}
