package mx.unam.dgtic.dao.impl;

import mx.unam.dgtic.dao.GenericDAO;
import mx.unam.dgtic.domain.Coleccionista;
import mx.unam.dgtic.domain.Figura;
import mx.unam.dgtic.domain.Transaccion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransaccionDAO implements GenericDAO<Transaccion> {

    private Connection connection;

    public TransaccionDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Transaccion> findAll() {
        List<Transaccion> transacciones = new ArrayList<>();
        String sql = "SELECT * FROM transaccion ORDER BY id";

        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            while (resultSet.next()) {
                Transaccion transaccion = new Transaccion();
                transaccion.setId(resultSet.getInt("id"));

                Date sqlDate = resultSet.getDate("fecha");
                if (sqlDate != null) {
                    transaccion.setFecha(sqlDate.toLocalDate());
                }

                transaccion.setPrecioTransaccion(resultSet.getDouble("precio_transaccion"));

                Figura figura = new Figura(resultSet.getInt("id_figura"));
                transaccion.setFigura(figura);

                Coleccionista coleccionista = new Coleccionista(resultSet.getInt("id_coleccionista"));
                transaccion.setColeccionista(coleccionista);

                transacciones.add(transaccion);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return transacciones;
    }

    @Override
    public Optional<Transaccion> findById(int id) {
        String sql = "SELECT * FROM transaccion WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Transaccion transaccion = new Transaccion();
                    transaccion.setId(resultSet.getInt("id"));

                    Date sqlDate = resultSet.getDate("fecha");
                    if (sqlDate != null) {
                        transaccion.setFecha(sqlDate.toLocalDate());
                    }

                    transaccion.setPrecioTransaccion(resultSet.getDouble("precio_transaccion"));

                    Figura figura = new Figura(resultSet.getInt("id_figura"));
                    transaccion.setFigura(figura);

                    Coleccionista coleccionista = new Coleccionista(resultSet.getInt("id_coleccionista"));
                    transaccion.setColeccionista(coleccionista);

                    return Optional.of(transaccion);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public int insert(Transaccion transaccion) {
        String sql = """
            INSERT INTO transaccion (
                fecha, 
                precio_transaccion, 
                id_figura, 
                id_coleccionista
            ) VALUES (?, ?, ?, ?)
        """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setDate(1, Date.valueOf(transaccion.getFecha()));
            preparedStatement.setDouble(2, transaccion.getPrecioTransaccion());
            preparedStatement.setInt(3, transaccion.getFigura().getId());
            preparedStatement.setInt(4, transaccion.getColeccionista().getId());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        transaccion.setId(id);
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
    public void update(Transaccion transaccion) {
        String sql = """
            UPDATE transaccion SET 
                fecha = ?, 
                precio_transaccion = ?, 
                id_figura = ?, 
                id_coleccionista = ? 
            WHERE id = ?
        """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDate(1, Date.valueOf(transaccion.getFecha()));
            preparedStatement.setDouble(2, transaccion.getPrecioTransaccion());
            preparedStatement.setInt(3, transaccion.getFigura().getId());
            preparedStatement.setInt(4, transaccion.getColeccionista().getId());
            preparedStatement.setInt(5, transaccion.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM transaccion WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}