package mx.unam.dgtic.repository;

import mx.unam.dgtic.entities.Sala;
import java.util.List;

public interface ISalaRepository extends IRepository<Sala, Integer> {
	List<Sala> findByCapacidadMinima(int capacidad);
	Sala findByNombre(String nombre);
	List<Sala> findAllOrderByCapacidad();
}
