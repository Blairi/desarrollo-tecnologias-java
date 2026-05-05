package mx.unam.dgtic.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.unam.dgtic.entities.Funcion;
import mx.unam.dgtic.repository.IFuncionRepository;
import mx.unam.dgtic.repository.impl.FuncionRepository;

import java.time.LocalDate;
import java.util.List;

public class FuncionService {
	private IFuncionRepository funcionRepository;

	public FuncionService() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("micursojpa");
		EntityManager em = emf.createEntityManager();
		this.funcionRepository = new FuncionRepository(em);
	}

	public Funcion findFuncionById(int id) {
		return funcionRepository.findById(id);
	}

	public void displayFuncion(int id) {
		Funcion funcion = this.findFuncionById(id);
		System.out.println("funcion = " + funcion);
	}

	public void saveFuncion(Funcion funcion) {
		if (funcion.getIdFuncion() == 0) {
			this.funcionRepository.save(funcion);
		} else {
			this.funcionRepository.update(funcion);
		}
	}

	public void deleteFuncion(int id) {
		Funcion funcion = this.findFuncionById(id);
		if (funcion != null) {
			this.funcionRepository.delete(funcion);
		}
	}

	public List<Funcion> findByFecha(LocalDate fecha) {
		return funcionRepository.findByFecha(fecha);
	}

	public List<Funcion> findByIdPelicula(int idPelicula) {
		return funcionRepository.findByIdPelicula(idPelicula);
	}

	public List<Funcion> findFromFecha(LocalDate desde) {
		return funcionRepository.findFromFecha(desde);
	}

    public List<Funcion> findByTituloPelicula(String titulo) {
        return funcionRepository.findByTituloPelicula(titulo);
    }
}
