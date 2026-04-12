package mx.unam.dgtic.dao.impl;

import mx.unam.dgtic.dao.GenericDAO;
import mx.unam.dgtic.domain.Edicion;
import mx.unam.dgtic.domain.Fabricante;
import mx.unam.dgtic.domain.Figura;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FiguraDAO implements GenericDAO<Figura> {

    private Connection connection;

    public FiguraDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Figura> findAll() {
        List<Figura> figuras = new ArrayList<>();
        String sql = "SELECT * FROM figura ORDER BY id";

        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            while (resultSet.next()) {
                Figura figura = new Figura();
                figura.setId(resultSet.getInt("id"));
                figura.setNombre(resultSet.getString("nombre"));
                figura.setDescripcion(resultSet.getString("descripcion"));

                Date sqlDate = resultSet.getDate("fecha_lanzamiento");
                if (sqlDate != null) {
                    figura.setFechaLanzamiento(sqlDate.toLocalDate());
                }

                figura.setPrecio(resultSet.getDouble("precio"));

                Fabricante fabricante = new Fabricante(resultSet.getInt("id_fabricante"));
                figura.setFabricante(fabricante);

                Edicion edicion = new Edicion(resultSet.getInt("id_edicion"));
                figura.setEdicion(edicion);

                figuras.add(figura);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return figuras;
    }

    @Override
    public Optional<Figura> findById(int id) {
        String sql = "SELECT * FROM figura WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Figura figura = new Figura();
                    figura.setId(resultSet.getInt("id"));
                    figura.setNombre(resultSet.getString("nombre"));
                    figura.setDescripcion(resultSet.getString("descripcion"));

                    Date sqlDate = resultSet.getDate("fecha_lanzamiento");
                    if (sqlDate != null) {
                        figura.setFechaLanzamiento(sqlDate.toLocalDate());
                    }

                    figura.setPrecio(resultSet.getDouble("precio"));

                    Fabricante fabricante = new Fabricante(resultSet.getInt("id_fabricante"));
                    figura.setFabricante(fabricante);

                    Edicion edicion = new Edicion(resultSet.getInt("id_edicion"));
                    figura.setEdicion(edicion);

                    return Optional.of(figura);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public int insert(Figura figura) {
        String sql = """
            INSERT INTO figura (
                nombre, 
                descripcion, 
                fecha_lanzamiento, 
                precio, 
                id_fabricante, 
                id_edicion
            ) VALUES (?, ?, ?, ?, ?, ?)
        """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, figura.getNombre());
            preparedStatement.setString(2, figura.getDescripcion());
            preparedStatement.setDate(3, Date.valueOf(figura.getFechaLanzamiento()));
            preparedStatement.setDouble(4, figura.getPrecio());
            preparedStatement.setInt(5, figura.getFabricante().getId());
            preparedStatement.setInt(6, figura.getEdicion().getId());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        figura.setId(id);
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
    public void update(Figura figura) {
        String sql = """
            UPDATE figura SET 
                nombre = ?, 
                descripcion = ?, 
                fecha_lanzamiento = ?, 
                precio = ?, 
                id_fabricante = ?, 
                id_edicion = ? 
            WHERE id = ?
        """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, figura.getNombre());
            preparedStatement.setString(2, figura.getDescripcion());
            preparedStatement.setDate(3, Date.valueOf(figura.getFechaLanzamiento()));
            preparedStatement.setDouble(4, figura.getPrecio());
            preparedStatement.setInt(5, figura.getFabricante().getId());
            preparedStatement.setInt(6, figura.getEdicion().getId());
            preparedStatement.setInt(7, figura.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM figura WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}