package mx.unam.dgtic.example;

import mx.unam.dgtic.dao.GenericDAO;
import mx.unam.dgtic.dao.impl.InscripcionDAO;
import mx.unam.dgtic.db.Conexion;
import mx.unam.dgtic.domain.Curso;
import mx.unam.dgtic.domain.Estudiante;
import mx.unam.dgtic.domain.Inscripcion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class MainInscripcionDAO {
    public static void main(String[] args) {

        try (Connection conn = Conexion.getConnection()) {

            GenericDAO<Inscripcion> inscripcionDAO = new InscripcionDAO(conn);

            System.out.println("===== FindAll");
            List<Inscripcion> inscripciones = inscripcionDAO.findAll();
            inscripciones.forEach(System.out::println);


            System.out.println("===== FindById (1)");
            Optional<Inscripcion> inscripcion = inscripcionDAO.findById(1);
            System.out.println(inscripcion);

            Estudiante estudiante = new Estudiante(1);
            Curso curso = new Curso(1);

            Inscripcion nuevaInscripcion = new Inscripcion(
                    0,
                    8.5,
                    Date.valueOf(LocalDate.now()),
                    estudiante,
                    curso
            );

            System.out.println("===== Insert");
            inscripcionDAO.insert(nuevaInscripcion);
            inscripciones = inscripcionDAO.findAll();
            inscripciones.forEach(System.out::println);

            System.out.println("===== Update");
            // Actualizamos la calificación
            nuevaInscripcion.setCalificacion(10.0);
            inscripcionDAO.update(nuevaInscripcion);
            inscripciones = inscripcionDAO.findAll();
            inscripciones.forEach(System.out::println);

            System.out.println("===== Delete");
            inscripcionDAO.delete(nuevaInscripcion.getId());
            inscripciones = inscripcionDAO.findAll();
            inscripciones.forEach(System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException("Error en la conexión o ejecución: " + e.getMessage(), e);
        }

    }
}