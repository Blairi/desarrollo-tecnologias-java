package mx.unam.dgtic.dao.impl;

import mx.unam.dgtic.dao.GenericDAO;
import mx.unam.dgtic.domain.Coleccionista;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ColeccionistaDAO implements GenericDAO<Coleccionista> {

    private Connection connection;

    public ColeccionistaDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Coleccionista> findAll() {
        List<Coleccionista> coleccionistas = new ArrayList<>();
        String sql = "SELECT * FROM coleccionista ORDER BY id";

        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            while (resultSet.next()) {
                Coleccionista coleccionista = new Coleccionista();
                coleccionista.setId(resultSet.getInt("id"));
                coleccionista.setNombre(resultSet.getString("nombre"));
                coleccionista.setEmail(resultSet.getString("email"));
                coleccionista.setTelefono(resultSet.getString("telefono"));
                coleccionistas.add(coleccionista);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return coleccionistas;
    }

    @Override
    public Optional<Coleccionista> findById(int id) {
        String sql = "SELECT * FROM coleccionista WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Coleccionista coleccionista = new Coleccionista();
                    coleccionista.setId(resultSet.getInt("id"));
                    coleccionista.setNombre(resultSet.getString("nombre"));
                    coleccionista.setEmail(resultSet.getString("email"));
                    coleccionista.setTelefono(resultSet.getString("telefono"));
                    return Optional.of(coleccionista);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public int insert(Coleccionista coleccionista) {
        String sql = """
            INSERT INTO coleccionista (nombre, email, telefono) 
            VALUES (?, ?, ?)
        """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, coleccionista.getNombre());
            preparedStatement.setString(2, coleccionista.getEmail());
            preparedStatement.setString(3, coleccionista.getTelefono());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        coleccionista.setId(id);
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
    public void update(Coleccionista coleccionista) {
        String sql = "UPDATE coleccionista SET nombre = ?, email = ?, telefono = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, coleccionista.getNombre());
            preparedStatement.setString(2, coleccionista.getEmail());
            preparedStatement.setString(3, coleccionista.getTelefono());
            preparedStatement.setInt(4, coleccionista.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM coleccionista WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}