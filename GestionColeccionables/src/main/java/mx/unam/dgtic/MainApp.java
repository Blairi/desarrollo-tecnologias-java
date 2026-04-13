package mx.unam.dgtic;

/*
Axel Fernando Montiel Aviles
Practica 2. Modulo 2
Desarrollo de Sistemas con Tecnologia Java Emision 19
 */

import mx.unam.dgtic.domain.Edicion;
import mx.unam.dgtic.domain.Fabricante;
import mx.unam.dgtic.domain.Figura;
import mx.unam.dgtic.dto.FiguraDTO;
import mx.unam.dgtic.service.FiguraService;
import mx.unam.dgtic.service.impl.FiguraServiceImpl;

import java.time.LocalDate;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        FiguraService figuraService = new FiguraServiceImpl();

        System.out.println("==== Entidad Figura ====");

        // a. Listar las Figuras.
        System.out.println("\ta. Listar las Figuras.");
        List<FiguraDTO> figuras = figuraService.listarTodos();
        figuras.forEach(System.out::println);

        // b. Agregar una Figura
        System.out.println("\tb. Agregar una Figura");
        Fabricante fabricante = new Fabricante();
        fabricante.setId(1); // ya existe en la bd
        Edicion edicion = new Edicion();
        edicion.setId(1); // ya existe en la bd
        Figura nuevaFigura = new Figura(0, "Nueva Figura", "Desc", LocalDate.now(), 500.0, fabricante, edicion);
        System.out.println("nuevaFigura = " + nuevaFigura);
        figuraService.registrarFigura(nuevaFigura, fabricante, edicion);

        // c. Listar las figuras para verificar que existe un nuevo registro
        System.out.println("\tc. Listar las figuras para verificar que existe un nuevo registro");
        figuras = figuraService.listarTodos();
        figuras.forEach(System.out::println);

        // d. Editar alguna Figura
        System.out.println("\td. Editar alguna Figura");
        FiguraDTO figuraEditada = figuras.getLast();
        figuraEditada.setNombre("ACTUALIZADO: Nueva figura");
        figuraEditada.setPrecio(200.0);
        System.out.println("Editando figura por id: " + figuraEditada.getId());
        figuraService.guardar(figuraEditada);

        // e. Listar las figuras para verificar la edición
        System.out.println("\te. Listar las figuras para verificar la edición");
        figuras = figuraService.listarTodos();
        figuras.forEach(System.out::println);

        // f. Eliminar alguna Figura
        System.out.println("\tf. Eliminar alguna Figura");
        System.out.println("Eliminando figura por id: " + figuraEditada.getId());
        figuraService.eliminar(figuraEditada.getId());

        // g. Listar las figuras para verificar la eliminación
        System.out.println("\tg. Listar las figuras para verificar la eliminación");
        figuras = figuraService.listarTodos();
        figuras.forEach(System.out::println);
    }
}