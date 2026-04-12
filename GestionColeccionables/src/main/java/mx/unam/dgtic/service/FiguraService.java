package mx.unam.dgtic.service;

import mx.unam.dgtic.dto.FiguraDTO;
import java.util.List;
import java.util.Optional;

public interface FiguraService {
    List<FiguraDTO> listarTodos();
    Optional<FiguraDTO> buscarPorId(int id);
    void guardar(FiguraDTO figuraDTO);
    void eliminar(int id);
}