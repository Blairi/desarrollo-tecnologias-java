package mx.unam.dgtic.dao.impl;

import mx.unam.dgtic.dao.ReporteCursoDAO;
import mx.unam.dgtic.dto.ReporteCursoDTO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReporteCursoJdbcDAOImpl implements ReporteCursoDAO {

    private Connection connection;

    public ReporteCursoJdbcDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<ReporteCursoDTO> obtenerReporteInscripcion() {
        List<ReporteCursoDTO> reporteCurso = new ArrayList<>();
        String sql = "{CALL reporte_cursos()}";

        try(
                CallableStatement callableStatement = connection.prepareCall(sql);
                ResultSet resultSet = callableStatement.executeQuery()
                )
        {
            while (resultSet.next()) {
                ReporteCursoDTO reporteCursoDTO = new ReporteCursoDTO();
                reporteCursoDTO.setNombreCurso(resultSet.getString("nombre_curso"));
                reporteCursoDTO.setNombreInstructor(resultSet.getString("nombre_instructor"));
                reporteCursoDTO.setTotalAlumnos(resultSet.getInt("total_alumnos"));
                reporteCursoDTO.setPromedioCalificacion(resultSet.getFloat("promedio_calificacion"));
                reporteCursoDTO.setPorcentajeAprobacion(resultSet.getFloat("porcentaje_aprobacion"));

                reporteCurso.add(reporteCursoDTO);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return reporteCurso;
    }
}
