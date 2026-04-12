package mx.unam.dgtic.service;

import mx.unam.dgtic.dto.FabricanteDTO;
import java.util.List;
import java.util.Optional;

public interface FabricanteService {
    List<FabricanteDTO> listarTodos();
    Optional<FabricanteDTO> buscarPorId(int id);
    void guardar(FabricanteDTO fabricanteDTO);
    void eliminar(int id);
}