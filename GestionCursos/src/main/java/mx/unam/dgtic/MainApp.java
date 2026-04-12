package mx.unam.dgtic;


import mx.unam.dgtic.dao.EstudianteDAO;
import mx.unam.dgtic.dao.impl.EstudianteJdbcDAO;
import mx.unam.dgtic.db.Conexion;
import mx.unam.dgtic.domain.Especialidad;
import mx.unam.dgtic.domain.Estudiante;
import mx.unam.dgtic.domain.Instructor;
import mx.unam.dgtic.service.InstructorService;
import mx.unam.dgtic.service.impl.InstructorServiceImpl;

import java.sql.Connection;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainApp {
    public static void main(String[] args) {

        InstructorService instructorService = new InstructorServiceImpl();

        try {
            instructorService.registrarInstructor(new Instructor(
                    0,
                    "Axel",
                    "Montiel",
                    "Aviles",
                    "axel@maiil.com",
                    new Especialidad(1)
            ));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}