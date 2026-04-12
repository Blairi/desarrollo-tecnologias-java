package mx.unam.dgtic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Figura {
    private int id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaLanzamiento;
    private double precio;
    private Fabricante fabricante;
    private Edicion edicion;

    public Figura(int id) {
        this.id = id;
    }
}