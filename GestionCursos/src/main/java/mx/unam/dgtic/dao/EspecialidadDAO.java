package mx.unam.dgtic.dao;

import mx.unam.dgtic.domain.Especialidad;

import java.util.List;
import java.util.Optional;

public interface EspecialidadDAO {

    List<Especialidad> findAll();
    Optional<Especialidad> findById(int id);
    int insert(Especialidad especialidad);
    void update(Especialidad especialidad);
    void delete(int id);

}
