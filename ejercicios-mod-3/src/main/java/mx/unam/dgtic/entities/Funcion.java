package mx.unam.dgtic.entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class Funcion {
    private int idFuncion;
    private LocalDate fecha;
    private LocalTime hora;
    private Pelicula pelicula;
    private Sala sala;

    public Funcion() {
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Funcion{" +
                "idFuncion=" + idFuncion +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", pelicula=" + pelicula +
                ", sala=" + sala +
                '}';
    }
}
