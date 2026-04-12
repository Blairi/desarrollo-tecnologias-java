package mx.unam.dgtic.service.impl;

import mx.unam.dgtic.dao.impl.FiguraDAO;
import mx.unam.dgtic.db.Conexion;
import mx.unam.dgtic.domain.Edicion;
import mx.unam.dgtic.domain.Fabricante;
import mx.unam.dgtic.domain.Figura;
import mx.unam.dgtic.dto.EdicionDTO;
import mx.unam.dgtic.dto.FabricanteDTO;
import mx.unam.dgtic.dto.FiguraDTO;
import mx.unam.dgtic.service.FiguraService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FiguraServiceImpl implements FiguraService {

    @Override
    public List<FiguraDTO> listarTodos() {
        try (Connection connection = Conexion.getConnection()) {
            FiguraDAO dao = new FiguraDAO(connection);
            return dao.findAll().stream().map(f -> {
                FabricanteDTO fabDTO = new FabricanteDTO();
                fabDTO.setId(f.getFabricante().getId());

                EdicionDTO ediDTO = new EdicionDTO();
                ediDTO.setId(f.getEdicion().getId());

                return new FiguraDTO(f.getId(), f.getNombre(), f.getDescripcion(),
                        f.getFechaLanzamiento(), f.getPrecio(), fabDTO, ediDTO);
            }).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<FiguraDTO> buscarPorId(int id) {
        try (Connection connection = Conexion.getConnection()) {
            FiguraDAO dao = new FiguraDAO(connection);
            return dao.findById(id).map(f -> {
                FabricanteDTO fabDTO = new FabricanteDTO();
                fabDTO.setId(f.getFabricante().getId());

                EdicionDTO ediDTO = new EdicionDTO();
                ediDTO.setId(f.getEdicion().getId());

                return new FiguraDTO(f.getId(), f.getNombre(), f.getDescripcion(),
                        f.getFechaLanzamiento(), f.getPrecio(), fabDTO, ediDTO);
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void guardar(FiguraDTO dto) {
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
            connection.setAutoCommit(false);

            FiguraDAO dao = new FiguraDAO(connection);
            Fabricante fabricante = new Fabricante(dto.getFabricante().getId());
            Edicion edicion = new Edicion(dto.getEdicion().getId());
            Figura figura = new Figura(dto.getId(), dto.getNombre(), dto.getDescripcion(),
                    dto.getFechaLanzamiento(), dto.getPrecio(), fabricante, edicion);

            if (dto.getId() == 0) {
                dao.insert(figura);
            } else {
                dao.update(figura);
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

            FiguraDAO dao = new FiguraDAO(connection);
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