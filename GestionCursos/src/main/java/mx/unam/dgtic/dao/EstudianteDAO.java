package mx.unam.dgtic.dao;

import mx.unam.dgtic.domain.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudianteDAO {

    List<Estudiante> findAll();
    Optional<Estudiante> findById(int id);
    int insert(Estudiante estudiante);
    void update(Estudiante estudiante);
    void delete(int id);

}
