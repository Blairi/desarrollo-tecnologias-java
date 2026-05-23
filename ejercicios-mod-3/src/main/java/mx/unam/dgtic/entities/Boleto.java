package mx.unam.dgtic.entities;


import java.time.LocalDate;


public class Boleto {

    private int idBoleto;

    private String asiento;
    private LocalDate fechaCompra;

    private Funcion funcion;

    public Boleto() {
    }

    public int getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(int idBoleto) {
        this.idBoleto = idBoleto;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "idBoleto=" + idBoleto +
                ", asiento='" + asiento + '\'' +
                ", fechaCompra=" + fechaCompra +
                ", funcion=" + funcion +
                '}';
    }
}
