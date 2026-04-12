package mx.unam.dgtic.example;

import mx.unam.dgtic.dto.ColeccionistaDTO;
import mx.unam.dgtic.service.ColeccionistaService;
import mx.unam.dgtic.service.impl.ColeccionistaServiceImpl;

import java.util.List;
import java.util.Optional;

public class MainColeccionistaService {

    public static void main(String[] args) {

        ColeccionistaService coleccionistaService = new ColeccionistaServiceImpl();

        System.out.println("===== Listar Todos");
        List<ColeccionistaDTO> coleccionistas = coleccionistaService.listarTodos();
        coleccionistas.forEach(System.out::println);

        System.out.println("\n===== Buscar Por Id (1)");
        Optional<ColeccionistaDTO> coleccionista = coleccionistaService.buscarPorId(1);
        coleccionista.ifPresent(System.out::println);

        System.out.println("\n===== Guardar (Insert)");
        ColeccionistaDTO nuevoColeccionista = new ColeccionistaDTO(0, "Axel Montiel", "axel@ejemplo.com", "5512345678");
        coleccionistaService.guardar(nuevoColeccionista);
        coleccionistas = coleccionistaService.listarTodos();
        coleccionistas.forEach(System.out::println);

        System.out.println("\n===== Guardar (Update)");
        ColeccionistaDTO ultimoColeccionista = coleccionistas.get(coleccionistas.size() - 1);
        ultimoColeccionista.setNombre("Axel ACTUALIZADO");
        coleccionistaService.guardar(ultimoColeccionista);
        coleccionistas = coleccionistaService.listarTodos();
        coleccionistas.forEach(System.out::println);

        System.out.println("\n===== Eliminar");
        coleccionistaService.eliminar(ultimoColeccionista.getId());
        coleccionistas = coleccionistaService.listarTodos();
        coleccionistas.forEach(System.out::println);
    }
}