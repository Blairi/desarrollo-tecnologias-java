package mx.unam.dgtic.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.unam.dgtic.entities.Sala;

import java.util.List;

public class SalaDAO implements CineDAO<Sala> {

	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;

	public SalaDAO(){
		this.entityManagerFactory = Persistence.createEntityManagerFactory("micursojpa");
		this.entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public List<Sala> findAll() {
		return List.of();
	}

	@Override
	public Sala findById(int id) {
		try {
			return this.entityManager.find(Sala.class, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(Sala entity) {
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
	public void update(Sala entity) {
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
			Sala sala = entityManager.find(Sala.class, id);
			if (sala != null) {
				entityManager.remove(sala);
			}
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	// Obtener todas las salas con capacidad mayor o igual al valor indicado
	public List<Sala> findByCapacidadMinima(int capacidad) {
		try {
			return entityManager.createQuery(
					"SELECT s FROM Sala s WHERE s.capacidad >= :capacidad", Sala.class)
					.setParameter("capacidad", capacidad)
					.getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// Obtener una sala buscando por su nombre exacto
	public Sala findByNombre(String nombre) {
		try {
			return entityManager.createQuery(
					"SELECT s FROM Sala s WHERE s.nombre = :nombre", Sala.class)
					.setParameter("nombre", nombre)
					.getSingleResult();
		} catch (jakarta.persistence.NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// Obtener todas las salas ordenadas de mayor a menor capacidad
	public List<Sala> findAllOrderByCapacidad() {
		try {
			return entityManager.createQuery(
					"SELECT s FROM Sala s ORDER BY s.capacidad DESC", Sala.class)
					.getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
