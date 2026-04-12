package mx.unam.dgtic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FabricanteDTO {
    private int id;
    private String nombre;
    private PaisDTO pais;
}