package mx.unam.dgtic.service.impl;

import mx.unam.dgtic.dao.impl.PaisDAO;
import mx.unam.dgtic.db.Conexion;
import mx.unam.dgtic.domain.Pais;
import mx.unam.dgtic.dto.PaisDTO;
import mx.unam.dgtic.service.PaisService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PaisServiceImpl implements PaisService {

    @Override
    public List<PaisDTO> listarTodos() {
        try (Connection connection = Conexion.getConnection()) {
            PaisDAO paisDAO = new PaisDAO(connection);
            return paisDAO.findAll().stream()
                    .map(p -> new PaisDTO(p.getId(), p.getNombre(), p.getCodigo()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<PaisDTO> buscarPorId(int id) {
        try (Connection connection = Conexion.getConnection()) {
            PaisDAO paisDAO = new PaisDAO(connection);
            return paisDAO.findById(id)
                    .map(p -> new PaisDTO(p.getId(), p.getNombre(), p.getCodigo()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void guardar(PaisDTO dto) {
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
            connection.setAutoCommit(false);

            PaisDAO paisDAO = new PaisDAO(connection);
            Pais pais = new Pais(dto.getId(), dto.getNombre(), dto.getCodigo());

            if (dto.getId() == 0) {
                paisDAO.insert(pais);
            } else {
                paisDAO.update(pais);
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

            PaisDAO paisDAO = new PaisDAO(connection);
            paisDAO.delete(id);

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