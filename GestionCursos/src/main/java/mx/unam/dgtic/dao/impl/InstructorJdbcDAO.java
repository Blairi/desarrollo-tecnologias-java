package mx.unam.dgtic.dao.impl;

import mx.unam.dgtic.dao.GenericDAO;
import mx.unam.dgtic.domain.Especialidad;
import mx.unam.dgtic.domain.Instructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InstructorJdbcDAO implements GenericDAO<Instructor> {

    private Connection connection;

    public InstructorJdbcDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Instructor> findAll() {
        List<Instructor> instructores = new ArrayList<>();

        String sql = "SELECT * FROM instructor ORDER BY id_instructor";
        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {

            while (resultSet.next()) {

                Instructor instructor = new Instructor();
                instructor.setId(resultSet.getInt("id_instructor"));
                instructor.setNombre(resultSet.getString("nombre"));
                instructor.setApellidoPaterno(resultSet.getString("apellido_paterno"));
                instructor.setApellidoMaterno(resultSet.getString("apellido_materno"));
                instructor.setCorreoElectronico(resultSet.getString("correo_electronico"));

                Especialidad especialidad = new Especialidad(resultSet.getInt("id_especialidad"));
                instructor.setEspecialidad(especialidad);

                instructores.add(instructor);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return instructores;
    }

    @Override
    public Optional<Instructor> findById(int id) {

        String sql = "SELECT * FROM instructor WHERE id_instructor = ?";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setInt(1, id);

            try(
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                if (resultSet.next()) {
                    Instructor instructor = new Instructor();
                    instructor.setId(resultSet.getInt("id_instructor"));
                    instructor.setNombre(resultSet.getString("nombre"));
                    instructor.setApellidoPaterno(resultSet.getString("apellido_paterno"));
                    instructor.setApellidoMaterno(resultSet.getString("apellido_materno"));
                    instructor.setCorreoElectronico(resultSet.getString("correo_electronico"));

                    instructor.setEspecialidad(
                            new Especialidad(resultSet.getInt("id_especialidad"))
                    );

                    return Optional.of(instructor);

                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return Optional.empty();
    }

    @Override
    public int insert(Instructor instructor) {

        String sql = """
            INSERT INTO instructor (
                nombre, 
                apellido_paterno, 
                apellido_materno,
                correo_electronico,
                id_especialidad
            ) VALUES (?, ?, ?, ?, ?)
        """;

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(
                        sql,
                        Statement.RETURN_GENERATED_KEYS
                );
        ) {

            preparedStatement.setString(1, instructor.getNombre());
            preparedStatement.setString(2, instructor.getApellidoPaterno());
            preparedStatement.setString(3, instructor.getApellidoMaterno());
            preparedStatement.setString(4, instructor.getCorreoElectronico());
            preparedStatement.setInt(5, instructor.getEspecialidad().getId());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        instructor.setId(id);
                        return id;
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    @Override
    public void update(Instructor instructor) {
        String sql = """
            UPDATE instructor SET 
                nombre = ?,
                apellido_paterno = ?,
                apellido_materno = ?,
                correo_electronico = ?,
                id_especialidad = ?
            WHERE id_instructor = ?
        """;

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(
                        sql
                );
        ) {

            preparedStatement.setString(1, instructor.getNombre());
            preparedStatement.setString(2, instructor.getApellidoPaterno());
            preparedStatement.setString(3, instructor.getApellidoMaterno());
            preparedStatement.setString(4, instructor.getCorreoElectronico());
            preparedStatement.setInt(5, instructor.getEspecialidad().getId());
            preparedStatement.setInt(6, instructor.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM instructor WHERE id_instructor = ?";

        try (
                PreparedStatement  preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
