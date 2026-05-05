package mx.unam.dgtic.repository.impl;

import jakarta.persistence.EntityManager;
import mx.unam.dgtic.entities.Boleto;
import mx.unam.dgtic.entities.Funcion;
import mx.unam.dgtic.repository.IBoletoRepository;
import java.time.LocalDate;
import java.util.List;

public class BoletoRepository implements IBoletoRepository {
	private final EntityManager em;

	public BoletoRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public void save(Boleto entity) {
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
	public void update(Boleto entity) {
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
	public void delete(Boleto entity) {
		try {
			em.getTransaction().begin();
			Boleto toRemove = em.contains(entity) ? entity : em.merge(entity);
			em.remove(toRemove);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Boleto findById(Integer id) {
		try {
			return em.find(Boleto.class, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Boleto> findAll() {
		try {
			return em.createQuery("SELECT b FROM Boleto b", Boleto.class).getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Boleto> findByZonaAsiento(String prefijo) {
		try {
			return em.createQuery(
					"SELECT b FROM Boleto b WHERE b.asiento LIKE :prefijo", Boleto.class)
					.setParameter("prefijo", prefijo + "%")
					.getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Boleto> findByIdFuncion(int idFuncion) {
		try {
			return em.createQuery(
					"SELECT b FROM Boleto b WHERE b.funcion.idFuncion = :idFuncion", Boleto.class)
					.setParameter("idFuncion", idFuncion)
					.getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Boleto> findByFechaCompra(LocalDate fecha) {
		try {
			return em.createQuery(
				"SELECT b FROM Boleto b WHERE DATE(b.fechaCompra) = :fecha", Boleto.class)
				.setParameter("fecha", fecha)
				.getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Long countByIdFuncion(int idFuncion) {
		try {
			return em.createQuery(
					"SELECT COUNT(b) FROM Boleto b WHERE b.funcion.idFuncion = :idFuncion", Long.class)
					.setParameter("idFuncion", idFuncion)
					.getSingleResult();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

    @Override
    public List<Boleto> findByFuncionAndFecha(Funcion funcion, LocalDate fecha) {
        try {
            return em.createQuery(
                            "SELECT b FROM Boleto b " +
                                    "WHERE b.funcion = :funcion AND b.funcion.fecha >= :fecha",
                            Boleto.class)
                    .setParameter("funcion", funcion)
                    .setParameter("fecha", fecha)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Object[]> countBoletosPorFuncion() {
        try {
            return em.createQuery(
                    "SELECT f.idFuncion, COUNT(b) " +
                            "FROM Funcion f JOIN f.boletos b " +
                            "GROUP BY f.idFuncion",
                    Object[].class
            ).getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
