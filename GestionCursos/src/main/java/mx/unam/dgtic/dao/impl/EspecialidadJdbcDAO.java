package mx.unam.dgtic.dao.impl;

import mx.unam.dgtic.dao.EspecialidadDAO;
import mx.unam.dgtic.domain.Especialidad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EspecialidadJdbcDAO implements EspecialidadDAO {

    private Connection connection;

    public EspecialidadJdbcDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Especialidad> findAll() {

        List<Especialidad> especialidades = new ArrayList<>();

        String sql = "SELECT * FROM especialidad ORDER BY id_especialidad";

        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {

            while (resultSet.next()) {
                Especialidad especialidad = new Especialidad();
                especialidad.setId(resultSet.getInt("id_especialidad"));
                especialidad.setNombre(resultSet.getString("nombre"));

                especialidades.add(especialidad);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return especialidades;
    }

    @Override
    public Optional<Especialidad> findById(int id) {

        String sql = "SELECT * FROM especialidad WHERE id_especialidad = ?";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ) {

            preparedStatement.setInt(1, id);

            try(
                    ResultSet resultSet = preparedStatement.executeQuery();
            ){

                while (resultSet.next()) {
                    Especialidad especialidad = new Especialidad();
                    especialidad.setId(resultSet.getInt("id_especialidad"));
                    especialidad.setNombre(resultSet.getString("nombre"));

                    return Optional.of(especialidad);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public int insert(Especialidad especialidad) {

        String sql = "INSERT INTO especialidad (nombre) VALUES (?)";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(
                        sql,
                        Statement.RETURN_GENERATED_KEYS
                );
        ) {

            preparedStatement.setString(1, especialidad.getNombre());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {

                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        especialidad.setId(id);
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
    public void update(Especialidad especialidad) {

        String sql = """
            UPDATE especialidad SET 
                nombre = ?
            WHERE id_especialidad = ?
        """;

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(
                        sql
                );
        ) {

            preparedStatement.setString(1, especialidad.getNombre());
            preparedStatement.setInt(2, especialidad.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void delete(int id) {

        String sql = "DELETE FROM especialidad WHERE id_especialidad = ?";

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
