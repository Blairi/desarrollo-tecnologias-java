package mx.unam.dgtic.dao.impl;

import mx.unam.dgtic.dao.GenericDAO;
import mx.unam.dgtic.domain.Pais;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PaisDAO implements GenericDAO<Pais> {

    private Connection connection;

    public PaisDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Pais> findAll() {
        List<Pais> paises = new ArrayList<>();
        String sql = "SELECT * FROM pais ORDER BY id";

        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            while (resultSet.next()) {
                Pais pais = new Pais();
                pais.setId(resultSet.getInt("id"));
                pais.setNombre(resultSet.getString("nombre"));
                pais.setCodigo(resultSet.getString("codigo"));
                paises.add(pais);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return paises;
    }

    @Override
    public Optional<Pais> findById(int id) {
        String sql = "SELECT * FROM pais WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Pais pais = new Pais();
                    pais.setId(resultSet.getInt("id"));
                    pais.setNombre(resultSet.getString("nombre"));
                    pais.setCodigo(resultSet.getString("codigo"));
                    return Optional.of(pais);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public int insert(Pais pais) {
        String sql = """
            INSERT INTO pais (nombre, codigo) 
            VALUES (?, ?)
        """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, pais.getNombre());
            preparedStatement.setString(2, pais.getCodigo());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        pais.setId(id);
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
    public void update(Pais pais) {
        String sql = "UPDATE pais SET nombre = ?, codigo = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, pais.getNombre());
            preparedStatement.setString(2, pais.getCodigo());
            preparedStatement.setInt(3, pais.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM pais WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}