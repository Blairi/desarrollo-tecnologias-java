package mx.unam.dgtic.dao.impl;

import mx.unam.dgtic.dao.EstudianteDAO;
import mx.unam.dgtic.domain.Estudiante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EstudianteJdbcDAO implements EstudianteDAO {

    private Connection connection;

    public EstudianteJdbcDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Estudiante> findAll() {

        List<Estudiante> estudiantes = new ArrayList<>();

        String sql = "SELECT * FROM estudiante ORDER BY id_estudiante";

        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {

            while (resultSet.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setId(resultSet.getInt("id_estudiante"));
                estudiante.setNombre(resultSet.getString("nombre"));
                estudiante.setApellidoPaterno(resultSet.getString("apellido_paterno"));
                estudiante.setApellidoMaterno(resultSet.getString("apellido_materno"));
                estudiante.setCorreoElectronico(resultSet.getString("correo_electronico"));
                estudiante.setNumeroCuenta(resultSet.getString("numero_cuenta"));

                estudiantes.add(estudiante);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return estudiantes;
    }

    @Override
    public Optional<Estudiante> findById(int id) {

        String sql = "SELECT * FROM estudiante WHERE id_estudiante = ?";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, id);

            try(
                ResultSet resultSet = preparedStatement.executeQuery();
            ) {

                while (resultSet.next()) {
                    Estudiante estudiante = new Estudiante();
                    estudiante.setId(resultSet.getInt("id_estudiante"));
                    estudiante.setNombre(resultSet.getString("nombre"));
                    estudiante.setApellidoPaterno(resultSet.getString("apellido_paterno"));
                    estudiante.setApellidoMaterno(resultSet.getString("apellido_materno"));
                    estudiante.setCorreoElectronico(resultSet.getString("correo_electronico"));
                    estudiante.setNumeroCuenta(resultSet.getString("numero_cuenta"));

                    return Optional.of(estudiante);

                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public int insert(Estudiante estudiante) {

        String sql = """
            INSERT INTO estudiante (
                nombre,
                apellido_paterno,
                apellido_materno,
                correo_electronico,
                numero_cuenta
            ) VALUES (?, ?, ?, ?, ?)
        """;

        try (
            PreparedStatement preparedStatement = connection.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS
            );
        ) {

            preparedStatement.setString(1, estudiante.getNombre());
            preparedStatement.setString(2, estudiante.getApellidoPaterno());
            preparedStatement.setString(3, estudiante.getApellidoMaterno());
            preparedStatement.setString(4, estudiante.getCorreoElectronico());
            preparedStatement.setString(5, estudiante.getNumeroCuenta());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {

                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {

                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        estudiante.setId(id);
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
    public void update(Estudiante estudiante) {
        String sql = """
            UPDATE estudiante SET
                nombre = ?,
                apellido_paterno = ?,
                apellido_materno = ?,
                correo_electronico = ?,
                numero_cuenta = ?
            WHERE id_estudiante = ?
        """;

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(
                        sql
                );
        ) {

            preparedStatement.setString(1, estudiante.getNombre());
            preparedStatement.setString(2, estudiante.getApellidoPaterno());
            preparedStatement.setString(3, estudiante.getApellidoMaterno());
            preparedStatement.setString(4, estudiante.getCorreoElectronico());
            preparedStatement.setString(5, estudiante.getNumeroCuenta());
            preparedStatement.setInt(6, estudiante.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM estudiante WHERE id_estudiante = ?";

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
