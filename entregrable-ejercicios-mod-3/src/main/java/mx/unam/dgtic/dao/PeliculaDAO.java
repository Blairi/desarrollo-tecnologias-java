package mx.unam.dgtic.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.unam.dgtic.entities.Pelicula;

import java.util.List;

public class PeliculaDAO implements CineDAO<Pelicula> {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public PeliculaDAO(){
        this.entityManagerFactory = Persistence.createEntityManagerFactory("micursojpa");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public List<Pelicula> findAll() {
        return List.of();
    }

    @Override
    public Pelicula findById(int id) {
        try {
            return this.entityManager.find(Pelicula.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Pelicula entity) {
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
    public void update(Pelicula entity) {
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
            Pelicula pelicula = entityManager.find(Pelicula.class, id);
            if (pelicula != null) {
    //
                entityManager.remove(pelicula);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    // Obtener todas las películas cuya duración sea mayor o igual al valor indicado
    public List<Pelicula> findByDuracionMinima(int minutos) {
        try {
            return entityManager.createQuery(
                    "SELECT p FROM Pelicula p WHERE p.duracion >= :minutos", Pelicula.class)
                    .setParameter("minutos", minutos)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Obtener todas las películas que coincidan con la clasificación exacta indicada
    public List<Pelicula> findByClasificacion(String clasificacion) {
        try {
            return entityManager.createQuery(
                    "SELECT p FROM Pelicula p WHERE p.clasificacion = :clasificacion", Pelicula.class)
                    .setParameter("clasificacion", clasificacion)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Buscar películas cuyo título contenga el texto indicado, sin importar mayúsculas
    public List<Pelicula> findByTituloLike(String fragmento) {
        try {
            return entityManager.createQuery(
                    "SELECT p FROM Pelicula p WHERE LOWER(p.titulo) LIKE LOWER(:fragmento)", Pelicula.class)
                    .setParameter("fragmento", "%" + fragmento + "%")
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Obtener todas las películas ordenadas de mayor a menor duración
    public List<Pelicula> findAllOrderByDuracion() {
        try {
            return entityManager.createQuery(
                    "SELECT p FROM Pelicula p ORDER BY p.duracion DESC", Pelicula.class)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
