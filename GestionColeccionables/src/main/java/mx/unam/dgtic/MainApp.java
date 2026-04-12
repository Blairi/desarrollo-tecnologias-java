package mx.unam.dgtic;

/*
Axel Fernando Montiel Aviles
Practica 2. Modulo 2
Desarrollo de Sistemas con Tecnologia Java Emision 19
 */

import mx.unam.dgtic.dto.EdicionDTO;
import mx.unam.dgtic.dto.FabricanteDTO;
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
        

        // c. Listar las figuras para verificar que existe un nuevo registro
        // d. Editar alguna Figura
        // e. Listar las figuras para verificar la edición
        // f. Eliminar alguna Figura
        // g. Listar las figuras para verificar la eliminación
    }
}