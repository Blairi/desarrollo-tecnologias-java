package mx.unam.dgtic.repository;

import mx.unam.dgtic.entities.Pelicula;

import java.util.List;

public interface IPeliculaRepository extends IRepository<Pelicula, Integer> {
    public List<Pelicula> findByDuracionMinima(int minutos);
    public List<Pelicula> findByClasificacion(String clasificacion);
    public List<Pelicula> findByTituloLike(String fragmento);
    public List<Pelicula> findAllOrderByDuracion();
}
