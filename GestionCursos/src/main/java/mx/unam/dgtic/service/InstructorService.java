package mx.unam.dgtic.service;

import mx.unam.dgtic.domain.Especialidad;
import mx.unam.dgtic.domain.Instructor;

public interface InstructorService {
    void registrarInstrucotorEspecialidad(Instructor instructor, Especialidad especialidad);
    void registrarInstructor(Instructor instructor);
}
