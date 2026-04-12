package mx.unam.dgtic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    private int id;
    private String nombre;
    private String descripcion;
    private int duracion;
    private Instructor instructor;

    public Curso(int id) {
        this.id = id;
    }
}
