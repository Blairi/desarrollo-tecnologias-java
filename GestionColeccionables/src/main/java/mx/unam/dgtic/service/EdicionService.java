package mx.unam.dgtic.service;

import mx.unam.dgtic.dto.EdicionDTO;
import java.util.List;
import java.util.Optional;

public interface EdicionService {
    List<EdicionDTO> listarTodos();
    Optional<EdicionDTO> buscarPorId(int id);
    void guardar(EdicionDTO edicionDTO);
    void eliminar(int id);
}