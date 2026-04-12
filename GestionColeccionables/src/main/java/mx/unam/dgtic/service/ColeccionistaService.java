package mx.unam.dgtic.service;

import mx.unam.dgtic.dto.ColeccionistaDTO;
import java.util.List;
import java.util.Optional;

public interface ColeccionistaService {
    List<ColeccionistaDTO> listarTodos();
    Optional<ColeccionistaDTO> buscarPorId(int id);
    void guardar(ColeccionistaDTO coleccionistaDTO);
    void eliminar(int id);
}