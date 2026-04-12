package mx.unam.dgtic.example;

import mx.unam.dgtic.dao.GenericDAO;
import mx.unam.dgtic.dao.impl.CursoDAO;
import mx.unam.dgtic.db.Conexion;
import mx.unam.dgtic.domain.Curso;
import mx.unam.dgtic.domain.Instructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MainCursoDAO {
    public static void main(String[] args) {

        try (Connection conn = Conexion.getConnection();) {

            GenericDAO<Curso> cursoDAO = new CursoDAO(conn);
            System.out.println("===== FindAll");
            List<Curso> cursos = cursoDAO.findAll();
            cursos.forEach(System.out::println);

            System.out.println("===== FindById (1)");
            Optional<Curso> curso = cursoDAO.findById(1);
            System.out.println(curso);

            Instructor instructor = new Instructor(1);
            Curso nuevoCurso = new Curso(
                    0,
                    "Geometria",
                    "",
                    20,
                    instructor
            );

            System.out.println("===== Insert");
            cursoDAO.insert(nuevoCurso);
            cursos = cursoDAO.findAll();
            cursos.forEach(System.out::println);

            System.out.println("===== Update");
            nuevoCurso.setDescripcion("Un nuevo curso genial");
            cursoDAO.update(nuevoCurso);
            cursos = cursoDAO.findAll();
            cursos.forEach(System.out::println);

            System.out.println("===== Delete");
            cursoDAO.delete(nuevoCurso.getId());
            cursos = cursoDAO.findAll();
            cursos.forEach(System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
