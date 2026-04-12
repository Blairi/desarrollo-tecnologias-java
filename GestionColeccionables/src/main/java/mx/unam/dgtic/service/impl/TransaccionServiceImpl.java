package mx.unam.dgtic.service.impl;

import mx.unam.dgtic.dao.impl.TransaccionDAO;
import mx.unam.dgtic.db.Conexion;
import mx.unam.dgtic.domain.Coleccionista;
import mx.unam.dgtic.domain.Figura;
import mx.unam.dgtic.domain.Transaccion;
import mx.unam.dgtic.dto.ColeccionistaDTO;
import mx.unam.dgtic.dto.FiguraDTO;
import mx.unam.dgtic.dto.TransaccionDTO;
import mx.unam.dgtic.service.TransaccionService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TransaccionServiceImpl implements TransaccionService {

    @Override
    public List<TransaccionDTO> listarTodos() {
        try (Connection connection = Conexion.getConnection()) {
            TransaccionDAO dao = new TransaccionDAO(connection);
            return dao.findAll().stream().map(t -> {
                FiguraDTO figDTO = new FiguraDTO();
                figDTO.setId(t.getFigura().getId());

                ColeccionistaDTO colDTO = new ColeccionistaDTO();
                colDTO.setId(t.getColeccionista().getId());

                return new TransaccionDTO(t.getId(), t.getFecha(), t.getPrecioTransaccion(), figDTO, colDTO);
            }).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<TransaccionDTO> buscarPorId(int id) {
        try (Connection connection = Conexion.getConnection()) {
            TransaccionDAO dao = new TransaccionDAO(connection);
            return dao.findById(id).map(t -> {
                FiguraDTO figDTO = new FiguraDTO();
                figDTO.setId(t.getFigura().getId());

                ColeccionistaDTO colDTO = new ColeccionistaDTO();
                colDTO.setId(t.getColeccionista().getId());

                return new TransaccionDTO(t.getId(), t.getFecha(), t.getPrecioTransaccion(), figDTO, colDTO);
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void guardar(TransaccionDTO dto) {
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
            connection.setAutoCommit(false);
            TransaccionDAO dao = new TransaccionDAO(connection);

            Figura figura = new Figura(dto.getFigura().getId());
            Coleccionista coleccionista = new Coleccionista(dto.getColeccionista().getId());
            Transaccion transaccion = new Transaccion(dto.getId(), dto.getFecha(), dto.getPrecioTransaccion(), figura, coleccionista);

            if (dto.getId() == 0) {
                dao.insert(transaccion);
            } else {
                dao.update(transaccion);
            }
            connection.commit();
        } catch (Exception e) {
            try {
                if (connection != null)
                    connection.rollback();
            } catch (SQLException ex) {
                e.addSuppressed(ex);
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
            TransaccionDAO dao = new TransaccionDAO(connection);
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