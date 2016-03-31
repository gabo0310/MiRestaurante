package com.example.freydell.mirestaurante;

/**
 * Created by gabrielnorena on 22/03/16.
 */
public class Persona {

    private int cedula;
    private String nombre;
    private String email;
    private int telefono;


    public Persona(int cedula, String nombre, String email, int telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "cedula=" + cedula +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
