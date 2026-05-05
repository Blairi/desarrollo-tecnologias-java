package mx.unam.dgtic;

import mx.unam.dgtic.entities.Pelicula;
import mx.unam.dgtic.entities.Sala;
import mx.unam.dgtic.service.PeliculaService;
import mx.unam.dgtic.service.SalaService;

/*
Ejercicio 2.1

Aqui solo pruebo las dos entidades que me permite crear y actualizar
sin tener que usar los atributos. En este momento al correr
solo ejecuta los CRUD con pelicula y sala.
 */
public class MainEjercicio2 {
    public static void main(String[] args) {
        // --- Pelicula CRUD ---
        PeliculaService peliculaService = new PeliculaService();
        // a. Insertar un nuevo registro.
        Pelicula movie = new Pelicula();
        movie.setTitulo("Zootopia");
        movie.setClasificacion("PG");
        peliculaService.savePelicula(movie);
        System.out.println("movie = " + movie);
        // b. Consultar registros existentes.
        peliculaService.displayPelicula(movie.getIdPelicula());
        // c. Actualizar registros
        movie.setTitulo("Zootopia 2");
        peliculaService.savePelicula(movie);
        peliculaService.displayPelicula(movie.getIdPelicula());
        // d. Eliminar registros
        peliculaService.deletePelicula(movie.getIdPelicula());

        // --- Sala CRUD ---
        SalaService salaService = new SalaService();
        // a. Insertar un nuevo registro.
        Sala sala = new Sala();
        sala.setNombre("Sala 7 4D");
        sala.setCapacidad(100);
        salaService.saveSala(sala);
        System.out.println("sala = " + sala);
        // b. Consultar registros existentes.
        salaService.displaySala(sala.getIdSala());
        // c. Actualizar registros
        sala.setNombre("Sala 4D VIP");
        salaService.saveSala(sala);
        salaService.displaySala(sala.getIdSala());
        // d. Eliminar registros
        salaService.deleteSala(sala.getIdSala());
    }
}