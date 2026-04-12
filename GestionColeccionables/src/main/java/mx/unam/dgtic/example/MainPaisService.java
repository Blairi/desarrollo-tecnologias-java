package mx.unam.dgtic.example;

import mx.unam.dgtic.dto.PaisDTO;
import mx.unam.dgtic.service.PaisService;
import mx.unam.dgtic.service.impl.PaisServiceImpl;

import java.util.List;
import java.util.Optional;

public class MainPaisService {

    public static void main(String[] args) {

        PaisService paisService = new PaisServiceImpl();

        System.out.println("===== Listar Todos");
        List<PaisDTO> paises = paisService.listarTodos();
        paises.forEach(System.out::println);

        System.out.println("\n===== Buscar Por Id (1)");
        Optional<PaisDTO> pais = paisService.buscarPorId(1);
        pais.ifPresent(System.out::println);

        System.out.println("\n===== Guardar (Insert)");
        // Mandamos id 0 para que la base de datos lo calcule
        PaisDTO nuevoPais = new PaisDTO(0, "Colombia", "CO");
        paisService.guardar(nuevoPais);
        paises = paisService.listarTodos();
        paises.forEach(System.out::println);

        System.out.println("\n===== Guardar (Update)");
        // Tomamos el ultimo pais
        PaisDTO ultimoPais = paises.get(paises.size() - 1);
        ultimoPais.setNombre("Colombia Actualizado");
        paisService.guardar(ultimoPais);
        paises = paisService.listarTodos();
        paises.forEach(System.out::println);

        System.out.println("\n===== Eliminar");
        paisService.eliminar(ultimoPais.getId());
        paises = paisService.listarTodos();
        paises.forEach(System.out::println);
    }
}