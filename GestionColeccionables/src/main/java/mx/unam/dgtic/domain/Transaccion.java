package mx.unam.dgtic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaccion {
    private int id;
    private LocalDate fecha;
    private double precioTransaccion;
    private Figura figura;
    private Coleccionista coleccionista;

    public Transaccion(int id) {
        this.id = id;
    }
}