package mx.unam.dgtic.dao.impl;

import mx.unam.dgtic.dao.GenericDAO;
import mx.unam.dgtic.domain.Edicion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EdicionDAO implements GenericDAO<Edicion> {

    private Connection connection;

    public EdicionDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Edicion> findAll() {
        List<Edicion> ediciones = new ArrayList<>();
        String sql = "SELECT * FROM edicion ORDER BY id";

        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            while (resultSet.next()) {
                Edicion edicion = new Edicion();
                edicion.setId(resultSet.getInt("id"));
                edicion.setNombre(resultSet.getString("nombre"));
                edicion.setDescripcion(resultSet.getString("descripcion"));
                ediciones.add(edicion);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ediciones;
    }

    @Override
    public Optional<Edicion> findById(int id) {
        String sql = "SELECT * FROM edicion WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Edicion edicion = new Edicion();
                    edicion.setId(resultSet.getInt("id"));
                    edicion.setNombre(resultSet.getString("nombre"));
                    edicion.setDescripcion(resultSet.getString("descripcion"));
                    return Optional.of(edicion);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public int insert(Edicion edicion) {
        String sql = """
            INSERT INTO edicion (nombre, descripcion) 
            VALUES (?, ?)
        """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, edicion.getNombre());
            preparedStatement.setString(2, edicion.getDescripcion());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        edicion.setId(id);
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
    public void update(Edicion edicion) {
        String sql = "UPDATE edicion SET nombre = ?, descripcion = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, edicion.getNombre());
            preparedStatement.setString(2, edicion.getDescripcion());
            preparedStatement.setInt(3, edicion.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM edicion WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}