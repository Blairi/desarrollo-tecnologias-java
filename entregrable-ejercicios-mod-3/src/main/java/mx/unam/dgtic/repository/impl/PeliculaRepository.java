package mx.unam.dgtic.repository.impl;

import jakarta.persistence.EntityManager;
import mx.unam.dgtic.entities.Pelicula;
import mx.unam.dgtic.repository.IPeliculaRepository;

import java.util.List;

public class PeliculaRepository implements IPeliculaRepository {

    private final EntityManager em;

    public PeliculaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Pelicula entity) {
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
    public void update(Pelicula entity) {
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
    public void delete(Pelicula entity) {
        try {
            em.getTransaction().begin();
            Pelicula toRemove = em.contains(entity) ? entity : em.merge(entity);
            em.remove(toRemove);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Pelicula findById(Integer integer) {
        try {
            return em.find(Pelicula.class, integer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Pelicula> findAll() {
        try {
            return em.createQuery("SELECT p FROM Pelicula p", Pelicula.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Pelicula> findByDuracionMinima(int minutos) {
        try {
            return em.createQuery(
                            "SELECT p FROM Pelicula p WHERE p.duracion >= :minutos", Pelicula.class)
                    .setParameter("minutos", minutos)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Pelicula> findByClasificacion(String clasificacion) {
        try {
            return em.createQuery(
                            "SELECT p FROM Pelicula p WHERE p.clasificacion = :clasificacion", Pelicula.class)
                    .setParameter("clasificacion", clasificacion)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Pelicula> findByTituloLike(String fragmento) {
        try {
            return em.createQuery(
                            "SELECT p FROM Pelicula p WHERE LOWER(p.titulo) LIKE LOWER(:fragmento)", Pelicula.class)
                    .setParameter("fragmento", "%" + fragmento + "%")
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Pelicula> findAllOrderByDuracion() {
        try {
            return em.createQuery(
                            "SELECT p FROM Pelicula p ORDER BY p.duracion DESC", Pelicula.class)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
