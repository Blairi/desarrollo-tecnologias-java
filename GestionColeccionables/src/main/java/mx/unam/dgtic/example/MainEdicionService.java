package mx.unam.dgtic.example;

import mx.unam.dgtic.dto.EdicionDTO;
import mx.unam.dgtic.service.EdicionService;
import mx.unam.dgtic.service.impl.EdicionServiceImpl;

import java.util.List;
import java.util.Optional;

public class MainEdicionService {

    public static void main(String[] args) {

        EdicionService edicionService = new EdicionServiceImpl();

        System.out.println("===== Listar Todos");
        List<EdicionDTO> ediciones = edicionService.listarTodos();
        ediciones.forEach(System.out::println);

        System.out.println("\n===== Buscar Por Id (1)");
        Optional<EdicionDTO> edicion = edicionService.buscarPorId(1);
        edicion.ifPresent(System.out::println);

        System.out.println("\n===== Guardar (Insert)");
        EdicionDTO nuevaEdicion = new EdicionDTO(0, "Edición Limitada", "Solo 100 piezas producidas");
        edicionService.guardar(nuevaEdicion);
        ediciones = edicionService.listarTodos();
        ediciones.forEach(System.out::println);

        System.out.println("\n===== Guardar (Update)");
        EdicionDTO ultimaEdicion = ediciones.get(ediciones.size() - 1);
        ultimaEdicion.setDescripcion("Solo 50 piezas producidas");
        edicionService.guardar(ultimaEdicion);
        ediciones = edicionService.listarTodos();
        ediciones.forEach(System.out::println);

        System.out.println("\n===== Eliminar");
        edicionService.eliminar(ultimaEdicion.getId());
        ediciones = edicionService.listarTodos();
        ediciones.forEach(System.out::println);
    }
}