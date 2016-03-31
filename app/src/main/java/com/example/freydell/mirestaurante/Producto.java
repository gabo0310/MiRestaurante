package com.example.freydell.mirestaurante;

/**
 * Created by gabrielnorena on 21/03/16.
 */
public class Producto {


    private int id;
    private String tipo;
    private String nombre;
    private String descripcion;
    private int precio;

    public Producto() {
    }

    public Producto(String tipo,String nombre,String descripcion, int precio) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getId() {
        return id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio='"+ precio + '\'' +
                '}';
    }





}












