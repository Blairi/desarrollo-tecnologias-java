package mx.unam.dgtic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiguraDTO {
    private int id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaLanzamiento;
    private double precio;
    private FabricanteDTO fabricante;
    private EdicionDTO edicion;
}