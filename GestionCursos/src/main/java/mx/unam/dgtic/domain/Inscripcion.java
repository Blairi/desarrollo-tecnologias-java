package mx.unam.dgtic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inscripcion {
    private int id;
    private double calificacion;
    private Date fecha;
    private Estudiante estudiante;
    private Curso curso;

    public Inscripcion(int id) {
        this.id = id;
    }
}