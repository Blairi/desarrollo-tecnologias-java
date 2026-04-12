package mx.unam.dgtic.dao.impl;

import mx.unam.dgtic.dao.GenericDAO;
import mx.unam.dgtic.domain.Fabricante;
import mx.unam.dgtic.domain.Pais;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FabricanteDAO implements GenericDAO<Fabricante> {

    private Connection connection;

    public FabricanteDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Fabricante> findAll() {
        List<Fabricante> fabricantes = new ArrayList<>();
        String sql = "SELECT * FROM fabricante ORDER BY id";

        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            while (resultSet.next()) {
                Fabricante fabricante = new Fabricante();
                fabricante.setId(resultSet.getInt("id"));
                fabricante.setNombre(resultSet.getString("nombre"));

                Pais pais = new Pais(resultSet.getInt("id_pais"));
                fabricante.setPais(pais);

                fabricantes.add(fabricante);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return fabricantes;
    }

    @Override
    public Optional<Fabricante> findById(int id) {
        String sql = "SELECT * FROM fabricante WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Fabricante fabricante = new Fabricante();
                    fabricante.setId(resultSet.getInt("id"));
                    fabricante.setNombre(resultSet.getString("nombre"));

                    Pais pais = new Pais(resultSet.getInt("id_pais"));
                    fabricante.setPais(pais);

                    return Optional.of(fabricante);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public int insert(Fabricante fabricante) {
        String sql = """
            INSERT INTO fabricante (nombre, id_pais) 
            VALUES (?, ?)
        """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, fabricante.getNombre());
            preparedStatement.setInt(2, fabricante.getPais().getId());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        fabricante.setId(id);
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
    public void update(Fabricante fabricante) {
        String sql = "UPDATE fabricante SET nombre = ?, id_pais = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, fabricante.getNombre());
            preparedStatement.setInt(2, fabricante.getPais().getId());
            preparedStatement.setInt(3, fabricante.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM fabricante WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}