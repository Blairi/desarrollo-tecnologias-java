package mx.unam.dgtic.dao;

import mx.unam.dgtic.dto.ReporteCursoDTO;

import java.util.List;

public interface ReporteCursoDAO {
    List<ReporteCursoDTO> obtenerReporteInscripcion();
}
