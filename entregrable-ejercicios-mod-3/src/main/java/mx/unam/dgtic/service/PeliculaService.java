package mx.unam.dgtic.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.unam.dgtic.entities.Pelicula;
import mx.unam.dgtic.repository.IPeliculaRepository;
import mx.unam.dgtic.repository.impl.PeliculaRepository;

import java.util.List;

public class PeliculaService {
    private IPeliculaRepository peliculaRepository;

    public PeliculaService() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("micursojpa");
        EntityManager em = emf.createEntityManager();
        this.peliculaRepository = new PeliculaRepository(em);
    }

    public Pelicula findPeliculaById(int id) {
        return peliculaRepository.findById(id);
    }

    public void displayPelicula(int id) {
        Pelicula pelicula = this.findPeliculaById(id);
        System.out.println("pelicula = " + pelicula);
    }

    public void savePelicula(Pelicula pelicula) {
        if (pelicula.getIdPelicula() == 0) {
            this.peliculaRepository.save(pelicula);
        } else {
            this.peliculaRepository.update(pelicula);
        }
    }

    public void deletePelicula(int id) {
        Pelicula pelicula = this.findPeliculaById(id);
        if (pelicula != null) {
            this.peliculaRepository.delete(pelicula);
        }
    }

    public List<Pelicula> findByDuracionMinima(int minutos) {
        return peliculaRepository.findByDuracionMinima(minutos);
    }

    public List<Pelicula> findByClasificacion(String clasificacion) {
        return peliculaRepository.findByClasificacion(clasificacion);
    }

    public List<Pelicula> findByTituloLike(String fragmento) {
        return peliculaRepository.findByTituloLike(fragmento);
    }

    public List<Pelicula> findAllOrderByDuracion() {
        return peliculaRepository.findAllOrderByDuracion();
    }
}
