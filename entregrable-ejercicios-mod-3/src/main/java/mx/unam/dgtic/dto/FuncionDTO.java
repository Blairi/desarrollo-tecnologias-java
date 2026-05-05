package mx.unam.dgtic.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class FuncionDTO {
    private int idFuncion;
    private LocalDate fecha;
    private LocalTime hora;
    private PeliculaDTO pelicula;
    private SalaDTO sala;

    public FuncionDTO() {
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

    public PeliculaDTO getPelicula() {
        return pelicula;
    }

    public void setPelicula(PeliculaDTO pelicula) {
        this.pelicula = pelicula;
    }

    public SalaDTO getSala() {
        return sala;
    }

    public void setSala(SalaDTO sala) {
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
