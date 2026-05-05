package mx.unam.dgtic.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.unam.dgtic.entities.Boleto;

import java.time.LocalDate;
import java.util.List;

public class BoletoDAO implements CineDAO<Boleto> {

	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;

	public BoletoDAO(){
		this.entityManagerFactory = Persistence.createEntityManagerFactory("micursojpa");
		this.entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public List<Boleto> findAll() {
		return List.of();
	}

	@Override
	public Boleto findById(int id) {
		try {
			return this.entityManager.find(Boleto.class, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(Boleto entity) {
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
	public void update(Boleto entity) {
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
			Boleto boleto = entityManager.find(Boleto.class, id);
			if (boleto != null) {
				entityManager.remove(boleto);
			}
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	// Obtener boletos cuyo asiento comience con el prefijo indicado (A%, B%, C%)
	public List<Boleto> findByZonaAsiento(String prefijo) {
		try {
			return entityManager.createQuery(
					"SELECT b FROM Boleto b WHERE b.asiento LIKE :prefijo", Boleto.class)
					.setParameter("prefijo", prefijo + "%")
					.getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// Obtener boletos vendidos para una función específica por su ID
	public List<Boleto> findByIdFuncion(int idFuncion) {
		try {
			return entityManager.createQuery(
					"SELECT b FROM Boleto b WHERE b.funcion.idFuncion = :idFuncion", Boleto.class)
					.setParameter("idFuncion", idFuncion)
					.getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// Obtener boletos comprados en una fecha específica (ignorando la hora)
	public List<Boleto> findByFechaCompra(LocalDate fecha) {
		try {
			return entityManager.createQuery(
				"SELECT b FROM Boleto b WHERE DATE(b.fechaCompra) = :fecha", Boleto.class)
				.setParameter("fecha", fecha)
				.getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// Contar cuántos boletos existen para una función
	public Long countByIdFuncion(int idFuncion) {
		try {
			return entityManager.createQuery(
					"SELECT COUNT(b) FROM Boleto b WHERE b.funcion.idFuncion = :idFuncion", Long.class)
					.setParameter("idFuncion", idFuncion)
					.getSingleResult();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
