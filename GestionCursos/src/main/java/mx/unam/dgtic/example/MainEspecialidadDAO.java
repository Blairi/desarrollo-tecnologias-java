package mx.unam.dgtic.example;

import mx.unam.dgtic.dao.EspecialidadDAO;
import mx.unam.dgtic.dao.impl.EspecialidadJdbcDAO;
import mx.unam.dgtic.db.Conexion;
import mx.unam.dgtic.domain.Especialidad;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MainEspecialidadDAO {

    public static void main(String[] args) {

        try (Connection conn = Conexion.getConnection();) {

            EspecialidadDAO especialidadDAO = new EspecialidadJdbcDAO(conn);

            System.out.println("===== FindAll");
            List<Especialidad> especialidades = especialidadDAO.findAll();
            especialidades.forEach(System.out::println);

            System.out.println("===== FindById (1)");
            Optional<Especialidad> especialidad = especialidadDAO.findById(1);
            System.out.println(especialidad);

            System.out.println("===== Insert");
            Especialidad nuevaEspecialidad = new Especialidad(
                    0,
                    "Geometría"
            );
            especialidadDAO.insert(nuevaEspecialidad);
            especialidades = especialidadDAO.findAll();
            especialidades.forEach(System.out::println);

            System.out.println("===== Update");
            nuevaEspecialidad.setNombre("Geometría analítica");
            especialidadDAO.update(nuevaEspecialidad);
            especialidades = especialidadDAO.findAll();
            especialidades.forEach(System.out::println);


            System.out.println("===== Delete");
            especialidadDAO.delete(nuevaEspecialidad.getId());
            especialidades = especialidadDAO.findAll();
            especialidades.forEach(System.out::println);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
