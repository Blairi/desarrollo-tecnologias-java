package mx.unam.dgtic.service.impl;

import mx.unam.dgtic.dao.impl.EdicionDAO;
import mx.unam.dgtic.db.Conexion;
import mx.unam.dgtic.domain.Edicion;
import mx.unam.dgtic.dto.EdicionDTO;
import mx.unam.dgtic.service.EdicionService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EdicionServiceImpl implements EdicionService {

    @Override
    public List<EdicionDTO> listarTodos() {
        try (Connection connection = Conexion.getConnection()) {
            EdicionDAO dao = new EdicionDAO(connection);
            return dao.findAll().stream()
                    .map(e -> new EdicionDTO(e.getId(), e.getNombre(), e.getDescripcion()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<EdicionDTO> buscarPorId(int id) {
        try (Connection connection = Conexion.getConnection()) {
            EdicionDAO dao = new EdicionDAO(connection);
            return dao.findById(id)
                    .map(e -> new EdicionDTO(e.getId(), e.getNombre(), e.getDescripcion()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void guardar(EdicionDTO dto) {
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
            connection.setAutoCommit(false);

            EdicionDAO dao = new EdicionDAO(connection);
            Edicion edicion = new Edicion(dto.getId(), dto.getNombre(), dto.getDescripcion());

            if (dto.getId() == 0) {
                dao.insert(edicion);
            } else {
                dao.update(edicion);
            }

            connection.commit();

        } catch (Exception e) {
            try {
                if (connection != null)
                    connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    @Override
    public void eliminar(int id) {
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
            connection.setAutoCommit(false);

            EdicionDAO dao = new EdicionDAO(connection);
            dao.delete(id);

            connection.commit();

        } catch (Exception e) {
            try {
                if (connection != null)
                    connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}