import java.util.ArrayDeque;
import java.util.Deque;

public class EjemploCola {
    public static void main(String[] args) {
        System.out.println("*** Colas en Java ***");
        Deque<String> personas = new ArrayDeque<>();


        // agregamos
        personas.offer("Bryan");
        personas.offer("Aaron");
        personas.offer("Andrea");
        personas.offer("Andres");

        System.out.println("Personas " + personas);

        System.out.println("poll (): " + personas.poll());
    }
}
