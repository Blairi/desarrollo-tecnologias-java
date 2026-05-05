package mx.unam.dgtic.repository.impl;

import jakarta.persistence.EntityManager;
import mx.unam.dgtic.entities.Funcion;
import mx.unam.dgtic.repository.IFuncionRepository;
import java.time.LocalDate;
import java.util.List;

public class FuncionRepository implements IFuncionRepository {
	private final EntityManager em;

	public FuncionRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public void save(Funcion entity) {
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
	public void update(Funcion entity) {
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
	public void delete(Funcion entity) {
		try {
			em.getTransaction().begin();
			Funcion toRemove = em.contains(entity) ? entity : em.merge(entity);
			em.remove(toRemove);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Funcion findById(Integer id) {
		try {
			return em.find(Funcion.class, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Funcion> findAll() {
		try {
			return em.createQuery("SELECT f FROM Funcion f", Funcion.class).getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Funcion> findByFecha(LocalDate fecha) {
		try {
			return em.createQuery(
					"SELECT f FROM Funcion f WHERE f.fecha = :fecha", Funcion.class)
					.setParameter("fecha", fecha)
					.getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Funcion> findByIdPelicula(int idPelicula) {
		try {
			return em.createQuery(
					"SELECT f FROM Funcion f WHERE f.pelicula.idPelicula = :idPelicula", Funcion.class)
					.setParameter("idPelicula", idPelicula)
					.getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Funcion> findFromFecha(LocalDate desde) {
		try {
			return em.createQuery(
					"SELECT f FROM Funcion f WHERE f.fecha >= :desde", Funcion.class)
					.setParameter("desde", desde)
					.getResultList();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

    @Override
    public List<Funcion> findByTituloPelicula(String titulo) {
        try {
            return em.createQuery(
                            "SELECT f FROM Funcion f WHERE f.pelicula.titulo = :titulo", Funcion.class)
                    .setParameter("titulo", titulo)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
