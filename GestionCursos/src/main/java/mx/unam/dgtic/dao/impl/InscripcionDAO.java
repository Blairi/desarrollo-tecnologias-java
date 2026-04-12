package mx.unam.dgtic.dao.impl;

import mx.unam.dgtic.dao.GenericDAO;
import mx.unam.dgtic.domain.Curso;
import mx.unam.dgtic.domain.Estudiante;
import mx.unam.dgtic.domain.Inscripcion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InscripcionDAO implements GenericDAO<Inscripcion> {

    private Connection connection;

    public InscripcionDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Inscripcion> findAll() {
        List<Inscripcion> inscripciones = new ArrayList<>();
        String sql = "SELECT * FROM inscripcion ORDER BY id_inscripcion";

        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {

            while (resultSet.next()) {
                Inscripcion inscripcion = new Inscripcion();
                inscripcion.setId(resultSet.getInt("id_inscripcion"));
                inscripcion.setCalificacion(resultSet.getDouble("calificacion"));
                inscripcion.setFecha(resultSet.getDate("fecha"));

                // Si tu clase Estudiante no tiene el constructor Estudiante(int id),
                // usa new Estudiante() y luego estudiante.setId()
                Estudiante estudiante = new Estudiante(resultSet.getInt("id_estudiante"));
                inscripcion.setEstudiante(estudiante);

                Curso curso = new Curso(resultSet.getInt("id_curso"));
                inscripcion.setCurso(curso);

                inscripciones.add(inscripcion);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return inscripciones;
    }

    @Override
    public Optional<Inscripcion> findById(int id) {
        String sql = "SELECT * FROM inscripcion WHERE id_inscripcion = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Inscripcion inscripcion = new Inscripcion();
                    inscripcion.setId(resultSet.getInt("id_inscripcion"));
                    inscripcion.setCalificacion(resultSet.getDouble("calificacion"));
                    inscripcion.setFecha(resultSet.getDate("fecha"));

                    Estudiante estudiante = new Estudiante(resultSet.getInt("id_estudiante"));
                    inscripcion.setEstudiante(estudiante);

                    Curso curso = new Curso(resultSet.getInt("id_curso"));
                    inscripcion.setCurso(curso);

                    return Optional.of(inscripcion);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public int insert(Inscripcion inscripcion) {
        String sql = """
            INSERT INTO inscripcion (
                calificacion,
                fecha,
                id_estudiante,
                id_curso
            ) VALUES (?, ?, ?, ?)
        """;

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(
                        sql,
                        Statement.RETURN_GENERATED_KEYS
                )
        ) {

            preparedStatement.setDouble(1, inscripcion.getCalificacion());
            preparedStatement.setDate(2, inscripcion.getFecha());
            preparedStatement.setInt(3, inscripcion.getEstudiante().getId());
            preparedStatement.setInt(4, inscripcion.getCurso().getId());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        inscripcion.setId(id);
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
    public void update(Inscripcion inscripcion) {
        String sql = """
            UPDATE inscripcion SET
                calificacion = ?,
                fecha = ?,
                id_estudiante = ?,
                id_curso = ?
            WHERE id_inscripcion = ?
        """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setDouble(1, inscripcion.getCalificacion());
            preparedStatement.setDate(2, inscripcion.getFecha());
            preparedStatement.setInt(3, inscripcion.getEstudiante().getId());
            preparedStatement.setInt(4, inscripcion.getCurso().getId());
            preparedStatement.setInt(5, inscripcion.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM inscripcion WHERE id_inscripcion = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}