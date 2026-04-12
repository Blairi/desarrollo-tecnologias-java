package mx.unam.dgtic.dto;

import lombok.Data;

@Data
public class ReporteInscripcionDTO {
    private int idInscripcion;
    private String nombreEstudiante;
    private String nombreCurso;
    private float calificacion;
}
