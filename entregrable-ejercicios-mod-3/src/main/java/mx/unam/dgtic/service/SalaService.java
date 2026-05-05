package mx.unam.dgtic.service;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.unam.dgtic.entities.Sala;
import mx.unam.dgtic.repository.ISalaRepository;
import mx.unam.dgtic.repository.impl.SalaRepository;

public class SalaService {
	private ISalaRepository salaRepository;

	public SalaService() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("micursojpa");
		EntityManager em = emf.createEntityManager();
		this.salaRepository = new SalaRepository(em);
	}

	public Sala findSalaById(int id) {
		return salaRepository.findById(id);
	}

	public void displaySala(int id) {
		Sala sala = this.findSalaById(id);
		System.out.println("sala = " + sala);
	}

	public void saveSala(Sala sala) {
		if (sala.getIdSala() == 0) {
			this.salaRepository.save(sala);
		} else {
			this.salaRepository.update(sala);
		}
	}

	public void deleteSala(int id) {
		Sala sala = this.findSalaById(id);
		if (sala != null) {
			this.salaRepository.delete(sala);
		}
	}

	public java.util.List<Sala> findByCapacidadMinima(int capacidad) {
		return salaRepository.findByCapacidadMinima(capacidad);
	}

	public Sala findByNombre(String nombre) {
		return salaRepository.findByNombre(nombre);
	}

	public java.util.List<Sala> findAllOrderByCapacidad() {
		return salaRepository.findAllOrderByCapacidad();
	}
}
