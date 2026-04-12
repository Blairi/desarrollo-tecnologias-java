package mx.unam.dgtic.dao.impl;

import mx.unam.dgtic.dao.GenericDAO;
import mx.unam.dgtic.domain.Curso;
import mx.unam.dgtic.domain.Instructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CursoDAO implements GenericDAO<Curso> {

    private Connection connection;

    public CursoDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Curso> findAll() {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM curso ORDER BY id_curso";

        try(
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                ){

            while (resultSet.next()) {
                Curso curso = new Curso();
                curso.setId(resultSet.getInt("id_curso"));
                curso.setNombre(resultSet.getString("nombre"));
                curso.setDescripcion(resultSet.getString("descripcion"));
                curso.setDuracion(resultSet.getInt("duracion"));

                Instructor instructor = new Instructor(resultSet.getInt("id_instructor"));
                curso.setInstructor(instructor);

                cursos.add(curso);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return cursos;
    }

    @Override
    public Optional<Curso> findById(int id) {
        String sql = "SELECT * FROM curso WHERE id_curso = ?";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, id);

            try(
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {

                while (resultSet.next()) {
                    Curso curso = new Curso();
                    curso.setId(resultSet.getInt("id_curso"));
                    curso.setNombre(resultSet.getString("nombre"));
                    curso.setDescripcion(resultSet.getString("descripcion"));
                    curso.setDuracion(resultSet.getInt("duracion"));

                    Instructor instructor = new Instructor(resultSet.getInt("id_instructor"));
                    curso.setInstructor(instructor);

                    return Optional.of(curso);

                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public int insert(Curso curso) {
        String sql = """
            INSERT INTO curso (
                nombre,
                descripcion,
                duracion,
                id_instructor
            ) VALUES (?, ?, ?, ?)
        """;

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(
                        sql,
                        Statement.RETURN_GENERATED_KEYS
                );
        ) {

            preparedStatement.setString(1, curso.getNombre());
            preparedStatement.setString(2, curso.getDescripcion());
            preparedStatement.setInt(3, curso.getDuracion());
            preparedStatement.setInt(4, curso.getInstructor().getId());


            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {

                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {

                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        curso.setId(id);
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
    public void update(Curso curso) {
        String sql = """
            UPDATE curso SET
                nombre = ?,
                descripcion = ?,
                duracion = ?,
                id_instructor = ?
            WHERE id_curso = ?
        """;

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(
                        sql
                );
        ) {

            preparedStatement.setString(1, curso.getNombre());
            preparedStatement.setString(2, curso.getDescripcion());
            preparedStatement.setInt(3, curso.getDuracion());
            preparedStatement.setInt(4, curso.getInstructor().getId());
            preparedStatement.setInt(5, curso.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM curso WHERE id_curso = ?";

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
