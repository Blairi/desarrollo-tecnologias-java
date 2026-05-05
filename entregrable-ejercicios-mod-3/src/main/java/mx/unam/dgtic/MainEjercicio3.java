package mx.unam.dgtic;

import mx.unam.dgtic.entities.Boleto;
import mx.unam.dgtic.entities.Funcion;
import mx.unam.dgtic.entities.Pelicula;
import mx.unam.dgtic.entities.Sala;
import mx.unam.dgtic.service.BoletoService;
import mx.unam.dgtic.service.FuncionService;
import mx.unam.dgtic.service.PeliculaService;
import mx.unam.dgtic.service.SalaService;

import java.time.LocalDate;
import java.util.List;

/*
Ejercicio 3.1
 */
public class MainEjercicio3 {
    public static void main(String[] args) {
        /*
            Consultas Pelicula DAO
         */
        PeliculaService peliculaService = new PeliculaService();
        List<Pelicula> peliculas = null;
        // 1
        peliculas = peliculaService.findByDuracionMinima(150);
        peliculas.forEach(System.out::println);
        // 2
        peliculas = peliculaService.findByClasificacion("PG");
        peliculas.forEach(System.out::println);
        // 3
        peliculas = peliculaService.findByTituloLike("Ave");
        peliculas.forEach(System.out::println);
        // 4
        peliculas = peliculaService.findAllOrderByDuracion();
        peliculas.forEach(System.out::println);

        /*
            Consultas Sala DAO
         */
        SalaService salaService = new SalaService();
        List<Sala> salas = null;
        // 1
        salas = salaService.findByCapacidadMinima(200);
        salas.forEach(System.out::println);
        // 2
        System.out.println(salaService.findByNombre("Sala 3 Tradicional"));
        // 3
        salas = salaService.findAllOrderByCapacidad();
        salas.forEach(System.out::println);

        /*
        Funcion DAO
         */
        FuncionService funcionService = new FuncionService();
        List<Funcion> funciones = null;
        // 1
        funciones = funcionService.findByFecha(LocalDate.of(2025, 2, 15));
        funciones.forEach(System.out::println);
        // 2
        funciones = funcionService.findByIdPelicula(2);
        funciones.forEach(System.out::println);
        // 3
        funciones = funcionService.findFromFecha(LocalDate.of(2025, 2, 16));
        funciones.forEach(System.out::println);

        /*
        Boleto DAO
         */
        BoletoService boletoService = new BoletoService();
        List<Boleto> boletos = null;
        // 1
        boletos = boletoService.findByZonaAsiento("A");
        boletos.forEach(System.out::println);
        // 2
        boletos = boletoService.findByIdFuncion(1);
        boletos.forEach(System.out::println);
        // 3
        boletos = boletoService.findByFechaCompra(LocalDate.of(2025, 2, 10));
        boletos.forEach(System.out::println);
        // 4
        Long numBoletos = boletoService.countByIdFuncion(1);
        System.out.println("numBoletos = " + numBoletos);
    }
}