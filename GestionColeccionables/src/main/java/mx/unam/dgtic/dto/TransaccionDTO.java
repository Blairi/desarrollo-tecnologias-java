package mx.unam.dgtic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransaccionDTO {
    private int id;
    private LocalDate fecha;
    private double precioTransaccion;
    private FiguraDTO figura;
    private ColeccionistaDTO coleccionista;
}