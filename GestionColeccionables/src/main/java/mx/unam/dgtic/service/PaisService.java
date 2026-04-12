package mx.unam.dgtic.service;

import mx.unam.dgtic.dto.PaisDTO;
import java.util.List;
import java.util.Optional;

public interface PaisService {
    List<PaisDTO> listarTodos();
    Optional<PaisDTO> buscarPorId(int id);
    void guardar(PaisDTO paisDTO);
    void eliminar(int id);
}