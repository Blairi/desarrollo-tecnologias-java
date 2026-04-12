package mx.unam.dgtic.service;

import mx.unam.dgtic.dto.TransaccionDTO;
import java.util.List;
import java.util.Optional;

public interface TransaccionService {
    List<TransaccionDTO> listarTodos();
    Optional<TransaccionDTO> buscarPorId(int id);
    void guardar(TransaccionDTO transaccionDTO);
    void eliminar(int id);
}