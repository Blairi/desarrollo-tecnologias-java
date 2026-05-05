package mx.unam.dgtic.dto;


import java.time.LocalDate;


public class BoletoDTO {

    private int idBoleto;

    private String asiento;
    private LocalDate fechaCompra;

    private FuncionDTO funcion;

    public BoletoDTO() {
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

    public FuncionDTO getFuncion() {
        return funcion;
    }

    public void setFuncion(FuncionDTO funcion) {
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
