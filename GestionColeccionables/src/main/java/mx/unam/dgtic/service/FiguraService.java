package mx.unam.dgtic.service;

import mx.unam.dgtic.domain.Edicion;
import mx.unam.dgtic.domain.Fabricante;
import mx.unam.dgtic.domain.Figura;
import mx.unam.dgtic.dto.FiguraDTO;
import java.util.List;
import java.util.Optional;

public interface FiguraService {
    List<FiguraDTO> listarTodos();
    Optional<FiguraDTO> buscarPorId(int id);
    void registrarFigura(Figura figura, Fabricante fabricante , Edicion edicion);
    void guardar(FiguraDTO figuraDTO);
    void eliminar(int id);
}