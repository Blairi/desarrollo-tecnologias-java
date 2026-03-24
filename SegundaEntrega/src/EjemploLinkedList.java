import java.util.LinkedList;

public class EjemploLinkedList {
    public static void main(String[] args) {
        System.out.println("*** Lista enlazada con LinkedList ***");
        LinkedList<String> lista = new LinkedList<>();
        lista.push("Hugo");
        lista.push("Paco");
        lista.push("Luis");
        lista.push("Daisy");

        System.out.println("lista = " + lista);
        System.out.println(lista.pop());

        System.out.println("lista = " + lista);

        System.out.println(lista.peek());
        System.out.println("lista = " + lista);
    }
}
