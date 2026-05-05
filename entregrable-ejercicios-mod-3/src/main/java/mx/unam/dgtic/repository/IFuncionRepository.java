package mx.unam.dgtic.repository;

import mx.unam.dgtic.entities.Funcion;
import java.time.LocalDate;
import java.util.List;

public interface IFuncionRepository extends IRepository<Funcion, Integer> {
	List<Funcion> findByFecha(LocalDate fecha);
	List<Funcion> findByIdPelicula(int idPelicula);
	List<Funcion> findFromFecha(LocalDate desde);

    List<Funcion> findByTituloPelicula(String titulo);
}
