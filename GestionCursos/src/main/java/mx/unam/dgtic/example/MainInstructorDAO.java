package mx.unam.dgtic.example;

import mx.unam.dgtic.dao.GenericDAO;
import mx.unam.dgtic.dao.impl.InstructorJdbcDAO;
import mx.unam.dgtic.db.Conexion;
import mx.unam.dgtic.domain.Especialidad;
import mx.unam.dgtic.domain.Instructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MainInstructorDAO {

    public static void main(String[] args) {

        try (Connection conn = Conexion.getConnection();) {

            GenericDAO<Instructor> instructorDAO = new InstructorJdbcDAO(conn);
            System.out.println("===== FindAll");
            List<Instructor> instructores = instructorDAO.findAll();
            instructores.forEach(System.out::println);

            System.out.println("===== FindById (1)");
            Optional<Instructor> instructor = instructorDAO.findById(1);
            System.out.println(instructor);

            Especialidad especialidad = new Especialidad(1);
            Instructor nuevoInstructor = new Instructor(
                    0,
                    "Pedro",
                    "Martínez",
                    "",
                    "pedro@unam.mx",
                    especialidad

            );

            System.out.println("===== Insert");
            instructorDAO.insert(nuevoInstructor);
            instructores = instructorDAO.findAll();
            instructores.forEach(System.out::println);

            System.out.println("===== Update");
            nuevoInstructor.setApellidoMaterno("Pérez");
            instructorDAO.update(nuevoInstructor);
            instructores = instructorDAO.findAll();
            instructores.forEach(System.out::println);

            System.out.println("===== Delete");
            instructorDAO.delete(nuevoInstructor.getId());
            instructores = instructorDAO.findAll();
            instructores.forEach(System.out::println);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
