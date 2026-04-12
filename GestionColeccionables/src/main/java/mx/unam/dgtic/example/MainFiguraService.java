package mx.unam.dgtic.example;

import mx.unam.dgtic.dto.EdicionDTO;
import mx.unam.dgtic.dto.FabricanteDTO;
import mx.unam.dgtic.dto.FiguraDTO;
import mx.unam.dgtic.service.FiguraService;
import mx.unam.dgtic.service.impl.FiguraServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class MainFiguraService {

    public static void main(String[] args) {

        FiguraService figuraService = new FiguraServiceImpl();

        System.out.println("===== Listar Todos");
        List<FiguraDTO> figuras = figuraService.listarTodos();
        figuras.forEach(System.out::println);

        System.out.println("\n===== Buscar Por Id (1)");
        Optional<FiguraDTO> figura = figuraService.buscarPorId(1);
        figura.ifPresent(System.out::println);

        System.out.println("\n===== Guardar (Insert)");
        // Preparamos los DTOs para las relaciones
        FabricanteDTO fabRelacionado = new FabricanteDTO();
        fabRelacionado.setId(1);

        EdicionDTO ediRelacionada = new EdicionDTO();
        ediRelacionada.setId(1);

        FiguraDTO nuevaFigura = new FiguraDTO(
                0,
                "Goku Super Saiyan",
                "Figura articulada",
                LocalDate.of(2023, 10, 15),
                1500.50,
                fabRelacionado,
                ediRelacionada
        );
        figuraService.guardar(nuevaFigura);

        figuras = figuraService.listarTodos();
        figuras.forEach(System.out::println);

        System.out.println("\n===== Guardar (Update)");
        FiguraDTO ultimaFigura = figuras.get(figuras.size() - 1);
        ultimaFigura.setPrecio(1800.00);
        figuraService.guardar(ultimaFigura);

        figuras = figuraService.listarTodos();
        figuras.forEach(System.out::println);

        System.out.println("\n===== Eliminar");
        figuraService.eliminar(ultimaFigura.getId());
        figuras = figuraService.listarTodos();
        figuras.forEach(System.out::println);
    }
}