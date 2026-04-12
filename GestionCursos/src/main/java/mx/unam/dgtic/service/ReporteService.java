package mx.unam.dgtic.service;

import mx.unam.dgtic.dto.ReporteInscripcionDTO;

import java.util.List;

public interface ReporteService {
    List<ReporteInscripcionDTO> generarReporteInscripcion();

}
