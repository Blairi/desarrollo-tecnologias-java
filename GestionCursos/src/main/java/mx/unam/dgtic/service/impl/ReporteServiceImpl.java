package mx.unam.dgtic.service.impl;

import mx.unam.dgtic.dao.impl.ReporteInscripcionQueryJdbcDAO;
import mx.unam.dgtic.db.Conexion;
import mx.unam.dgtic.dto.ReporteInscripcionDTO;
import mx.unam.dgtic.service.ReporteService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReporteServiceImpl implements ReporteService {

    @Override
    public List<ReporteInscripcionDTO> generarReporteInscripcion() {
        List<ReporteInscripcionDTO> reporteInscripcionDTOS = new ArrayList<>();
        try (Connection connection = Conexion.getConnection()){
            ReporteInscripcionQueryJdbcDAO reporteInscripcionQueryJdbcDAO = new ReporteInscripcionQueryJdbcDAO(connection);
            reporteInscripcionDTOS = reporteInscripcionQueryJdbcDAO.obtenerReporteInscripcion();
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
        return reporteInscripcionDTOS;
    }
}
