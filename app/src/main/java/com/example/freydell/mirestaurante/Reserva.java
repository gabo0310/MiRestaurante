package com.example.freydell.mirestaurante;

/**
 * Created by gabrielnorena on 22/03/16.
 */
public class Reserva {
    int id;
    int cedula;
    String fecha;
    String Hora;
    String NumPersonas;


    public Reserva(int cedula, String fecha, String hora, String numPersonas) {

        this.cedula = cedula;
        this.fecha = fecha;
        Hora = hora;
        NumPersonas = numPersonas;
    }


    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public String getNumPersonas() {
        return NumPersonas;
    }

    public void setNumPersonas(String numPersonas) {
        NumPersonas = numPersonas;
    }


    @Override
    public String toString() {
        return "Reserva{" +
                "cedula=" + cedula +
                ", fecha='" + fecha + '\'' +
                ", Hora='" + Hora + '\'' +
                ", NumPersonas='" + NumPersonas + '\'' +
                '}';
    }
}

