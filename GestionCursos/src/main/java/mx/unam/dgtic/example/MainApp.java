package mx.unam.dgtic.example;

import mx.unam.dgtic.domain.Especialidad;
import mx.unam.dgtic.domain.Instructor;
import mx.unam.dgtic.service.InstructorService;
import mx.unam.dgtic.service.impl.InstructorServiceImpl;

public class MainApp {
    public static void main(String[] args) {
        InstructorService instructorService = new InstructorServiceImpl();

        Especialidad geometria = new Especialidad(
                0,
                "Geometria"
        );

        Instructor pedro = new Instructor(
                0,
                "Pedro",
                "Rodriguez",
                "",
                "pedro@unam.mx",
                null
        );

        instructorService.registrarInstrucotorEspecialidad(pedro, geometria);

        Instructor gerardo = new Instructor(
                0,
                "Gerardo",
                "Torres",
                "",
                "gera@unam.mx",
                geometria
        );
        instructorService.registrarInstructor(gerardo);
    }
}
