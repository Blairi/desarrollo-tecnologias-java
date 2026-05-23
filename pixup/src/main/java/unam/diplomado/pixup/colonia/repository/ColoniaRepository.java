package unam.diplomado.pixup.colonia.repository;

import unam.diplomado.pixup.colonia.domain.Colonia;

import java.util.List;
import java.util.Optional;

public interface ColoniaRepository {
    List<Colonia> findByCp(String cp);
    Optional<Colonia> findById(Integer id);
}
