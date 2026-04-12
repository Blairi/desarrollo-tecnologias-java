package mx.unam.dgtic;


import mx.unam.dgtic.dao.EstudianteDAO;
import mx.unam.dgtic.dao.impl.EstudianteJdbcDAO;
import mx.unam.dgtic.dao.impl.EstudianteListDAO;
import mx.unam.dgtic.db.Conexion;
import mx.unam.dgtic.domain.Estudiante;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainDAO {
    public static void main(String[] args) {


        try {

            // Obtener conexion del DriverManager
            Connection conn = Conexion.getConnection();

            EstudianteDAO estudianteDAO = new EstudianteJdbcDAO(conn);
            //EstudianteDAO estudianteDAO = new EstudianteListDAO();

            List<Estudiante> estudiantes = estudianteDAO.findAll();

            estudiantes.forEach(System.out::println);

            System.out.println(estudiantes.getFirst());

            //for(Estudiante estudiante : estudiantes) {
            //    System.out.println(estudiante);
            //}

            conn.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }
}