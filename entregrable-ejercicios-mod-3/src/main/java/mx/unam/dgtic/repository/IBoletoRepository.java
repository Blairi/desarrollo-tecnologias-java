package mx.unam.dgtic.repository;

import mx.unam.dgtic.entities.Boleto;
import mx.unam.dgtic.entities.Funcion;

import java.time.LocalDate;
import java.util.List;

public interface IBoletoRepository extends IRepository<Boleto, Integer> {
	List<Boleto> findByZonaAsiento(String prefijo);
	List<Boleto> findByIdFuncion(int idFuncion);
	List<Boleto> findByFechaCompra(LocalDate fecha);
	Long countByIdFuncion(int idFuncion);
    List<Boleto> findByFuncionAndFecha(Funcion funcion, LocalDate fecha);
    List<Object[]> countBoletosPorFuncion();
}
