package mx.unam.dgtic.example;

import mx.unam.dgtic.dto.FabricanteDTO;
import mx.unam.dgtic.dto.PaisDTO;
import mx.unam.dgtic.service.FabricanteService;
import mx.unam.dgtic.service.impl.FabricanteServiceImpl;

import java.util.List;
import java.util.Optional;

public class MainFabricanteService {

    public static void main(String[] args) {

        FabricanteService fabricanteService = new FabricanteServiceImpl();

        System.out.println("===== Listar Todos");
        List<FabricanteDTO> fabricantes = fabricanteService.listarTodos();
        fabricantes.forEach(System.out::println);

        System.out.println("\n===== Buscar Por Id (1)");
        Optional<FabricanteDTO> fabricante = fabricanteService.buscarPorId(1);
        fabricante.ifPresent(System.out::println);

        System.out.println("\n===== Guardar (Insert)");
        PaisDTO paisRelacionado = new PaisDTO();
        paisRelacionado.setId(1);

        FabricanteDTO nuevoFabricante = new FabricanteDTO(0, "Bandai Namco", paisRelacionado);
        fabricanteService.guardar(nuevoFabricante);

        fabricantes = fabricanteService.listarTodos();
        fabricantes.forEach(System.out::println);

        System.out.println("\n===== Guardar (Update)");
        FabricanteDTO ultimoFabricante = fabricantes.get(fabricantes.size() - 1);
        ultimoFabricante.setNombre("Bandai Namco Entertainment");
        fabricanteService.guardar(ultimoFabricante);

        fabricantes = fabricanteService.listarTodos();
        fabricantes.forEach(System.out::println);

        System.out.println("\n===== Eliminar");
        fabricanteService.eliminar(ultimoFabricante.getId());
        fabricantes = fabricanteService.listarTodos();
        fabricantes.forEach(System.out::println);
    }
}