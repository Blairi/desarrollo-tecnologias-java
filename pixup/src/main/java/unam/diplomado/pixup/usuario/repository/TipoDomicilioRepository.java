package unam.diplomado.pixup.usuario.repository;

import unam.diplomado.pixup.usuario.domain.TipoDomicilio;

import java.util.List;
import java.util.Optional;

public interface TipoDomicilioRepository {
    List<TipoDomicilio> findAll();
    Optional<TipoDomicilio> findById(Integer id);
}
