package mx.unam.dgtic.dao.impl;

import mx.unam.dgtic.dao.ReporteInscripcionQueryDAO;
import mx.unam.dgtic.dto.ReporteInscripcionDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReporteInscripcionQueryJdbcDAO implements ReporteInscripcionQueryDAO {

    private Connection connection;

    public ReporteInscripcionQueryJdbcDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<ReporteInscripcionDTO> obtenerReporteInscripcion() {
        List<ReporteInscripcionDTO> reporteInscripcion = new ArrayList<>();
        String sql = """
                SELECT *
                FROM inscripcion i 
                    JOIN curso c ON i.id_curso = c.id_curso
                    JOIN estudiante e ON i.id_estudiante = e.id
                ORDER BY i.id_curso
                """;

        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)

        ){
            while (resultSet.next()) {
                ReporteInscripcionDTO reporteInscripcionDTO = new ReporteInscripcionDTO();
                reporteInscripcionDTO.setIdInscripcion(resultSet.getInt("id_inscripcion"));
                reporteInscripcionDTO.setCalificacion(resultSet.getFloat("calificacion"));
                reporteInscripcionDTO.setNombreCurso(resultSet.getString("nombre"));
                String nombreEstudiante = resultSet.getString("e.nombre") + " " + resultSet.getString("e.apellido_paterno");
                reporteInscripcionDTO.setNombreEstudiante(nombreEstudiante);

                reporteInscripcion.add(reporteInscripcionDTO);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return  reporteInscripcion;
    }
}
