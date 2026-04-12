package mx.unam.dgtic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pais {
    private int id;
    private String nombre;
    private String codigo;

    public Pais(int id) {
        this.id = id;
    }
}
