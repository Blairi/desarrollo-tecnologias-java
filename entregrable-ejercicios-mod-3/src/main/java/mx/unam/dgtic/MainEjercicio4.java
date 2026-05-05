package mx.unam.dgtic;

import mx.unam.dgtic.entities.Boleto;
import mx.unam.dgtic.entities.Funcion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/*
Ejercicio 4
 */
public class MainEjercicio4 {
    public static void main(String[] args) {
        // Servicios
        var peliculaService = new mx.unam.dgtic.service.PeliculaService();
        var salaService = new mx.unam.dgtic.service.SalaService();
        var funcionService = new mx.unam.dgtic.service.FuncionService();
        var boletoService = new mx.unam.dgtic.service.BoletoService();

        /*
        Actividad C — Probar las relaciones desde Main (*)
         */
        // 1. Persiste una Funcion asignando objetos Pelicula y Sala ya existentes (findById)
        var pelicula = peliculaService.findPeliculaById(1);
        var sala = salaService.findSalaById(1);

        var funcion = new Funcion();
        funcion.setFecha(LocalDate.now());
        funcion.setHora(LocalTime.of(18, 0));

        funcion.setPelicula(pelicula);
        funcion.setSala(sala);

        funcionService.saveFuncion(funcion);
        System.out.println("Funcion persistida: " + funcion);

        // 2. Recupera una Funcion por ID e imprime el titulo de su Pelicula y el nombre de su Sala
        Funcion funcionRecuperada = funcionService.findFuncionById(1);
        System.out.println("Funcion id=" + funcionRecuperada.getIdFuncion()
                + ", Pelicula: " + funcionRecuperada.getPelicula().getTitulo()
                + ", Sala: " + funcionRecuperada.getSala().getNombre()
        );

        // 3. Recupera un Boleto e imprime la fecha de su Funcion y el titulo de la Pelicula de esa Funcion
        Boleto boleto = boletoService.findBoletoById(1);
        System.out.println("Boleto id=" + boleto.getIdBoleto()
                + ", Fecha Funcion: " + boleto.getFuncion().getFecha()
                + ", Pelicula: " + boleto.getFuncion().getPelicula().getTitulo()
        );

        /*
        Actividad D
        Consultas con relaciones usando JPQL/HQL (+)
         */
        // 1. Buscar todas las funciones de una pelicula especifica por titulo usando JOIN.
        List<Funcion> funcionesEndGame = funcionService.findByTituloPelicula("Avengers: Endgame");
        funcionesEndGame.forEach(System.out::println);

        // 2. Buscar todos los boletos de una funcion en una fecha especifica.
        List<Boleto> boletosList = boletoService.findByFuncionAndFecha(funcionRecuperada, LocalDate.of(2025, 2, 10));
        boletosList.forEach(System.out::println);

        // 3. Contar cuantos boletos tiene cada funcion — agrupado.
        List<Object[]> resultados = boletoService.countBoletosPorFuncion();
        for (Object[] fila : resultados) {
            Integer idFuncion = (Integer) fila[0];
            Long cantidad = (Long) fila[1];
            System.out.println("Funcion " + idFuncion + " -> " + cantidad + " boletos");
        }

        // eliminar funcion que acabamos de crear
        funcionService.deleteFuncion(funcion.getIdFuncion());
    }
}