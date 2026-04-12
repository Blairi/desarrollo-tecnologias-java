package mx.unam.dgtic.service.impl;

import mx.unam.dgtic.dao.impl.FabricanteDAO;
import mx.unam.dgtic.db.Conexion;
import mx.unam.dgtic.domain.Fabricante;
import mx.unam.dgtic.domain.Pais;
import mx.unam.dgtic.dto.FabricanteDTO;
import mx.unam.dgtic.dto.PaisDTO;
import mx.unam.dgtic.service.FabricanteService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FabricanteServiceImpl implements FabricanteService {

    @Override
    public List<FabricanteDTO> listarTodos() {
        try (Connection connection = Conexion.getConnection()) {
            FabricanteDAO dao = new FabricanteDAO(connection);
            return dao.findAll().stream().map(f -> {
                PaisDTO paisDTO = new PaisDTO(f.getPais().getId(), f.getPais().getNombre(), f.getPais().getCodigo());
                return new FabricanteDTO(f.getId(), f.getNombre(), paisDTO);
            }).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<FabricanteDTO> buscarPorId(int id) {
        try (Connection connection = Conexion.getConnection()) {
            FabricanteDAO dao = new FabricanteDAO(connection);
            return dao.findById(id).map(f -> {
                PaisDTO paisDTO = new PaisDTO(f.getPais().getId(), f.getPais().getNombre(), f.getPais().getCodigo());
                return new FabricanteDTO(f.getId(), f.getNombre(), paisDTO);
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void guardar(FabricanteDTO dto) {
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
            connection.setAutoCommit(false);

            FabricanteDAO dao = new FabricanteDAO(connection);
            Pais pais = new Pais(dto.getPais().getId());
            Fabricante fabricante = new Fabricante(dto.getId(), dto.getNombre(), pais);

            if (dto.getId() == 0) {
                dao.insert(fabricante);
            } else {
                dao.update(fabricante);
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

            FabricanteDAO dao = new FabricanteDAO(connection);
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