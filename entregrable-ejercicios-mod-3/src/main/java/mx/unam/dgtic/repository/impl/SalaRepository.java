package mx.unam.dgtic.repository.impl;

import jakarta.persistence.EntityManager;
import mx.unam.dgtic.entities.Sala;
import mx.unam.dgtic.repository.ISalaRepository;
import java.util.List;

public class SalaRepository implements ISalaRepository {
	private final EntityManager em;

	public SalaRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public void save(Sala entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(Sala entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(Sala entity) {
		try {
			em.getTransaction().begin();
			Sala toRemove = em.contains(entity) ? entity : em.merge(entity);
			em.remove(toRemove);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Sala findById(Integer id) {
		try {
			return em.find(Sala.class, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Sala> findAll() {
		try {
			return em.createQuery("SELECT s FROM Sala s", Sala.class).getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Sala> findByCapacidadMinima(int capacidad) {
		try {
			return em.createQuery(
					"SELECT s FROM Sala s WHERE s.capacidad >= :capacidad", Sala.class)
					.setParameter("capacidad", capacidad)
					.getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Sala findByNombre(String nombre) {
		try {
			return em.createQuery(
					"SELECT s FROM Sala s WHERE s.nombre = :nombre", Sala.class)
					.setParameter("nombre", nombre)
					.getSingleResult();
		} catch (jakarta.persistence.NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Sala> findAllOrderByCapacidad() {
		try {
			return em.createQuery(
					"SELECT s FROM Sala s ORDER BY s.capacidad DESC", Sala.class)
					.getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
