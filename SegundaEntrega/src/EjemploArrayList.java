import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EjemploArrayList {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente());
        clientes.add(new Cliente());
        Cliente clienteBuscado = new Cliente();
        clientes.add(clienteBuscado);
        System.out.println(clientes.contains(new Cliente()));
        clientes.get(1).setUsuario("Spiderman");
        clienteBuscado.setUsuario("Spiderman");
        System.out.println("Spiderman esta en la pos: " + clientes.indexOf(clienteBuscado));

        // Inicializar el ArrayList con valores:
        ArrayList<String> arrayL1 = new ArrayList<>(
                Arrays.asList("Spiderman", "Superman", "Batman")
        );
        System.out.println("Personajes: " + arrayL1);

        ArrayList<String> arrayL2 = new ArrayList<>(
                List.of("Mujer maravilla", "Blackwidow", "She Hulk")
        );
        System.out.println("Personajes: " + arrayL2);

        // ordenamiento
        Collections.sort(arrayL1);
        System.out.println("arrayL1 = " + arrayL1);

        ArrayList<Integer> desordenados = new ArrayList<>(
                Arrays.asList(1, 4, 0, 32, 30, 20)
        );
        System.out.println("desordenados = " + desordenados);
        Collections.sort(desordenados);
        System.out.println("desordenados = " + desordenados);

        System.out.println("clientes = " + clientes.size());
        clientes.get(0).setUsuario("Sheldon");
        clientes.get(1).setUsuario("Leonard");
        clientes.get(2).setUsuario("Howard");
        Collections.sort(clientes);
        System.out.println("clientes = " + clientes);

        ArrayList<Icrud> objetos = new ArrayList<>();
        // ArrayList de objetos cuya clase implemente Icrud
        objetos.add(new Radio());
        objetos.add(new Cliente());
        objetos.add(new ClienteVIP());
        objetos.add(new Asociado());
        System.out.println("Objetos ICRUD: " + objetos);


    }
}
