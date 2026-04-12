package mx.unam.dgtic.dao.impl;

import mx.unam.dgtic.dao.EstudianteDAO;
import mx.unam.dgtic.domain.Estudiante;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EstudianteListDAO implements EstudianteDAO {

    private List<Estudiante> estudiantes;


    public EstudianteListDAO() {
        estudiantes = new ArrayList<Estudiante>();
        estudiantes.add(new Estudiante(
                1,
                "Mario",
                "Hernández",
                "",
                "mariohm@list.mx",
                "12345678"
        ));

        estudiantes.add(new Estudiante(
                2,
                "Juan",
                "Pérez",
                "",
                "juan.perez@list.mx",
                "12345677"
        ));
    }

    @Override
    public List<Estudiante> findAll() {
        return estudiantes;
    }

    @Override
    public Optional<Estudiante> findById(int id) {
        return Optional.empty();
    }

    @Override
    public int insert(Estudiante estudiante) {
        return 0;
    }

    @Override
    public void update(Estudiante estudiante) {

    }

    @Override
    public void delete(int id) {

    }
}
