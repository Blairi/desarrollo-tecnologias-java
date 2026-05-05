package mx.unam.dgtic.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.unam.dgtic.entities.Funcion;

import java.time.LocalDate;
import java.util.List;

public class FuncionDAO implements CineDAO<Funcion> {

	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;

	public FuncionDAO(){
		this.entityManagerFactory = Persistence.createEntityManagerFactory("micursojpa");
		this.entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public List<Funcion> findAll() {
		return List.of();
	}

	@Override
	public Funcion findById(int id) {
		try {
			return this.entityManager.find(Funcion.class, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(Funcion entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(Funcion entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(int id) {
		try {
			entityManager.getTransaction().begin();
			Funcion funcion = entityManager.find(Funcion.class, id);
			if (funcion != null) {
				entityManager.remove(funcion);
			}
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	//  Obtener todas las funciones programadas para una fecha específica
	public List<Funcion> findByFecha(LocalDate fecha) {
		try {
			return entityManager.createQuery(
					"SELECT f FROM Funcion f WHERE f.fecha = :fecha", Funcion.class)
					.setParameter("fecha", fecha)
					.getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// Obtener todas las funciones asociadas a una película por su ID
	public List<Funcion> findByIdPelicula(int idPelicula) {
		try {
			return entityManager.createQuery(
					"SELECT f FROM Funcion f WHERE f.pelicula.idPelicula = :idPelicula", Funcion.class)
					.setParameter("idPelicula", idPelicula)
					.getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// Obtener funciones a partir de una fecha (desde esa fecha en adelante)
	public List<Funcion> findFromFecha(LocalDate desde) {
		try {
			return entityManager.createQuery(
					"SELECT f FROM Funcion f WHERE f.fecha >= :desde", Funcion.class)
					.setParameter("desde", desde)
					.getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
