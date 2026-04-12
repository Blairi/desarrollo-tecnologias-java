package mx.unam.dgtic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Edicion {
    private int id;
    private String nombre;
    private String descripcion;

    public Edicion(int id) {
        this.id = id;
    }
}