package mx.unam.dgtic.service.impl;

import mx.unam.dgtic.dao.impl.ColeccionistaDAO;
import mx.unam.dgtic.db.Conexion;
import mx.unam.dgtic.domain.Coleccionista;
import mx.unam.dgtic.dto.ColeccionistaDTO;
import mx.unam.dgtic.service.ColeccionistaService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ColeccionistaServiceImpl implements ColeccionistaService {

    @Override
    public List<ColeccionistaDTO> listarTodos() {
        try (Connection connection = Conexion.getConnection()) {
            ColeccionistaDAO dao = new ColeccionistaDAO(connection);
            return dao.findAll().stream()
                    .map(c -> new ColeccionistaDTO(c.getId(), c.getNombre(), c.getEmail(), c.getTelefono()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<ColeccionistaDTO> buscarPorId(int id) {
        try (Connection connection = Conexion.getConnection()) {
            ColeccionistaDAO dao = new ColeccionistaDAO(connection);
            return dao.findById(id)
                    .map(c -> new ColeccionistaDTO(c.getId(), c.getNombre(), c.getEmail(), c.getTelefono()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void guardar(ColeccionistaDTO dto) {
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
            connection.setAutoCommit(false);

            ColeccionistaDAO dao = new ColeccionistaDAO(connection);
            Coleccionista coleccionista = new Coleccionista(dto.getId(), dto.getNombre(), dto.getEmail(), dto.getTelefono());

            if (dto.getId() == 0) {
                dao.insert(coleccionista);
            } else {
                dao.update(coleccionista);
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

            ColeccionistaDAO dao = new ColeccionistaDAO(connection);
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