package mx.unam.dgtic.service.impl;

import mx.unam.dgtic.dao.EspecialidadDAO;
import mx.unam.dgtic.dao.GenericDAO;
import mx.unam.dgtic.dao.impl.EspecialidadJdbcDAO;
import mx.unam.dgtic.dao.impl.InstructorJdbcDAO;
import mx.unam.dgtic.db.Conexion;
import mx.unam.dgtic.domain.Especialidad;
import mx.unam.dgtic.domain.Instructor;
import mx.unam.dgtic.service.InstructorService;

import java.sql.Connection;
import java.sql.SQLException;

public class InstructorServiceImpl implements InstructorService {

    @Override
    public void registrarInstrucotorEspecialidad(Instructor instructor, Especialidad especialidad) {
        Connection connection = null;
        try
        {
            connection = Conexion.getConnection();
            connection.setAutoCommit(false);

            EspecialidadDAO especialidadDAO = new EspecialidadJdbcDAO(connection);
            GenericDAO<Instructor> instructorDAO = new InstructorJdbcDAO(connection);

            especialidadDAO.insert(especialidad);
            instructor.setEspecialidad(especialidad);

            instructorDAO.insert(instructor);

            connection.commit();

        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void registrarInstructor(Instructor instructor) {
        try (Connection conection = Conexion.getConnection()){
            GenericDAO<Instructor> instructorDAO = new InstructorJdbcDAO(conection);
            instructorDAO.insert(instructor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
