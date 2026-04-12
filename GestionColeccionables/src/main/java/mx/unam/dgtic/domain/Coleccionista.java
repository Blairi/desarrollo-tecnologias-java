package mx.unam.dgtic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coleccionista {
    private int id;
    private String nombre;
    private String email;
    private String telefono;

    public Coleccionista(int id) {
        this.id = id;
    }
}