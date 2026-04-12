package mx.unam.dgtic.example;

import mx.unam.dgtic.dao.EstudianteDAO;
import mx.unam.dgtic.dao.impl.EstudianteJdbcDAO;
import mx.unam.dgtic.db.Conexion;
import mx.unam.dgtic.domain.Estudiante;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class MainEstudianteDAO {

    public static void main(String[] args) {


        try (Connection conn = Conexion.getConnection();) {

            EstudianteDAO estudianteDAO = new EstudianteJdbcDAO(conn);

            System.out.println("===== FindAll");
            List<Estudiante> estudiantes = estudianteDAO.findAll();
            estudiantes.forEach(System.out::println);

            System.out.println("===== FindByID (1)");
            Optional<Estudiante> estudiante = estudianteDAO.findById(1);
            System.out.println(estudiante);

            System.out.println("===== Insert");
            Estudiante nuevoEstudiante = new Estudiante(
                    0,
                    "Joaquín",
                    "Ramírez",
                    "",
                    "joaquin@unam.mx",
                    "55555555"
            );
            estudianteDAO.insert(nuevoEstudiante);
            estudiantes = estudianteDAO.findAll();
            estudiantes.forEach(System.out::println);

            System.out.println("===== Update");
            nuevoEstudiante.setApellidoMaterno("Torres");
            estudianteDAO.update(nuevoEstudiante);
            estudiantes = estudianteDAO.findAll();
            estudiantes.forEach(System.out::println);

            System.out.println("===== Delete");
            estudianteDAO.delete(nuevoEstudiante.getId());
            estudiantes = estudianteDAO.findAll();
            estudiantes.forEach(System.out::println);


            // La conexion la cierra el try
            //conn.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }


}
