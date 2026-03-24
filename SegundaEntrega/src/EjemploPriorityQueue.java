import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class EjemploPriorityQueue {
    public static void main(String[] args) {
        System.out.println("*** Priority Queue ***");
        PriorityQueue<String> cola = new PriorityQueue<>();

        // para agregar elementos usaremos offer
        cola.offer("Paulina");
        cola.offer("Axel");
        cola.offer("Daniel");
        cola.offer("Giovanni");

        System.out.println("cola = " + cola);

        // extraer elementos de la cola con poll
        String persona = cola.poll();
        System.out.println("persona = " + persona);
        System.out.println("Siguiente: " + cola.poll());

        System.out.println("*** PQ con clientes ***");
        PriorityQueue<Cliente> clientes = new PriorityQueue<>();
        clientes.offer(new Cliente("Mardonio"));
        clientes.offer(new Cliente("Andres"));
        clientes.offer(new Cliente("Donovan"));
        clientes.offer(new Cliente("Jose"));

        System.out.println("clientes = " + clientes);

        while (!clientes.isEmpty()) {
            System.out.println("Atendiendo a " + clientes.poll().getUsuario());
            System.out.println("\tLa cola quedo con " + clientes);
        }

        Queue<Radio> radios = new PriorityQueue<>();
        radios.offer(new Radio());
        Radio unRadio = new Radio();
        unRadio.setEncendido(true);
        unRadio.setFrecuencia(125.56);
        unRadio.setVolumen(11);
        radios.offer(unRadio);

        System.out.println("radios = " + radios);
    }
}
